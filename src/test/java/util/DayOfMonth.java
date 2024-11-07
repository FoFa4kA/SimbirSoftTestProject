package util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DayOfMonth {

    public static int getCurrentDayOfMonth() {
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate.getDayOfMonth();
    }
}
