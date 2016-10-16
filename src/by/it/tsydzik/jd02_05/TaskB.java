package by.it.tsydzik.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Dmitry Tsydzik
 * @since 16.10.16.
 */
public class TaskB implements Messages{
    public static void printMessages(Locale locale) {
        LanguageManager.setLocale(locale);
        System.out.println(LanguageManager.getString(MESSAGE_WELCOME));
        System.out.println(LanguageManager.getString(MESSAGE_USERNAME));
        System.out.println(LanguageManager.getString(MESSAGE_QUESTION));

        Date d = new Date(System.currentTimeMillis());
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, LanguageManager.getLocale());
        String strDate = df.format(d);
        System.out.println(strDate);

    }
}
