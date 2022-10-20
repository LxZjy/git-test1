package HomeWork;

import org.junit.Test;

import java.util.Scanner;


/*2、某银行推出了整存整取定期储蓄业务，
       其存期分为一年、两年、三年、五年，到期凭存单支取本息。存款年利率表如下：存期 年利率（%）
       一年 2.25,两年 2.7,三年 3.25,五年 3.6
       请存入一定金额（1000起存），存一定年限（四选一），计算到期后得到的本息总额。
       * */

public class HomeWork02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入你存入的金额:");
        double money = scanner.nextDouble();//本金
        System.out.print("请输入存款年限:");
        int year = scanner.nextInt();//年限
        switch (year) {
            case 1:
                money = (money * 0.025) + money;
            case 2:
                money = ((money * 0.027) * 2) + money;
            case 3:
                money = ((money * 0.0325) * 3) + money;
            case 5:
                money = ((money * 0.036) * 5) + money;
        }
        System.out.println(money);
    }
}
