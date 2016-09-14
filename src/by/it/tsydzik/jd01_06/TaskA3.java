package by.it.tsydzik.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Eugene Tsydzik
 * @since 9/14/16.
 */
public class TaskA3 {

    public static void taskA3() {
        String[] wordArray = Data.POEM.split("[\\s,.:!?]+");

        Pattern pattern = Pattern.compile("^[аАиИуУыеЕёЁюЮяЯ].*[аиуыеёюя]$");
        for (String word : wordArray) {
            Matcher matcher = pattern.matcher(word);
            if (matcher.find()) {
                System.out.println(word);
            }
        }
    }
}
