package by.it.vashukevich.jd01_06;

import java.lang.reflect.ParameterizedType;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Admin on 12.09.16.
 */
public class TaskA3 {
    static boolean Vowels(String words) {
        String glas = "аеёиоуыэюя";
        glas = glas + glas.toUpperCase();
        char first = words.charAt(0);
        char last = words.charAt(words.length() - 1);
        return (glas.indexOf(first) >= 0 && glas.indexOf(last) >= 0);
    }


    public static void main(String[] args) {
        StringBuilder line = new StringBuilder(Data.POEM);
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher m = p.matcher(line);
        int count = 0;
        while (m.find())
            if (Vowels(m.group())) {
              count++;
                System.out.println(m.group());
            }
        System.out.print(count);
    }
}

