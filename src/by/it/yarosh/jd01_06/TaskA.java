package by.it.yarosh.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TaskA {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Data.POEM);
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]{5,}");
        Matcher m = p.matcher(sb);
        while (m.find()) {
            int start = m.start();
            sb.setCharAt(start + 4, '#');
            if (m.group().length() >= 7)
                sb.setCharAt(start + 6, '#');
            System.out.println(m.group());


        }


    }
}
