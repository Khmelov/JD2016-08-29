package by.it.rudzko.jd02_05;


import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageManager {
    public static final String Path_I18N="by.it.rudzko.jd02_05.language";
    private static Locale locale=Locale.ENGLISH;
    private static ResourceBundle rb=null;

    public static ResourceBundle setR(Locale locale){
        LanguageManager.locale=locale;
        rb=ResourceBundle.getBundle(Path_I18N,  locale);
        return rb;
    }

    public static void setLocale(Locale locale){
        setR(locale);
    }

    public static Locale getLocale() {
        return locale;
    }

    public static String getStr(String key){
        return rb.getString(key);
    }
}
