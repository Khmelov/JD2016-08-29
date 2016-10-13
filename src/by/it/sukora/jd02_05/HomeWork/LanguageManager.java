package by.it.sukora.jd02_05.HomeWork;

import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageManager {
    public  static final String Path_I18N="by.it.sukora.jd02_05.HomeWork.language";

    private static Locale locale=Locale.ENGLISH;

    private static ResourceBundle resourceBundle=setResource(locale);

    public static ResourceBundle setResource(Locale locale){
        LanguageManager.locale=locale;
        resourceBundle=ResourceBundle.getBundle(Path_I18N,locale);
        return resourceBundle;
    }

    public static Locale getLocale() {
        return locale;
    }
    public static void setLocale(Locale locale){
        setResource(locale);
    }

    public static String getString(String key){
        return resourceBundle.getString(key);
    }


}
