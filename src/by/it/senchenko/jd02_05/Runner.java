package by.it.senchenko.jd02_05;

import java.text.DateFormat;
import java.util.Date;

public class Runner implements Messages{

    public static void main(String[] args) {

        SetLocale.getLocaleSwich();
        System.out.println(LanguageManager.getString(MESSAGE_WELCOME));
        System.out.println(LanguageManager.getString(MESSAGE_USERNAME));
        System.out.println(LanguageManager.getString(MESSAGE_QUESTION));

        Date date=new Date(System.currentTimeMillis());
        DateFormat df=DateFormat.getDateInstance(DateFormat.LONG, LanguageManager.getLocale());
        String strDate=df.format(date);
        System.out.println(strDate);

    }

}
