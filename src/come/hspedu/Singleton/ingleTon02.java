package come.hspedu.Singleton;
//懒汉式单例设计模式
public class ingleTon02 {
    public static void main(String[] args) {
   // System.out.println(Cat.n1);
        Cat cat = Cat.getInstance();
        System.out.println(cat);
    }
}
//希望在程序运行过程中，只能创建一个Cat对象
class  Cat{
    public static int n1=999;
    private static Cat cat;
    private String name;
    /*
    /1.仍然将构造器私有化
     2.定义一个静态属性对象
     3.提供一个public的static方法，可以返回一个Cat对象
     */

    private Cat(String name) {
        System.out.println("构造器被调用");
        this.name = name;
    }
    public static Cat getInstance(){
        if (cat==null){
            cat = new Cat("小可爱");
        }
        return cat;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
