package by.it.laurynovich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Created by vseotdala on 13.09.2016.
 */

//  1. Из текста удалить все слова длины 5, начинающиеся на согласную букву.
public class TaskB1 {

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Data.POEM);

        Pattern p = Pattern.compile("[\\s][йцкнгшщхъфвпрлджчсмтьбЙЦКНГШЩЗХФВПРЛДЖЧСМТБ]{1}[а-яА-ЯЁё]{4}+[ |!||.|,|?|:|;|:|-|\\s]");

        Matcher m = p.matcher(text);

        while (m.find())
            if (m.group().trim().length() == 6 || m.group().trim().length() == 5)
            {
                int start = m.start();
                text.delete(start+1, start+6);
                m = p.matcher(text);
            }
            System.out.println(text.toString());
            return;

    }

}
