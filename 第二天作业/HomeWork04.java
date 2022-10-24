import java.util.Random;

/*
 * 随机一个数组其中包含多个数字。用自己的方式最终实现，奇数放在数组的左边，偶数放在数组的右边
 * */
public class HomeWork04 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            int num = random.nextInt(100);
            arr[i] = num;
            OddLeft(arr);
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] OddLeft(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] % 2 != 0) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return arr;
    }
}
