package by.it.tsydzik.jd02_05;

import java.util.Locale;

/**
 * @author Eugene Tsydzik
 * @since 12.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        Locale localeBe = new Locale("be", "BY");
        LanguageManager.setLocale(localeBe);

        System.out.println(LanguageManager.getString("message.welcome"));
        System.out.println(LanguageManager.getString("message.username"));
        System.out.println(LanguageManager.getString("message.question"));
        System.out.println();

        Locale localeRu = new Locale("ru", "RU");
        LanguageManager.setLocale(localeRu);

        System.out.println(LanguageManager.getString("message.welcome"));
        System.out.println(LanguageManager.getString("message.username"));
        System.out.println(LanguageManager.getString("message.question"));

    }
}
