package Interface;

public class Employee {
    public static void main(String[] args) {
        outer05 outer05 = new outer05();
        outer05.f1();
    }
}
class Person{
    public void hi(){
        System.out.println("Person hi()");
    }
    public void ok(String str){
        System.out.println("Person ok()"+str);
    }
}
class  outer05{
    private int n1=99;
    public void f1(){
        Person person=new Person(){
            @Override
            public void hi() {
                System.out.println("匿名内部类重写了hi方法");
            }
        };
        person.hi();//动态绑定
        new Person(){
            @Override
            public void hi() {
              System.out.println("匿名内部类重写了hi方法，哈哈。。。");
            }

            @Override
            public void ok(String str) {
                super.ok(str);
            }
        }.ok("jack");
    }
}