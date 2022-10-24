import java.util.Arrays;
import java.util.Scanner;

/*
*有一个数组，其中有十个元素从小到大依次排列 {12,14,23,45,66,68,70,77,90,91}。再通过键盘录入一个整数
数字。要求：把数字放入数组序列中，生成一个新的数组，并且数组的元素依旧是从小到大排列的。执行效果如下：
```
请输入一个整数数字：
50
生成的新数组是：12 14 23 45 50 66 68 70 77 90
* */
public class HomeWork02 {
    public static void main(String[] args) {
        int[] arr = {12, 14, 23, 45, 66, 68, 70, 77, 90, 91};
        Scanner scanner = new Scanner(System.in);
        int[] arrNew = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {//把原数组的数赋给新数组
            arrNew[i]=arr[i];
        }
        System.out.println("请输入一个你要添加的元素:");
        arrNew[arr.length]=scanner.nextInt();//将要添加的元素存在新数组中
        arr=arrNew;//让arr指向新的数组空间
        System.out.println("扩容后的数组为:");
           Arrays.sort(arr);
           System.out.println(Arrays.toString(arr));
    }
}
