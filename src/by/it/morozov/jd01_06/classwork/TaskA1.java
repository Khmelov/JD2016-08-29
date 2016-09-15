package by.it.morozov.jd01_06.classwork;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by BukTpbI4 on 09.09.2016.
 */
public class TaskA1 {
    static void taskA1(){
        StringBuilder sb = new StringBuilder(Data.POEM);
        Pattern p = Pattern.compile("[а-яА-яёЁ]{5,}");
        Matcher m = p.matcher(sb);
        while (m.find()){
            int pos = m.start();
            sb.setCharAt(pos + 4,'#');
            if (m.group().length() >= 7)
                sb.setCharAt(pos + 6, '#');
        }
        System.out.println(sb.toString());
    }
}
