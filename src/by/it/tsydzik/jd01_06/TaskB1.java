package by.it.tsydzik.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Eugene Tsydzik
 * @since 9/14/16.
 */
public class TaskB1 {
    public static void taskB1() {
        // 1 version
        System.out.println("1 version");
        System.out.println(Data.POEM.replaceAll("(?<![а-яА-ЯёЁ])[бБвВгГдДжЖзЗкКлЛмМнНпПрРсСтТфФхЧцЦчЧшШщЩ]{1}[а-яА-ЯЁё]{4}(?![а-яА-ЯёЁ])\\s", ""));

        // 2 version
        System.out.println("\n2 version");
        Pattern p = Pattern.compile("(?<![а-яА-ЯёЁ])[бБвВгГдДжЖзЗкКлЛмМнНпПрРсСтТфФхЧцЦчЧшШщЩ]{1}[а-яА-ЯЁё]{4}(?![а-яА-ЯёЁ])\\s");
        Matcher m = p.matcher(Data.POEM);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, "");
        }
        m.appendTail(sb);
        System.out.println(sb.toString());
    }
}
