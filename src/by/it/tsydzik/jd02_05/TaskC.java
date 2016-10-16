package by.it.tsydzik.jd02_05;

import java.util.Locale;
import java.util.Scanner;

/**
 * @author Eugene Tsydzik
 * @since 16.10.16.
 */
public class TaskC implements Helper{
    public static void task(){
        Locale locale = LanguageManager.getLocale();
        String line = "";
        do {
            TaskB.printMessages(locale);
            System.out.println(LanguageManager.getString(HELPER_HINT));
            line = new Scanner(System.in).nextLine();
            switch (line) {
                case "ru":
                    locale = new Locale("ru", "RU");
                    break;
                case "be":
                    locale = new Locale("be", "BY");
                    break;
                case "en":
                    locale = Locale.ENGLISH;
                    break;
                case "END":
                    System.out.println(LanguageManager.getString(HELPER_EXIT));
                    break;
                default:
                    System.out.println(LanguageManager.getString(HELPER_ERROR));
                    locale = Locale.ENGLISH;
            }
        } while (line.compareTo("END") != 0);
    }
}
