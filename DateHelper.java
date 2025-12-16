package src;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private DateHelper () {}

    public static Date parseDate(String dateStr) {
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
           throw new IllegalArgumentException ("Error: Invalid Date format, expected \"dd/MM/yyyy\".");
        }
    }

    public static String formatDate(Date date) {
        return sdf.format(date);
    }
}