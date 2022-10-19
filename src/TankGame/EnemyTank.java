package TankGame;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable {
    boolean isLive = true;
    Vector<Shout> shots = new Vector<>();

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {
        while (true) {
            //根据坦克的方向继续移动
            switch (getDirect()) {
                case 0://上
                    //让坦克保持一个方向走
                    moveUp();
                case 1://右
                   moveRigth();
                case 2://下
                    moveDown();
                case 3://左
                    moveLeft();
            }


            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //然后随机的改变坦克方向0-3
            setDirect((int)(Math.random() * 4));
            //退出线程
            if (!isLive) {
                break;
            }
        }
    }
}
