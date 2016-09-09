package by.it.tsydzik.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 09.09.2016.
 */
public class TaskA1 {

    public static void replaceChars() {

        StringBuilder sb = new StringBuilder(Data.POEM);
        Pattern pattern = Pattern.compile("[а-яА-ЯЁё]{5,}");
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) {
            int start = matcher.start();
            sb.setCharAt(start + 4, '#');
            if (matcher.group().length() >= 7) {
                sb.setCharAt(start + 6, '#');
            }
        }
        System.out.println(sb.toString());
    }
}
