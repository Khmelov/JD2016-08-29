package by.it.emelyanov.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Util implements Message {
    static void printHelloAndDate(Locale locale) {
        LanguageManager.setLocale(locale);
        System.out.println(LanguageManager.getString(MESSAGE_WELCOME));
        System.out.println(LanguageManager.getString(MESSAGE_USERNAME));
        System.out.println(LanguageManager.getString(MESSAGE_QUESTION));

        Date date = new Date(System.currentTimeMillis());
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, LanguageManager.getLocale());
        String strDate = df.format(date);
        System.out.println(strDate);
    }
    static void printMessage(){
        System.out.println("Введите команды: ru, be, en");
        System.out.println("или close для закрытия ввода команд");
    }
}
