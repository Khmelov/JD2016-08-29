package by.it.artiuschik.jd_02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner implements Messages {
    public static void main(String[] args) {
        if (args.length == 2) {
            Locale locale = new Locale(args[0], args[1]);
            LanguageManager.setLocale(locale);
        }
        System.out.println(LanguageManager.getString(MESSAGE_WELCOME));
        System.out.println(LanguageManager.getString(MESSAGE_USERNAME));
        System.out.println(LanguageManager.getString(MESSAGE_QUESTION));
        Date date = new Date(System.currentTimeMillis());
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, LanguageManager.getLocale());
        String strDate = df.format(date);
        System.out.println(strDate);
        System.out.println("Введите язык: ru/be/en");
        Scanner sc = new Scanner(System.in);
        String language = sc.nextLine();
        Locale locale;
        switch (language) {
            case "ru":
                locale = new Locale("ru", "RU");
                LanguageManager.setLocale(locale);
                break;
            case "be":
                locale = new Locale("be", "BY");
                LanguageManager.setLocale(locale);
                break;
            case "en":
                locale = new Locale("en", "EN");
                break;
            default:
                System.out.println("Неправильней ввод строки!");
                break;
        }
        System.out.println(LanguageManager.getString(MESSAGE_WELCOME));
        System.out.println(LanguageManager.getString(MESSAGE_USERNAME));
        System.out.println(LanguageManager.getString(MESSAGE_QUESTION));
    }
}
