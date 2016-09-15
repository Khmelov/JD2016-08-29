package by.it.emelyanov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA3 {
    public static void SearchVowels() {
        StringBuilder text = new StringBuilder(Data.getString());
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher m = p.matcher(text);
        int count = 0;
        //check
        while (m.find())
            if (Vowel.patVow(m.group()))
            {
                count++;
                System.out.print(m.group() + " ");//print
            }

        System.out.print(" = " + count);
    }
}
