package Day4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Lx
 * @data 2022/11/3 16:34
 * version 1.0
 */
public class HomeWork01 {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String format = sdf.format(date);
        boolean belongCalendar = belongCalendar(sdf.parse("8:00"), sdf.parse(format), sdf.parse("17:30"));
        if (belongCalendar){
            System.out.println("在时间段内");
        }else {
            System.out.println("不在时间段内");
        }
    }
    public static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
        return nowTime.getTime() >= beginTime.getTime() && nowTime.getTime() <= endTime.getTime();
    }
}

