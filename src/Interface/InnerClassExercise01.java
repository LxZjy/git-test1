package Interface;

public class InnerClassExercise01 {
    public static void main(String[] args) {
        Celphone celphone = new Celphone();
        //1.实现了Bell接口的匿名内部类
        //2.重写了ring方法
        celphone.alarmclock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });
        celphone.alarmclock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴上课了");
            }
        });
    }
}
interface Bell{
    void ring();
}
class Celphone{
    public void alarmclock(Bell bell){
        bell.ring();
    }
}

