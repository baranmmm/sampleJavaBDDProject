package projectFolders._projectUtilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectUtilities {

    public static String getCurrentDate(){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    /**
     * this method take format of date/time (yyyy-MM-dd or hh:mm a)(yyyy-MM-dd hh:mm:ss a)
     * two date as a string and return
     * two date in date list as date format
     *  @param format/type
     *  @param date1/time
     *  @param date2/time
     */
    public static List<Date> convertStringToDate(String format, String date1, String date2) throws ParseException {
        List<Date> dates= new ArrayList<>();
        DateFormat df = new SimpleDateFormat(format);
        Date d1 = df.parse(date1);
        Date d2 = df.parse(date2);
        dates.add(d1);
        dates.add(d2);
        return dates;
    }

    public static String getTimeStamp() {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");

        return sdf.format(date.getTime());

    }
}
