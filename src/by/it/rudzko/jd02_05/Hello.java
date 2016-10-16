package by.it.rudzko.jd02_05;


import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Hello {
    static void sayHello(Locale l) {
        LanguageManager.setR(l);
        System.out.println(LanguageManager.getStr(IMessages.MESSAGE_WELCOME));
        System.out.println(LanguageManager.getStr(IMessages.MESSAGE_USERNAME));
        System.out.println(LanguageManager.getStr(IMessages.MESSAGE_QUESTION));
        Date d = new Date(System.currentTimeMillis());
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, LanguageManager.getLocale());
        String strDate = df.format(d);
        System.out.println(strDate);
    }
}
