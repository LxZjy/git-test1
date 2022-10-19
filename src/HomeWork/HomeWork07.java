package HomeWork;

public class HomeWork07 {
    public static void main(String[] args) {
        Color green = Color.GREEN;
        green.show();
        switch (green){
            case YELLOW:
            System.out.println("匹配到黄色");
            case RED:
                System.out.println("匹配到红色");
            case GREEN:
                System.out.println("匹配到绿色");
        }
    }
}
interface IMyInterface{
    public void show();

}
enum Color implements IMyInterface{
   RED(255,0,0),BLUE(0,0,0)
   ,YELLOW(255,255,0),GREEN(0,255,0);
    private int redValue;
    private int blueValue;
    private int greenValue;

    Color(int redValue, int blueValue, int greenValue) {
        this.redValue = redValue;
        this.blueValue = blueValue;
        this.greenValue = greenValue;
    }

    @Override
    public void show() {
        System.out.println("属性值为:"+redValue+","+blueValue+","+greenValue);
    }
}