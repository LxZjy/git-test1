package TankGame;

public class Shout implements Runnable {
    //子弹坐标和方向
    int x;
    int y;
    int direct = 0;
    int speed = 2;
    boolean isLive = true;//子弹是否存活

    public Shout(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {//射击

        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch (direct) {
                case 0://上
                    y -= speed;
                    break;
                case 1://右
                    x += speed;
                    break;
                case 2://下
                    y += speed;
                    break;
                case 3://左
                    x -= speed;
                    break;
            }
            System.out.println("子弹 x=" + x + " y=" + y);
            //当子弹碰到敌人坦克时，也应该结束该线程

            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750 && isLive)) {
                System.out.println("子弹线程退出");
                isLive = false;
                break;
            }
        }
    }
}
