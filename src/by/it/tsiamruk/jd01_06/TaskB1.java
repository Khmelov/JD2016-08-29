package by.it.tsiamruk.jd01_06;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    static String task1(String text){
        StringBuilder mystring = new StringBuilder(Data.POEM);

        Pattern p = Pattern.compile("\\b[бвгджзклмнпрстцчшщхБВГДЖЗКЛМНПРСТЦЧШЩХ]{1}[а-яА-Я]{4}+\\b");
        Matcher m = p.matcher(mystring);


        mystring = new StringBuilder(m.replaceAll("--deleted--"));

        System.out.println(mystring);

        return text;
    }

}



