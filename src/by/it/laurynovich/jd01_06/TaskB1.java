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
        Pattern p = Pattern.compile("[ ][йцкнгшщхъфвпрлджчсмтьбЙЦКНГШЩЗХЪФВПРЛДЖЧСМТЬБ]{1,}[А-Яа-яёЁ]{4}[ |,|:|;|.]");
        Matcher m = p.matcher(text);
        StringBuilder newText = new StringBuilder();
        while (m.find()){

        newText = text.delete(m.start(1),m.start(6));}
        System.out.println(newText);

    }

}
