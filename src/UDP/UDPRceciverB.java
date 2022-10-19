package UDP;
 
import java.io.IOException;
import java.net.*;

public class UDPRceciverB {
    public static void main(String[] args) throws IOException {
        //创建DatagramSocket对象，准备在9998端口接收数据
        DatagramSocket socket = new DatagramSocket(9998);
        //将需要发送的数据封装到DatagramPacket对象
        byte[] data = "hello,明天吃火锅~".getBytes();
        DatagramPacket packet = new DatagramPacket(data,0,data.length, InetAddress.getByName("192.168.12.1"),9999);

        socket.send(packet);
        socket.close();
        System.out.println("B端退出");
    }
}
