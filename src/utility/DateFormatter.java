package utility;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatter {

    private static String pattern = "dd MMMM yyyy";
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    public DateFormatter() {
        super();
    }

    public static String formatDate(Date date) {

        return simpleDateFormat.format(date);

    }

    public static Date parseDate(String dateString) {

        try {
            return simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;

    }

    public static Timestamp stringToTimeStamp(String strTime) {
        Timestamp tempTimestamp = null;
        if (strTime != null && !strTime.equals("")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat(
                    "MMMMM dd,yyyy");

            Date parsedTimeStamp = null;
            try {
                parsedTimeStamp = dateFormat.parse(strTime);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            tempTimestamp = new Timestamp(parsedTimeStamp.getTime());

        }
        return tempTimestamp;
    }

    public static Timestamp stringToTimeStampWithTime(String strTime) {
        Timestamp tempTimestamp = null;
        if (strTime != null && !strTime.equals("")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat(
                    "dd-MMM-yy hh:mm:ss");

            Date parsedTimeStamp = null;
            try {
                parsedTimeStamp = dateFormat.parse(strTime);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            tempTimestamp = new Timestamp(parsedTimeStamp.getTime());

        }
        return tempTimestamp;
    }

    public static String timeStampToString(Timestamp timeStamp) {
        String timeStampToStr = null;
        if (timeStamp != null) {
            timeStampToStr = new SimpleDateFormat("dd-MMM-yy").format(timeStamp);
        }
        return timeStampToStr;
    }

    public static String timeStampToStringWithTime(Timestamp timeStamp) {
        String timeStampToStr = null;
        if (timeStamp != null) {
            timeStampToStr = new SimpleDateFormat("dd-MMM-yy hh:mm:ss a").format(timeStamp);
        }
        return timeStampToStr;
    }

    public static String timeStampToStringForBuildings(Timestamp timeStamp) {
        String timeStampToStr = null;
        if (timeStamp != null) {
            timeStampToStr = new SimpleDateFormat("dd-MMM-yyyy").format(timeStamp);
        }
        return timeStampToStr;
    }

    public static String timeStampToStringFourDigitYear(Timestamp timeStamp) {
        String timeStampToStr = null;
        if (timeStamp != null) {
            timeStampToStr = new SimpleDateFormat("dd-MMM-yyyy").format(timeStamp);
        }
        return timeStampToStr;
    }

    public static String timeStampToStringMonth(Timestamp timeStamp) {
        String timeStampToStr = null;
        if (timeStamp != null) {
            timeStampToStr = new SimpleDateFormat("MMMM").format(timeStamp);
        }
        return timeStampToStr;
    }

    public static String timeStampToYear(Timestamp timeStamp) {
        String startYear = null;
        if (timeStamp != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date(timeStamp.getTime()));
            startYear = String.valueOf(cal.get(Calendar.YEAR));
        }
        return startYear;
    }
}
