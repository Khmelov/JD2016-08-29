package by.it.emelyanov.jd02_05;

import java.util.Locale;

public class RunnerAB {
    public static void main(String[] args) {
        if (args.length == 2) {
            Locale locale = new Locale(args[0], args[1]);
            Util.printHelloAndDate(locale);
        } else {
            Locale locale = new Locale("en", "US");
            Util.printHelloAndDate(locale);
        }
    }
}
