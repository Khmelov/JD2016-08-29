package by.it.artiuschik.jd_01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args){
        StringBuilder sb=new StringBuilder(by.it.artiuschik.jd_01_06.Data.POEM);
        System.out.println("------Исходный текст----");
        System.out.println(sb.toString());
        Pattern p= Pattern.compile("\\b[б-дБ-Дж-зЖ-Зк-нК-Нп-тП-Тф-ъФЪ]{1}[а-яА-ЯЁё]{4}\\b");
        Matcher m=p.matcher(sb);
        sb=new StringBuilder(m.replaceAll(""));
        System.out.println("-----Текст после обработки-------");
        System.out.println(sb.toString());
    }
}
