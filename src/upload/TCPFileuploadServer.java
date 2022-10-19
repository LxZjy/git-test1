package upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPFileuploadServer {
    public static void main(String[] args) throws Exception {
        //服务端在本机监听8888端口
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端在8888端口监听");
        //等待连接
        Socket socket = serverSocket.accept();


        //3.读取客户端发送的数据
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        //4.将得到的bytes数组写入到指定的路径，就得到一个文件
        String destFilePath = "src\\pig2.png";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
        bos.write(bytes);
        bos.close();

        //向客户端回复“收到图片
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write("收到图片");
        writer.flush();//把内容刷新
        socket.shutdownOutput();//设置结束标记


        //关闭其他资源
        writer.close();
        bis.close();
        socket.close();
        serverSocket.close();
    }
}
