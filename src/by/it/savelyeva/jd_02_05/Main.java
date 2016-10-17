package by.it.savelyeva.jd_02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by nato on 10/12/16.
 */
public class Main implements IMessages, IPrompt {

    private static void displayMessages(Locale locale) {
        LanguageManager.setLocale(locale);
        System.out.println(LanguageManager.getString(MESSAGE_WELCOME));
        System.out.println(LanguageManager.getString(MESSAGE_USERNAME));
        System.out.println(LanguageManager.getString(MESSAGE_QUESTION));

        Date d = new Date(System.currentTimeMillis());
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, LanguageManager.getLocale());
        String strDate = df.format(d);
        System.out.println(strDate);

    }

    private static void showHint() {
        System.out.println(LanguageManager.getString(PROMPT_HINT));
    }

    public static void main(String[] args) {
        Locale locale = LanguageManager.getLocale();
        if (args.length == 2) {
            locale = new Locale(args[0], args[1]);
            displayMessages(locale);
        }

        System.out.println("\n************ Task C *****************\n");
        String line = "";
        do {
            displayMessages(locale);
            showHint();
            line = new Scanner(System.in).nextLine();
            switch (line) {
                case "ru": locale = new Locale("ru", "RU"); break;
                case "be": locale = new Locale("be", "BY"); break;
                case "en": locale = Locale.ENGLISH; break;
                case "END": System.out.println(LanguageManager.getString(PROMPT_EXIT)); break;
                default:
                    System.out.println(LanguageManager.getString(PROMPT_ERROR));
                    locale = Locale.ENGLISH;
            }
        } while (line.compareTo("END") != 0);
    }
}
