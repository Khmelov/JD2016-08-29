package by.it.rudzko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Kir on 13.09.2016.
 */
public class TaskA {
    public static String changeSym(String s) {
        StringBuilder sb = new StringBuilder(s);
        Pattern p=Pattern.compile("[а-яА-ЯёЁ]{5,}");
        Matcher m=p.matcher(sb);
        while (m.find()){
            int pos=m.start();
            sb.setCharAt(pos+4,'#');
            if (m.group().length()>=7){
                sb.setCharAt(pos+6,'#');
            }
        }

        return sb.toString();
    }
    public static String[][] countWords(String s) {
        String[] words = Data.POEM.split("[^а-яА-ЯёЁ]+");
        String[][] a = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            if (words[i] != "") {
                int count = 1;
                for (int j = i + 1; j < words.length; j++) {
                    if (words[i].equalsIgnoreCase(words[j])) {
                        count++;
                        words[j] = "";
                    }
                }

                a[i][0] = words[i];
                a[i][1] = Integer.toString(count);

            }
        }
        return a;
    }
    public static int findVoc(String s){
        StringBuilder sb = new StringBuilder(Data.POEM);
        Pattern p=Pattern.compile("[^а-яА-ЯёЁ][аАеЕёЁиИоОуУыэЭюЮяЯ]|[аеёиоуыэюя][^а-яА-ЯёЁ]");
        Matcher m = p.matcher(sb);
        int a=0;
        while (m.find()){
            a++;
        }
        return a;
    }
}
