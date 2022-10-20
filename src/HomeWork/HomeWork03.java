package HomeWork;


/*杨辉三角
 *     第2^n-1行的每个数都是奇数*/
public class HomeWork03 {
    public static void main(String[] args) {
        printYanghui(10);
    }

    public static void printYanghui(int n) {
        int[][] a = new int[n][n];
        //编写一个杨辉三角
        for (int i = 0; i < n; i++) {
            a[i][0] = 1;
            a[i][i] = 1;
            if (i >= 2) {
                for (int j = 1; j < i; j++) {
                    a[i][j] = a[i - 1][j] + a[i - 1][j - 1];
                }
            }
        }
        //遍历打印杨辉三角
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n - i; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(a[i][j]);
                if (j!=i)System.out.print(" ");
            }
            System.out.println();
        }
    }
}
