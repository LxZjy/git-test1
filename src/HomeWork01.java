import java.util.Random;

/*
 *创建一个长度为 6 的整数数组。请编写代码，随机生成六个 0（包含）-100（不包含）
 * 之间的整数存放到数组中，然后计算出数组中所有元素的和并打印。
 * */
public class HomeWork01 {
    public static void main(String[] args) {
        int[] arr = new int[6];
        Random random = new Random();
        int sum = 0;
        for (int i = 0; i < 6; i++) {
            int num = random.nextInt(100);
            arr[i] = num;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
            sum += arr[i];
        }
        System.out.println("六个随机数的和:" + sum);
    }
}
