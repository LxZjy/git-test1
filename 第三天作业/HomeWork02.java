package Day3;


import java.util.Random;
import java.util.Scanner;

/*
*  ## 题目2（训练）

在登录注册页面中，除了用户名和密码外，通常也会包含验证码。验证码是用来区分用户是计算机还是人，
* 防止恶意破解密码、刷票、灌水等行为。在判断验证码时一般不区分大小写。请编写程序模拟验证码的判断过程，
* 如果输入正确，给出提示，结束程序。如果输入错误，给出提示，验证码刷新，重新输入，直至正确为止。

生成4位随机验证码的功能在之前的题目中已经完成，可以直接使用。《定义方法，获取一个包含4个字符的验证码，
* 每一位字符是随机选择的字母和数字，可包含a-z,A-Z,0-9。》
**/
public class HomeWork02 {
    public static void main(String[] args) {
        while (true){
            String code = creatCode(4);
            System.out.println("验证码:"+code);
            Scanner scanner = new Scanner(System.in);
            System.out.print("请输入验证码:");
            String pwd = scanner.nextLine();
            if (code.equals(pwd)){
                System.out.println("输入正确!");
                break;
            }else {
                System.out.println("输入错误请重新输入");
            }
        }
    }
    public static String creatCode(int n){
        String code="";
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            int type = r.nextInt(3);
            switch (type){
                case 0:
                    //大写字符（A 65-Z 65+25）
                    char ch = (char) (r.nextInt(26) + 65);
                    code+=ch;
                    break;
                case 1:
                    ////小写字符（a 97-z 97+25）
                    char ch1 = (char) (r.nextInt(26) + 97);
                    code+=ch1;
                    break;
                case 2:
                    //数字字符
                    code+=r.nextInt(10);
                    break;
            }
        }
        return  code;
    }
}

