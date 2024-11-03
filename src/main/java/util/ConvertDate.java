package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ConvertDate {

    public static String convertDateToRequiredFormat(String date) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("MMM d, yyyy h:mm:ss a", Locale.ENGLISH);
        Date inputDate = null;
        try {
            inputDate = inputFormat.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd MM yyyy HH:mm:ss");
        return outputFormat.format(inputDate);
    }
}
