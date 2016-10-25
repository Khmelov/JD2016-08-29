package by.it.laurynovich.jd02_04;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by nadabratb on 12.10.2016.
 */
public class Runner implements Messages {

    public static void main(String[] args) {
        if (args.length == 2) {
            Locale locale = new Locale("be", "BY");
            LanguageManager.setResource(locale);
        }
        System.out.println(LanguageManager.getString(MESSAGE_WELCOM));
        System.out.println(LanguageManager.getString(MESSAGE_USERNAME));
        System.out.println(LanguageManager.getString(MESSAGE_QUESTION));

        Date date = new Date(System.currentTimeMillis());
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, LanguageManager.getLocal());
        String strDate = df.format(date);
        System.out.println(strDate);
    }
}
