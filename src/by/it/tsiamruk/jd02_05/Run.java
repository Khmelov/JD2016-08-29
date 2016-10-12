package by.it.tsiamruk.jd02_05;

import java.util.Locale;

/**
 * Created by waldemar on 12/10/2016.
 */
public class Run implements Messages {
    public static void main(String[] args) {
        String command = ConsoleCommands.command();
        Locale locale;
        switch (command) {
            case "be":
                locale = new Locale("be", "BY");
                LanguageManager.setLocale(locale);
                break;
            case "ru":
                locale = new Locale("ru", "RU");
                LanguageManager.setLocale(locale);
                break;
            case "en":
                locale = new Locale("en", "EN");
                LanguageManager.setLocale(locale);
                break;
        }
        System.out.println(LanguageManager.getString(MESSAGE_WELCOME));
        System.out.println(LanguageManager.getString(MESSAGE_USERNAME));
        System.out.println(LanguageManager.getString(MESSAGE_QUESTION));
        System.out.println(Data.date());

    }
}
