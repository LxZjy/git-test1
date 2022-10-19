package HomeWorker;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class HomeWorker02Client {
    public static void main(String[] args) throws Exception {
        //接入用户输入，指定下载文件名
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入下载的文件名");
        String downloadFileName = scanner.next();
        //客户端连接服务端，准备发送
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //获取socket关联的输出流
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(downloadFileName.getBytes());
        //设置结束标志
        socket.shutdownOutput();
        // 读取服务端返回的文件
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        //得到一个输出流,将bytes写到磁盘文件
        String filePath="e:\\"+downloadFileName+".mp3";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        bos.write(bytes);
        //关闭相关资源
        bos.close();
        bis.close();
        socket.close();
        outputStream.close();
        System.out.println("客户端下载完毕，正在退出");
    }
}
