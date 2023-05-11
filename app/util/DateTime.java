package util;
import java.util.Date;
public class DateTime {
    public static Date getDateTime() {
        String pattern = "dd-MM-yyyy hh:mm:ss";
        Date date = new Date();
        return date;
    }
}