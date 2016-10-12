package by.it.tsydzik.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Eugene Tsydzik
 * @since 12.10.2016.
 */
public class Main implements Messages {
    public static void main(String[] args) {
        if (args.length == 2) {
            Locale locale = new Locale(args[0], args[1]);
            LanguageManager.setLocale(locale);
        }

        System.out.println(LanguageManager.getString(MESSAGE_WELCOME));
        System.out.println(LanguageManager.getString(MESSAGE_USERNAME));
        System.out.println(LanguageManager.getString(MESSAGE_QUESTION));

        // Task B
        Date date = new Date(System.currentTimeMillis());
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, LanguageManager.getLocale());
        String strDate = df.format(date);
        System.out.println(strDate);


    }
}
