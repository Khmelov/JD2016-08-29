package by.it.senchenko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA3 {

    static boolean Glasnaya(String word){
        String glas="яыуаиеоюэё";
        glas=glas+glas.toUpperCase();
        char first=word.charAt(0);
        char last=word.charAt(word.length()-1);
        return (glas.indexOf(first)>=0 && glas.indexOf(last)>=0);
    }

    public static void main(String[ ] args) {
        StringBuilder text=new StringBuilder(Data.POEM);
        Pattern pattern=Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher=pattern.matcher(text);
        int counter=0;
        while (matcher.find())
            if (Glasnaya(matcher.group()))
            {
                counter++;
                System.out.println("Слово: "+matcher.group());
            }

        System.out.print("Колличество слов: "+counter);
    }
}

