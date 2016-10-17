package by.it.laurynovich.jd02_01;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by nadabratb on 12.10.2016.
 */
public class LanguageManager {
    public static final String Path_I18N = "by.it.laurynovich.jd02_01.languege";
    private static Locale locale = Locale.ENGLISH;
    private static  ResourceBundle resourceBundle = setResource(locale);

    public static ResourceBundle setResource (Locale locale){
        LanguageManager.locale = locale;
        resourceBundle = ResourceBundle.getBundle(Path_I18N, locale);
        return resourceBundle;

        }

        public static String getString(String key){

            return resourceBundle.getString(key);
        }



    public static Locale getLocal() { return locale;
    }
}
