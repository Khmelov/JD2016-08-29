package by.it.rudzko.jd02_05;

import java.util.Locale;
import java.util.Scanner;


public class Runner {

    public static void main(String[] args) {

        String s;
        Locale locale=new Locale("en", "US");
        LanguageManager.setR(locale);
        System.out.println(LanguageManager.getStr(IMessages.MESSAGE_CHOOSE));
        while(!(s=new Scanner(System.in).nextLine().toLowerCase()).equals("stop")){
            switch (s){
                case "en":
                    locale = new Locale("en", "US");
                    break;
                case "ru":
                    locale = new Locale("ru", "RU");
                    break;
                case "by":
                    locale = new Locale("be", "BY");
                    break;
                default:
                    locale = new Locale("en", "US");
            }
            Hello.sayHello(locale);
        }
    }
}
