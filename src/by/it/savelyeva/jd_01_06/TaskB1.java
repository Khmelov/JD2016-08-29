package by.it.savelyeva.jd_01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nato on 9/12/16.
 */
public class TaskB1 {
    public static StringBuilder remove5LetterWords(String data) {
        StringBuilder sb = new StringBuilder(data);
        Pattern pattern = Pattern.compile("[\\s]+["+Util.CONSONANTS+"]{1}[а-яА-ЯЁё]{4}[\\s|!|.]{1}");
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) {
            //System.out.println(matcher.group());
            int start = matcher.start();
            if (matcher.group().trim().length() == 5) {
                sb.delete(start+1, start+6);
                matcher = pattern.matcher(sb);
            }
        }
        return sb;
    }
}
