package by.it.artiuschik.jd_01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args){
        StringBuilder sb=new StringBuilder(Data.POEM);
        System.out.println("------Исходный текст----");
        System.out.println(sb.toString());
        Pattern p= Pattern.compile("[а-яА-ЯёЁ]{5,}");
        Matcher m=p.matcher(sb);
        while(m.find()){
            //int start=m.start();
            sb.setCharAt(m.start()+4,'#');
            if(m.group().length()>=7)
                sb.setCharAt(m.start()+6,'#');
        }
        System.out.println("-----Текст после обработки-------");
        System.out.println(sb.toString());
    }
}
