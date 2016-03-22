package cn.edu.znufe.dhf.apisapp.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Aaric on 16/3/22.
 */
public class DateUtils {

    /**
     * Get format string.
     *
     * @param milliseconds
     * @return
     */
    public static String getFormatString(long milliseconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliseconds);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(calendar.getTime());
    }

}
