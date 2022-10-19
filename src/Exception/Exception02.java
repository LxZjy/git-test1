package Exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Exception02 {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println("时间:"+date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss-E");
        String format = sdf.format(date);
        Date parse = sdf.parse(format);
        System.out.println(parse);
       System.out.println( sdf.format(parse));
    }
}
