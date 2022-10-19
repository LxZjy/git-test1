package TcpUdp;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;


public class SocketTCP01 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("服务端socket返回=" + socket.getClass());
        //得到和socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //通过输出流，写入到数据通道
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello,world 字符流");
        bufferedWriter.newLine();//换行符,写入内容的结束，要求对方使用readLine()!!!!
        bufferedWriter.flush();//如果使用的字符流，需要手动刷新，负责不会写入数据通道

        //关闭流对象和socket，必须关闭，要么造成资源浪费
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readLen=0;
        while ((readLen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, readLen));
        }
        OutputStream outputStream1 = socket.getOutputStream();
        outputStream1.write("hello,client".getBytes());
        //设置结束标记
        socket.shutdownOutput();
        inputStream.close();
        outputStream1.close();
        outputStream.close();
        socket.close();
        System.out.println("客户端退出");

    }
}
