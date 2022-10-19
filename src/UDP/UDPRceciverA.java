package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPRceciverA {
    public static void main(String[] args) throws IOException {
        //创建一个DatagramSocket对象，准备在9999端口准备接收对象
        DatagramSocket socket = new DatagramSocket(9999);
        //2.创建一个DatagramPacket对象，准备接收数据
        //在前面讲解udp协议时。一个数据包最大是64k
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf,buf.length);
        //3.调用接收方法
        System.out.println("接收端A 等待接收数据...");
        socket.receive(packet);
        //可以把packet进行一个拆包，取出数据并显示
        int length = packet.getLength();//实际接收到数据字节长度
        byte[] data = packet.getData();//接收到的数据
        java.lang.String s = new java.lang.String(data, 0, length);
        System.out.println(s);
        socket.close();
        System.out.println("A端退出");
    }
}
