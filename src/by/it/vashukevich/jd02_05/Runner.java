package by.it.vashukevich.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Runner implements Message {

    public static void main(String[] args) {

        if(args.length==2) {
            Locale locale = new Locale(args[0], args[1]);
            LanguageManager.setlocale(locale);
        }
        System.out.println(LanguageManager.getString(MESSAGE_WELCOME));
        System.out.println(LanguageManager.getString(MESSAGE_USERNAME));
        System.out.println(LanguageManager.getString(MESSAGE_QUESTION));

        Date date=new Date(System.currentTimeMillis());
        DateFormat df=DateFormat.getDateInstance(DateFormat.LONG,LanguageManager.getLocale());
        String strDate=df.format(date);
        System.out.println(strDate);
    }
}
