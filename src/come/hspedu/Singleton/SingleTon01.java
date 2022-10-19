package come.hspedu.Singleton;
//饿汉式单例模式
public class SingleTon01 {
    public static void main(String[] args) {
        GirlFriend instance = GirlFriend.getInstance();
        System.out.println(instance);

    }
}
class GirlFriend{
    private String name;    
    private static int n1=100;

    private static GirlFriend gf=new GirlFriend("小红");
    //提供一个公共的静态方法，返回gf对象

    private GirlFriend(String name) {
        System.out.println("构造器被调用");
        this.name = name;
    }
    public static GirlFriend getInstance(){
        return gf;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                '}';
    }
}