package by.it.laurynovich.jd01_05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by vseotdala on 09.09.2016.
 */
public class TaskA1 {

        public static void main(String[] args) {
            StringBuilder sb = new StringBuilder(Data.POEM);
            Pattern p = Pattern.compile("[а-яА-ЯёЁ]{5,}");
            Matcher m = p.matcher(sb);
            while (m.find()) {

                // System.out.println(m.group());
                int pos = m.start();
                sb.setCharAt(pos +4, '#');
                if (m.group().length() >= 70) {
                    sb.setCharAt(pos + 6, '#');
                }
            }
            System.out.println(sb.toString());
        }

}
