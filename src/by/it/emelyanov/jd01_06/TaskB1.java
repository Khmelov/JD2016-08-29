package by.it.emelyanov.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void Repl() {
        char[] chars = "БВГДЖЗЙКЛМНПРСТФХЦЧШЩ".toCharArray();
        StringBuffer sb = new StringBuffer();
        Matcher m = Pattern.compile("\\b([а-яА-ЯёЁ])(.+?)\\b").matcher(Data.getString());//b-word border
        int count = 0;
        //search and repl
        while (m.find()) {
            if (m.group(2).length() == 4 && Arrays.binarySearch(chars, m.group(1).toUpperCase().charAt(0)) >= 0) {
                count++;
                System.out.print(m.group() + " ");
                m.appendReplacement(sb, "_____");
            }
        }
        //print
        System.out.println();
        System.out.println("Количество слов: " + count + '\n');
        m.appendTail(sb); // after repl.
        System.out.println(sb);

    }
}