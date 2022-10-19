package HomeWork;

public class HomeWork06 {
    public static void main(String[] args) {
        Car car = new Car(60);
       car.getAir().flow();
        Car car1 = new Car(-1);
        car1.getAir().flow();
    }
}
class  Car{
    private double temperature;

    public Car(double temperature) {
        this.temperature = temperature;
    }
    class Air{
        public void flow(){
            if (temperature>40){
                System.out.println("温度大于40，空调出冷气");
            }else if (temperature<0){
                System.out.println("温度小于0，空调吹暖气");
            }else {
                System.out.println("温度正常，关闭空调");
            }
        }
    }
    //返回Air对象
    public Air getAir(){
        return new Air();
    }
}
