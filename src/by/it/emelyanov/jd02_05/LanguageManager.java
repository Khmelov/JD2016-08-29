package by.it.emelyanov.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageManager {
    public static final String PATH_I18N = "by.it.emelyanov.jd02_05.files.language";
    private static Locale locale = Locale.ENGLISH;
    private static ResourceBundle resourceBundle = setResource(locale);

    public static ResourceBundle setResource(Locale locale) {
        LanguageManager.locale = locale;
        resourceBundle = ResourceBundle.getBundle(PATH_I18N, locale);
        return resourceBundle;
    }

    public static Locale getLocale() {
        return locale;
    }

    public static void setLocale(Locale locale) {
        setResource(locale);
    }

    public static String getString(String key) {
        return resourceBundle.getString(key);
    }

}
