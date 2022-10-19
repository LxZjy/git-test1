package Exception;


import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Exception04 {
    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss-E");
        String format = dtf.format(ldt);
        System.out.println(format);
        Instant instant = Instant.now();
        Date date = Date.from(instant);
        System.out.println(instant);
        //提供plus和minus方法就可以对当前时间进行加或减
        //看看890天后，是什么时候
        LocalDateTime localDateTime = ldt.plusDays(890);
        System.out.println(dtf.format(localDateTime));
        LocalDateTime localDateTime1 = ldt.minusMinutes(360);
        System.out.println(dtf.format(localDateTime1));
    }
}
