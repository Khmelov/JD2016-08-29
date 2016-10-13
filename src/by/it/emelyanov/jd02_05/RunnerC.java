package by.it.emelyanov.jd02_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class RunnerC {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String param;
        do {
            Util.printMessage();
            param = bufferedReader.readLine();

            if (param.equals("close")) {
                bufferedReader.close();
                break;

            } else if (param.equals("ru")) {
                Locale locale = new Locale("ru", "RU");
                Util.printHelloAndDate(locale);

            } else if (param.equals("be")) {
                Locale locale = new Locale("be", "BY");
                Util.printHelloAndDate(locale);

            } else if (param.equals("en")) {
                Locale locale = new Locale("en", "US");
                Util.printHelloAndDate(locale);

            } else {
                System.out.println("Такой команды не существует");
            }
        } while (true);
    }
}
