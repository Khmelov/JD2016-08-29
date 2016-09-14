package by.it.rudzko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Kir on 13.09.2016.
 */
public class TaskB {
    public static String delCons(String s){
        StringBuffer sb = new StringBuffer(s);
        int a=sb.length();
        sb.append("\nКонец!");

        Pattern p=Pattern.compile("[^а-яА-ЯёЁ][Б-Щб-щ^еЕёЁиИоОуУ]([а-я]{4})[^а-яА-ЯёЁ]");
        Matcher m=p.matcher(sb);
        while (m.find()){
            m.appendReplacement(sb, " ");
        }
        sb.delete(0, a+7);

        return sb.toString();
    }

    public static String[] compSent(String s){
        StringBuilder sb = new StringBuilder(Data.POEM);
        Pattern p=Pattern.compile("\n");
        Matcher m=p.matcher(sb);
        while (m.find()){
            sb.setCharAt(m.start(), ' ');
        }
        String [] poem=sb.toString().split("[.!?]+[ ]");
        for (int i=0; i<poem.length-1; i++){
            for (int j=i+1; j<poem.length; j++){
                String [] one=poem[i].split(" ");
                int a=one.length;
                String [] next=poem[j].split(" ");
                int b=next.length;
                if (a>b){
                    String ex=poem[j];
                    poem [j]=poem[i];
                    poem[i]=ex;
                }
            }
        }
        return poem;
    }
    public static String [] sortWords(String s, String z){
        String [] poem=s.toLowerCase().split("[^а-яА-ЯёЁ]+");
        for (int i=0; i<poem.length-1; i++){
            for (int j=i+1; j<poem.length; j++){
                StringBuffer sb1 = new StringBuffer(poem[i]);
                StringBuffer sb2 = new StringBuffer(poem[j]);
                Pattern p=Pattern.compile(z);
                Matcher m1=p.matcher(sb1);
                int count1=0;
                while (m1.find()){
                    count1++;
                }
                Matcher m2=p.matcher(sb2);
                int count2=0;
                while (m2.find()){
                    count2++;
                }
                if (count1>count2){
                    String ex=poem[j];
                    poem [j]=poem[i];
                    poem[i]=ex;
                } if (count1==count2) {
                    if (poem[i].compareTo(poem[j])>0) {
                        String ex = poem[j];
                        poem[j] = poem[i];
                        poem[i] = ex;
                    }
                }
            }
        }
        return poem;
    }
}
