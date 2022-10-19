package TcpUdp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Socket_ {
    public static void main(String[] args) throws IOException {
        //在本机的9999端口监听，等待连接
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("等待连接");
        //如果有客户端连接，则会返回一个socket对象，程序继续
        Socket socket = serverSocket.accept();//通过Socket多个客户端连接服务器的并发
        System.out.println("服务端 socket=" + socket.getClass());
        //通过 socket.getInputStream();写入数据到通道
        InputStream inputStream = socket.getInputStream();
        //通过io读取，使用字符流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);//输出
        //关闭流
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
