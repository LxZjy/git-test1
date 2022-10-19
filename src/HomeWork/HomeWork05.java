package HomeWork;

public class HomeWork05 {
    public static void main(String[] args) {
        Person person = new Person("唐僧", new Horse());
        Person person1 = new Person("海王", new Boat());
        Person person2 = new Person("孙悟空", new Plane());
        person.passRiver();
        person.common();
        person2.passFireHill();
    }
}

interface Vehicles {
    public void work();
}

class Horse implements Vehicles {
    @Override
    public void work() {
        System.out.println("一般情况下,使用马儿前进...");
    }
}

class Boat implements Vehicles {
    @Override
    public void work() {
        System.out.println("过河的时候，我们使用小船...");
    }
}
class Plane implements Vehicles{
    @Override
    public void work() {
        System.out.println("过火焰山，使用飞机...");
    }
}

class Person {
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    //实例化Person对象，一般情况下使用马作为交通工具，遇到大河时使用船作为交通工具
    public void passRiver() {
        if (!(vehicles instanceof Boat)) {
            vehicles = VehiclesFactory.getBoat();
        }
        vehicles.work();
    }

    public void common() {
        if (!(vehicles instanceof Horse )) {
            //这里使用的是多态
            vehicles = VehiclesFactory.getHorse();
        }
        vehicles.work();
    }
    public void passFireHill(){
          if (!(vehicles instanceof Plane)){
              vehicles=VehiclesFactory.getPlane();
          }
          vehicles.work();
    }
}
