package HomeWork;

public class HomeWork04 {
    public static void main(String[] args) {
        A a = new A();
        a.f1();
    }
}

class A {
    private String name="hello";

    public void f1() {
        class B {//局部内部类
            private final String name = "小李";

            public void show() {
                System.out.println("名称:" + name+" 外部类的name:"+A.this.name);
            }
        }
        B b = new B();
        b.show();
    }
}