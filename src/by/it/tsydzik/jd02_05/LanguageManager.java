package by.it.tsydzik.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Eugene Tsydzik
 * @since 12.10.2016.
 */
public class LanguageManager {
    public static final String Path_I18N = "by.it.tsydzik.jd02_05.language";
    private static Locale locale = Locale.ENGLISH;

    public static Locale getLocale() {
        return locale;
    }

    private static ResourceBundle resourceBundle = setResource(locale);

    public static ResourceBundle setResource(Locale locale) {
        LanguageManager.locale = locale;
        return resourceBundle = ResourceBundle.getBundle(Path_I18N, locale);
    }

    public static void setLocale(Locale locale) {
        setResource(locale);
    }

    public static String getString(String key) {
        return resourceBundle.getString(key);
    }

}
