package by.it.tsiamruk.jd01_06;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    static void task1(){
        StringBuilder mystring = new StringBuilder(Data.POEM);

        Pattern p = Pattern.compile("\\b[бвгджзклмнпрстцчшщхБВГДЖЗКЛМНПРСТЦЧШЩХ]{1}[а-яА-Я]{4}+\\b");
        Matcher m = p.matcher(mystring);


        mystring = new StringBuilder(m.replaceAll("deleted"));

        System.out.println(mystring);
    }

    static void task2(){
        StringBuilder myString = new StringBuilder(Data.POEM);

        String regex = "[^.]*[^.]*(\\.|$)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(myString);
        int c = 0;
        while (m.find()){
            c++;
        }

    }
}



