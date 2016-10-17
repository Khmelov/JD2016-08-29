package by.it.tsiamruk.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by waldemar on 12/10/2016.
 */
class LanguageManager {
    private static final String Path_I18N = "by.it.tsiamruk.jd02_05.language";

    private static Locale locale = Locale.ENGLISH;
    private static ResourceBundle resourceBundle = setResource(locale);

    public static ResourceBundle setResource(Locale locale) {
        LanguageManager.locale = locale;
        resourceBundle = ResourceBundle.getBundle(Path_I18N, locale);
        return resourceBundle;
    }

    public static void setLocale(Locale locale) {
        setResource(locale);
    }

    public static Locale getLocale() {
        return locale;
    }

    public static String getString(String key) {
        return resourceBundle.getString(key);
    }


}
