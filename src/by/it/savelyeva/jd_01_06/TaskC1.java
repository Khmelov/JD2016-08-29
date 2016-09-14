package by.it.savelyeva.jd_01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nato on 9/13/16.
 */
public class TaskC1 {
   private static Matcher getMatcher(String data, String regexp) {
       StringBuilder sb = new StringBuilder(data);
       Pattern pattern = Pattern.compile(regexp);
       Matcher matcher = pattern.matcher(sb);
       matcher.reset();
       return matcher;
   }

    private static Matcher getSplitLinesMatcher(String data) {
        return getMatcher(" \n" + data + "\n", "[^\\n]+[\\n]{1}");
    }

    private static Matcher getSplitWordsMatcher(String data) {
        return getMatcher(data, "[^а-яА-ЯЁё]+");
    }

    private static int findMaxLengthMatchers(Matcher matcher) {
        int maxLength = 0;
        while (matcher.find()) {
            if (maxLength < matcher.group().length()) {
                maxLength = matcher.group().length();
            }
        }
        matcher.reset();
        return maxLength;
    }

    public static StringBuilder formatPoem(String data) {
        Matcher matcher = getSplitLinesMatcher(data);
        int maxLength = findMaxLengthMatchers(matcher);
        StringBuilder sb = new StringBuilder("");
        while (matcher.find()) {
            String s = matcher.group();
            int needSpaces = maxLength - s.length();
            Matcher wordsMatcher = getSplitWordsMatcher(s);
            if (wordsMatcher.find()) {
                StringBuilder sbLine = new StringBuilder(s);
                int start = 0;
                while (needSpaces > 0) {
                    int increment = 0;
                    while (wordsMatcher.find()) {
                        if (0 == needSpaces) break;
                        else needSpaces--;
                        String word = wordsMatcher.group();
                        increment += word.length();
                        start += increment;
                        int pos = sbLine.indexOf(" ", start);
                        if (pos >= 0) sbLine.insert(pos, " ");
                        else sbLine.insert(sbLine.indexOf(" ", 0), " ");
                    }
                    wordsMatcher.reset();
                }
                sb.append(sbLine.toString());
            }
        }
        return sb;
    }


}
