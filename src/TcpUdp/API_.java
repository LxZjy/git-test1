package TcpUdp;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class API_ {
    public static void main(String[] args) throws UnknownHostException {
        //获取本机InetAddress对象
        InetAddress localHost = InetAddress.getLocalHost();//获取电脑名和ip地址
        System.out.println(localHost);//DESKTOP-AV48Q3E/192.168.31.244
        //2.根据指定的主机名，获取InetAddress对象
        InetAddress host = InetAddress.getByName("DESKTOP-AV48Q3E");//获得电脑名和ip地址
        System.out.println("host="+host);
        InetAddress baidu = InetAddress.getByName("www.baidu.com");//域名和ip地址
        System.out.println(baidu);
        String hostAddress = baidu.getHostAddress();//ip地址
        System.out.println(hostAddress);
    }
}
