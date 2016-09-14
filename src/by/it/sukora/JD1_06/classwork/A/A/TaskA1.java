package by.it.sukora.JD1_06.classwork.A.A;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by stasi on 09.09.2016.
 */
public class TaskA1 {
    public static void main(String[] args) {

        
    StringBuilder sb = new StringBuilder(Data.POEM);

    Pattern p=Pattern.compile("[а-яА-ЯёЁ]{5,}");
        Matcher m=p.matcher(sb);
        while (m.find())
        {
            int start = m.start();
            sb.setCharAt(start+4,'#');
            if(m.group().length()>=7)
                sb.setCharAt(start+6,'#');

            //System.out.println(m.group());
        }
        System.out.println(sb.toString());


        // sb.setCharAt(1,'#');
}
}
