package HomeWorke;

public class HomeWorke01 {
    //对输入的参数做一个验证
    //1.先写出正确的情况
    //2.然后取反即可
    public static void main(String[] args) {
    String str="abcde";
    System.out.println(str);
        try {
            str=reverse(str,0,0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println(str);
    }

    public static String reverse(String str, int start, int end) {
        if (!(str!=null&&start>=0&&end>start&&end<str.length())){
            throw  new RuntimeException("参数不正确");
        }
        char[] chars = str.toCharArray();
        char temp = ' ';
        for (int i = start, j = end; i < j; i++, j--) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }
}
