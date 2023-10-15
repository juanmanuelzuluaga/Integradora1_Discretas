import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class UserValidator {

    private static final Pattern PRIORITY_PATTERN = Pattern.compile("^(Prioritaria|No prioritaria)$", Pattern.CASE_INSENSITIVE);

    private static final String DATE_FORMAT = "dd/MM/yyyy";

    public static boolean isValidPriority(String input) {
        return PRIORITY_PATTERN.matcher(input).matches();
    }


    public static boolean isValidDate(String input) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        dateFormat.setLenient(false);
        try {
            Date date = dateFormat.parse(input);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static boolean isValidDateTime(String dateTimeStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        dateFormat.setLenient(false);

        try {
            Date parsedDate = dateFormat.parse(dateTimeStr);

            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    }


