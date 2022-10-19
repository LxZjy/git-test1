package HomeWorker;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HomeWorker01Sever {
    public static void main(String[] args) throws IOException {
        ServerSocket servesocket = new ServerSocket(9999);
        System.out.println("服务端，在9999端口监听，等待连接...");
        Socket socket = servesocket.accept();

        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        String answer="";
        if ("name".equals(s)){
            answer="猜猜我是谁";
        }else if ("hobby".equals(s)){
            answer="编写java程序";
        }else {
            answer="你说的什么";
        }
        //获取socket相关联的输出流
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write(answer);
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }
}
