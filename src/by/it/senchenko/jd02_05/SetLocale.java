package by.it.senchenko.jd02_05;


import java.util.Locale;
import java.util.Scanner;

public class SetLocale {
    public static void getLocaleSwich(){
        Scanner scanner=new Scanner(System.in);
        Locale locale;
        String loc = scanner.nextLine();
        switch (loc) {
            case "be":
                locale = new Locale("be", "BY");
                LanguageManager.setLocale(locale);
                break;
            case "ru":
                locale = new Locale("ru", "RU");
                LanguageManager.setLocale(locale);
                break;
            case "en":
                locale = new Locale("en", "EN");
                LanguageManager.setLocale(locale);
                break;
        }
    }
}
