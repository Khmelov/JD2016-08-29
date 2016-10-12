package by.it.senchenko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TaskB2 {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Data.POEM);
        Pattern pattern = Pattern.compile("\\n");
        Matcher matcher = pattern.matcher(text);
        text = new StringBuilder(matcher.replaceAll(" "));
        String nt[] = text.toString().trim().split("[.!?;]+\\s*");
        int count = 1;
        while (count !=200) {
            for (int i = 0; i < nt.length; i++) {
                if (nt[i].length() == count) {
                    System.out.println(nt[i]+" "+nt[i].length());
                }
            }
            count++;
        }
    }
}
