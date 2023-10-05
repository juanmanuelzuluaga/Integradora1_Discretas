import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String formatDateToString(Date date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    public static Date parseStringToDate(String dateString, String format) throws java.text.ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.parse(dateString);
    }

}

