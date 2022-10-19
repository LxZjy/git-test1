package HomeWorker;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HomeWorker02Sever {
    public static void main(String[] args) throws Exception {
        //1.监听9999端口等待客户端连接并下载文件名称
        ServerSocket serverSocket = new ServerSocket(9999);
        //2.等待客户连接
        Socket socket = serverSocket.accept();
        //3.读取客户端发送的要下载的文件名
        InputStream inputStream = socket.getInputStream();
        //4.写入到一个字节数组中
        byte[] buf = new byte[1024];
        int len = 0;
        String downloadFileName = "";
        while ((len = inputStream.read(buf)) != -1) {
            downloadFileName += new String(buf, 0, len);
        }
        System.out.println("客户端希望下载文件名=" + downloadFileName);

        //老师在服务器上有文件
        String resFileName="";
        if ("萧忆情Alex - 如愿".equals(downloadFileName)){
            resFileName="src\\萧忆情Alex - 如愿.mp3";
        }else {
            resFileName="src\\乔佳旭 - 雪下的时候.mp3";
        }
        //5.创建一个输入流读取文件
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(resFileName));
        //使用工具类StreamUtils，读取文件到一个字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        //在得到Socket关联的输出流
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        //7.写入到数据通道，返回给客户端
        bos.write(bytes);
        socket.shutdownOutput();
        //关闭相关资源
        bis.close();
        socket.close();
        serverSocket.close();
        inputStream.close();
        System.out.println("服务端退出");
    }
}
