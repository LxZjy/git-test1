package TankGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener, Runnable {
    //定义一个坦克
    Hero hero = null;
    //定义敌人坦克,放入到Vector
    Vector<EnemyTank> enemyTanks = new Vector<>();
    //定义一个Vector，用于存放炸弹
    //当子弹击中坦克时就加入bomb对象
    Vector<Bomb> bombs = new Vector<>();
    int enemyTankSize = 3;

    //定义三张炸弹推按，用于显示爆炸效果
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;


    public MyPanel() {
        hero = new Hero(100, 100);//初始化自己坦克
        hero.setSpeed(5);//设置坦克速度
        //初始化敌人坦克
        for (int i = 0; i < enemyTankSize; i++) {
            EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0);
            enemyTank.setDirect(2);
            enemyTanks.add(enemyTank);
            //给该enemyTank加入一颗子弹
            //启动敌人坦克线程,让其动起来
            new Thread(enemyTank).start();
            Shout shout = new Shout(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
            enemyTank.shots.add(shout);
            //启动shot对象
            new Thread(shout).start();
        }
        //初始化图片对象
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//填充矩形
        drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);
        //drawTank(hero.getX()+60, hero.getY(), g, 0, 1);

        //画出hero射击的子弹
        if (hero.shout != null && hero.shout.isLive == true) {
            System.out.println("子弹被绘制");
            //g.draw3DRect(hero.shout.x,hero.shout.y,1,1,false);
            g.draw3DRect(hero.shout.x, hero.shout.y, 1, 1, false);

        }

        //如果bombs集合中有对象，就画出
        for (int i = 0; i < bombs.size(); i++) {
            //取出炸弹
            Bomb bomb = bombs.get(i);
            if (bomb.life > 6) {
                g.drawImage(image1, bomb.x, bomb.y, 60, 60, this);
            } else if (bomb.life > 3) {
                g.drawImage(image2, bomb.x, bomb.y, 60, 60, this);
            } else {
                g.drawImage(image3, bomb.x, bomb.y, 60, 60, this);
            }
            //让炸弹的生命值减少
            bomb.lifeDown();
            //若果bomb life为0，就从bombs的集合中删除
            if (bomb.life == 0) {
                bombs.remove(bomb);
            }
        }

        //画出敌人坦克
        for (int i = 0; i < enemyTanks.size(); i++) {
            //取出坦克
            EnemyTank enemyTank = enemyTanks.get(i);
            //判断当前的坦克是否还存活
            if (enemyTank.isLive) {//当敌人坦克还存活，才画出该坦克
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 0);
                //画出enemyTank子弹
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    //取出子弹
                    Shout shout = enemyTank.shots.get(j);
                    //绘制
                    if (shout.isLive) {
                        g.draw3DRect(shout.x, shout.y, 1, 1, false);
                    } else {
                        //从Vector移除
                        enemyTank.shots.remove(shout);
                    }
                }
            }
        }
    }
    //包装到方法画坦克

    /**
     * @param x      坦克的左上角x坐标
     * @param y      坦克的左上角y坐标
     * @param g      画笔
     * @param direct 坦克方向
     * @param type   坦克类型
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        switch (type) {
            case 0://我们坦克
                g.setColor(Color.CYAN);//青色
                break;
            case 1:    //敌人坦克
                g.setColor(Color.yellow);//黄色
                break;
        }
        //根据坦克的方向，绘制坦克
        switch (direct) {
            case 0://0表示向上
                g.fill3DRect(x, y, 10, 60, false);//左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//中间矩形
                g.fillOval(x + 10, y + 20, 20, 20);//圆形坦克盖子
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            case 1://1表示向右
                g.fill3DRect(x, y, 60, 10, false);//上边轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//右边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//中间矩形
                g.fillOval(x + 20, y + 10, 20, 20);//圆形坦克盖子
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            case 2://2表示向下
                g.fill3DRect(x, y, 10, 60, false);//左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//中间矩形
                g.fillOval(x + 10, y + 20, 20, 20);//圆形坦克盖子
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            case 3://1表示向左
                g.fill3DRect(x, y, 60, 10, false);//上边轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//右边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//中间矩形
                g.fillOval(x + 20, y + 10, 20, 20);//圆形坦克盖子
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
            default:
                System.out.println("暂时没有处理");
        }
    }


    //编写方法，判断我方子弹是否击中敌人坦克
    public void hitTank(Shout s, EnemyTank enemyTank) {
        //判断s击中坦克
        switch (enemyTank.getDirect()) {
            case 0://上
            case 2://下
                if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 40
                        && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 60) {
                    s.isLive = false;
                    enemyTank.isLive = false;
                    //当我的子弹击中敌人坦克后,将enmyTank从Vector拿掉
                    enemyTanks.remove(enemyTank);
                    //创建一个Bomb对象，加入到bomb集合
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
            case 1://右
            case 3://左
                if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 60
                        && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 40) {
                    s.isLive = false;
                    enemyTank.isLive = false;
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //处理wasd按键下的情况
        if (e.getKeyCode() == KeyEvent.VK_W) {
            hero.setDirect(0);
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect(2);
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect(3);
            hero.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirect(1);
            hero.moveRigth();
        }
        //如果用户按下j，就是发射
        if (e.getKeyCode() == KeyEvent.VK_J) {
            System.out.println("用户按下了j,开始射击");
            hero.shotEnmyTank();
        }
        this.repaint();//重新绘制面板
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {//每隔一百毫秒重绘区域
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //判断是否击中敌人坦克
            if (hero.shout != null && hero.shout.isLive) {//当前我的子弹还存活
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    hitTank(hero.shout, enemyTank);
                }
            }

            this.repaint();
        }
    }
}
