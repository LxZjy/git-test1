package Interface;

public class MbmberInnerClass01 {
    public static void main(String[] args) {
        Outer04 outer04 = new Outer04();
        Outer04.Inner04 inner04 = outer04.new Inner04();
        inner04.say();
    }
}
class  Outer04{
    private int n1=10;
    public String name="张三";
    private    void  hi(){
        System.out.println("hi()方法...");
    }
  public   class  Inner04{
        private double sal=99.9;
        private int n1=50;
        public void say(){
            System.out.println("n1="+n1+"name"+name+"外部类的n1="+Outer04.this.n1);
            hi();
        }
    }
    public void t1(){
        //使用了成员内部类
        //创建成员内部类的对象然后使用相关的方法
        Inner04 inner04 = new Inner04();
        inner04.say();
       System.out.println( inner04.sal);
    }
}

