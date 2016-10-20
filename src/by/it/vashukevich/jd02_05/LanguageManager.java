package by.it.vashukevich.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageManager {
    public static final String Path_I18N="by.it.vashukevich.jd02_05.language";

    private static Locale locale=Locale.ENGLISH;

    private static ResourceBundle resourceBundle=setResourse(locale);

    public static ResourceBundle setResourse(Locale locale){
        LanguageManager.locale=locale;
        resourceBundle=ResourceBundle.getBundle(Path_I18N,locale);
        return resourceBundle;
    }
    public static Locale getLocale(){return locale;}

    public static void setlocale(Locale locale) {
        setResourse(locale);
    }
    public static String getString(String key) {
        return resourceBundle.getString(key);
    }


}
