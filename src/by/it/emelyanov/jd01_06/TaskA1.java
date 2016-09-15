package by.it.emelyanov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void RepChar() {
        StringBuilder data = new StringBuilder(Data.getString());
        Pattern p1 = Pattern.compile("[а-яА-ЯёЁ]{5,}");
        Matcher m1 = p1.matcher(data);
        while (m1.find()) {
            int start = m1.start();
            int length = m1.group().length();
            data.setCharAt(start + 4, '#');
            if (length > 6) {
                data.setCharAt(start + 6, '#');
            }
        }
        System.out.println(data);
    }
}
