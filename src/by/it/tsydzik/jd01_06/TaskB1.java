package by.it.tsydzik.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Eugene Tsydzik
 * @since 9/14/16.
 */
public class TaskB1 {
    public static void taskB1() {
        StringBuilder sb = new StringBuilder(Data.POEM);
        Pattern pattern = Pattern.compile("[а-яА-ЯЁё]{5,}");
        Matcher matcher = pattern.matcher(sb);

        try {
            while (matcher.find()) {
                int start = matcher.start();
                if (matcher.group().length() == 5) {
                    sb.delete(start, start + 5);
                }
            }
        } catch (Exception e) {
            System.out.println("");
        }


        System.out.println(sb.toString());
    }
}
