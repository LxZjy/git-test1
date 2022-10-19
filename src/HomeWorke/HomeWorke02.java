package HomeWorke;

public class HomeWorke02 {
    public static void main(String[] args) {
        String name="jack";
        String pwd="123456";
        String email="jack@sohu.com";
        try {
            userRegister(name,pwd,email);
            System.out.println("恭喜你注册成功");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void userRegister(String name,String pwd,String email){
        if (name!=null&&pwd!=null&&email!=null){
            throw new RuntimeException("参数不能为null");
        }
        int userLength=name.length();
        if (!(userLength>=2&&userLength<=4)){
            throw new RuntimeException("用户名长度为2或3或4");
        }
        if (!(pwd.length()==6&&isDigital(pwd))){
            throw new RuntimeException("密码长度为6,要求全是数字");
        }
        int i=email.indexOf('@');
        int j = email.indexOf('.');
        if (!(i>-1&&j>i)){
            throw new RuntimeException("邮箱中包含@和.  并且@在.的前面");
        }
    }
    public static boolean isDigital(String str){
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]<'0'||chars[i]>'9'){
                return false;
            }
        }
        return true;
    }
}
