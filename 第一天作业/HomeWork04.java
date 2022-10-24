package HomeWork;


import java.util.Scanner;

/*2019年1月1日起，国家推出新的个人所得税政策，起征点上调值5000元。也就是说税前工资扣除三险一金
（三险一金数额假设是税前工资的10%）后如果不足5000元，则不交税。如果大于5000元，
那么大于5000元的部分按梯度交税，具体梯度比例如下
0 ~ 3000元的部分，交税3%			3000 ~ 12000元的部分，交税10% 12000 ~ 25000的部分 ， 交税20%
25000 ~ 35000的部分，交税25%      35000 ~ 55000的部分，交税30%	55000 ~ 80000的部分，交税35%
超过80000的部分，交税45%  */
public class HomeWork04 {

    private static double a;
    private static double b;
    private static double c;
    private static double d;
    private static double e;
    private static double f;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("一个月的工资数额为：");
        double money = scanner.nextDouble();
        double formoney = money - 5000;
        money = money * (1 - 0.1);
        if (money >= 5000) {
            if (formoney >= 3000) {
                a = money - (formoney * 0.03);
                System.out.println(a);
            } else if (formoney >= 3000 && formoney <= 12000) {
                b = money - a - (formoney * 0.1);
                System.out.println(b);
            } else if (formoney >= 12000 && formoney <= 25000) {
                c = money - a - b - (formoney * 0.2);
                System.out.println(c);
            } else if (formoney >= 25000 && formoney <= 35000) {
                d = money - a - b - c - (formoney * 0.25);
                System.out.println(d);
            } else if (formoney >= 35000 && formoney <= 55000) {
                e = money - a - b - c - d - (formoney * 0.3);
                System.out.println(e);
            } else if (formoney >= 55000 && formoney <= 80000) {
                f = money - a - b - c - d - e - (formoney * 0.35);
                System.out.println(f);
            } else {
                System.out.println(money - a - b - c - d - e - f - (formoney * 0.45));
            }
        } else {
            System.out.println(money);
        }
    }
}
