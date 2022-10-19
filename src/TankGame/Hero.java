package TankGame;

public class Hero extends Tank {
    //创建一个shot对象
    Shout shout = null;

    public Hero(int x, int y) {
        super(x, y);
    }

    //射击
    public void shotEnmyTank() {
        //创建shot对象
        switch (getDirect()) {//得到hero方向
            case 0://上
                shout = new Shout(getX() + 20, getY(), 0);
                break;
            case 1://右
                shout = new Shout(getX() + 60, getY() + 20, 1);
                break;
            case 2://下
                shout = new Shout(getX() + 20, getY() + 60, 2);
                break;
            case 3://左
                shout = new Shout(getX(), getY() + 20, 3);
                break;
        }
        //启动shot线程
        new Thread(shout).start();
    }
}
