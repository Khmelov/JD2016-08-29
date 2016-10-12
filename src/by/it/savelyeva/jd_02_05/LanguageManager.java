package by.it.savelyeva.jd_02_05;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by nato on 10/12/16.
 */
public class LanguageManager {
    public static final String pathI18n = "by.it.savelyeva.jd_02_05.language";
    private static Locale locale = Locale.ENGLISH;
    private static ResourceBundle resourceBundle = setResourceBundle(locale);

    public static ResourceBundle setResourceBundle(Locale locale) {
        LanguageManager.locale = locale;
        resourceBundle = ResourceBundle.getBundle(pathI18n, locale);
        return resourceBundle;
    }

    public static String getString(String key) {
        return resourceBundle.getString(key);
    }

    public static Locale getLocale() {
        return locale;
    }

    public static void setLocale(Locale locale) {
        setResourceBundle(locale);
    }
}
