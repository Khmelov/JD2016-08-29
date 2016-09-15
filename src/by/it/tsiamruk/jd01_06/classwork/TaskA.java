package by.it.tsiamruk.jd01_06.classwork;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA {
    static void task1(){
        StringBuilder sb = new StringBuilder(Data.POEM);
        Pattern p = Pattern.compile("[а-яА-яёЁ]{5,}");
        Matcher m = p.matcher(sb);

        while (m.find()){
            int pos = m.start();
            sb.setCharAt(pos + 4,'#');
            if (m.group().length() >= 7)
                sb.setCharAt(pos + 6, '#');
        }

        System.out.println(sb.toString());
    }

    static void task2(){
        String[] words=Data.POEM.split("[^а-яА-яёЁ]+");


        for (int i = 0; i < words.length; i++){
            if (words[i] != ""){
                int counter = 1;
                for (int j = i + 1; j < words.length; j++) {
                    if (words[i].equalsIgnoreCase(words[j])) {
                        counter++;
                        words[j] = "";
                    }
                }
                System.out.println(words[i]+":"+counter);
            }
        }



    }
}
