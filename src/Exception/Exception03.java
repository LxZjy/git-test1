package Exception;

import java.util.Calendar;

public class Exception03 {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println("c="+c);
        System.out.println("年:"+c.get(Calendar.YEAR)+" 月:"+(c.get(Calendar.MONTH)+1)+
                " 日:"+c.get(Calendar.DAY_OF_MONTH)+" 时:"+c.get(Calendar.HOUR)+" 分:"+
                c.get(Calendar.MINUTE)+" 秒:"+c.get(Calendar.SECOND));
    }
}
