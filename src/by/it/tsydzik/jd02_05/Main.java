package by.it.tsydzik.jd02_05;

import java.util.Locale;

/**
 * @author Eugene Tsydzik
 * @since 12.10.2016.
 */
public class Main implements Messages, Helper {
    public static void main(String[] args) {
        Locale locale = LanguageManager.getLocale();
        if (args.length == 2) {
            locale = new Locale(args[0], args[1]);
            LanguageManager.setLocale(locale);
        }
        TaskB.printMessages(locale);

        System.out.println("\nTask B");
        TaskB.printMessages(locale);

        System.out.println("\nTask C");
        TaskC.task();
    }
}
