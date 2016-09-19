package by.it.savelyeva.jd_01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nato on 9/12/16.
 */


public class TaskA3 {

    public static int countWordsStartEndVowels(String[] words) {
        Pattern pattern = Pattern.compile("^["+Util.VOWELS+"]+[а-яА-ЯЁё]*" + "["+Util.VOWELS+"]$|^["+Util.VOWELS+"]$");
        int count = 0, i = 0;
        for (String s: words) {
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) {
                count++;
                //System.out.printf("%d %s\n", i, s);
                System.out.println(s);
            }
            i++;
        }
        return count;
    }

    public static String[] removeRepeatedWords(String[] words) {
        int count = words.length;
        for (int i=0; i<words.length; i++) {
            if (words[i] != "") {
                for (int j=i+1; j<words.length; j++) {
                    if (words[i].equalsIgnoreCase(words[j])) {
                        words[j] = "";
                        count--;
                    }
                }
            }
        }
        String[] diffWords = new String[count];
        int k = 0;
        for (String s: words) {
            if (s != "") diffWords[k++] = s;
        }
        return diffWords;
    }
}
