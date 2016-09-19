package by.it.savelyeva.jd_01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 Created by nato on 9/19/16.
 */
public class TaskA1 {

    public static StringBuilder replaceChars(String data) {
        StringBuilder sb = new StringBuilder(data);
        Pattern pattern = Pattern.compile("[а-яА-ЯЁё]{5,}");
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) {
            int start = matcher.start();
            sb.setCharAt(start + 4, '#');
            if (matcher.group().length() >= 7) {
                sb.setCharAt(start + 6, '#');
            }
        }
        return sb;
    }
}
