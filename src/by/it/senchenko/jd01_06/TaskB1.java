package by.it.senchenko.jd01_06;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Data.POEM);
        Pattern pattern = Pattern.compile("[\\s][йцкнгшщхъфвпрлджчсмтьбЙЦКНГШЩЗХФВПРЛДЖЧСМТБ]{1}[а-яА-ЯЁё]{4}+[\\ p {Punct}]");
        Matcher matcher = pattern.matcher(text);
        text =  new StringBuilder(matcher.replaceAll(" "));
        System.out.println(text);
    }
}
