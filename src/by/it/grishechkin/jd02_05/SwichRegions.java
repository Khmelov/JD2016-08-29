package by.it.grishechkin.jd02_05;

import javafx.scene.input.DataFormat;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Yury on 07.11.2016.
 */
public class SwichRegions {

    public static void swichRegion() {
        Locale locale = new Locale("en", "US");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("by.it.grishechkin.jd02_05.res.str", locale);
        System.out.println(resourceBundle.getString("welcome") + " " + resourceBundle.getString("name"));
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, Locale.US);
        System.out.println(dateFormat.format(date));
    }

    public static void swichRegion(String language, String country) {
        Locale locale = new Locale(language, country);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("by.it.grishechkin.jd02_05.res.str", locale);
        System.out.println(resourceBundle.getString("welcome") + " " + resourceBundle.getString("name"));
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
        System.out.println(dateFormat.format(date));
    }
}
