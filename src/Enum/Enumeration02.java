package Enum;

public class Enumeration02 {
    public static void main(String[] args) {
        System.out.println(Season1.AUTUMN);
        System.out.println(Season1.SPRING);
    }
}

enum Season1 {
    //如果使用了enum来实现枚举
    //1.使用关键字enum替代class
    //2.public static final Season SPRING = new Season("春天", "温暖");
    // 直接使用SPRING("春天", "温暖")
    //3.如果有多个常量对象,使用","间隔即可
    //4.如果适用enum来实现枚举，需要将定义常量对象，写在前面
    SPRING("春天", "温暖"), WINTER("冬天", "寒冷"), AUTUMN("秋天", "凉爽"), SUMMER("夏天", "炎热");

    private String name;
    private String desc;

    //    //定义了四个固定的对象
//    public static final Season SPRING = new Season("春天", "温暖");
//    public static final Season WINTER = new Season("冬天", "寒冷");
//    public static final Season AUTUMN = new Season("秋天", "凉爽");
//    public static final Season SUMMER = new Season("夏天", "炎热");
    private Season1(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}