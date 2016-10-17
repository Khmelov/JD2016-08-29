package by.it.tsiamruk.jd02_05;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by waldemar on 12/10/2016.
 */
public class Data {
    static String date() {
        Date date = new Date(System.currentTimeMillis());
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, LanguageManager.getLocale());
        String strDate = df.format(date);
        return strDate;
    }
}
