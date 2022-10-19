package upload;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPFileUploadClient {
    public static void main(String[] args) throws Exception {

        //创建客户端连接，得到Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        //创建读取磁盘文件的输入流
        String filePaht = "e:\\pig.png";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePaht));
        //bytes就是filePath对应的字节内容
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        //通过socket获取到一个输出流将bytes数据发送给服务端
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);//将文件对应的字节数组写入数据通道
        //结束标志
        bis.close();
        socket.shutdownOutput();//设置写入数据结束的标记

        InputStream inputStream = socket.getInputStream();
        String s = StreamUtils.streamToString(inputStream);


        //关闭相关的流
        inputStream.close();
        bos.close();
        socket.close();
    }
}
