package by.it.laurynovich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA3 {

    static boolean Glasnaya(String word){

        String oae = "яыуаиеоюэёЁЯЫУАИЕЮЭ";
        char first = word.charAt(0);
        char last = word.charAt(word.length()-1);
        return (oae.indexOf(first)>=0 && oae.indexOf(last)>=0);
    }

    public static void main(String[ ] args) {
        StringBuilder text = new StringBuilder(Data.POEM);
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher m = p.matcher(text);
        int counter = 0;
        while (m.find())
            if (Glasnaya(m.group()))
            {
                counter++;
                System.out.println(m.group());
            }
        System.out.print(counter);

    }


}