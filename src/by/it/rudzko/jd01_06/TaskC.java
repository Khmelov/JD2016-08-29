package by.it.rudzko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Leta on 12.09.2016.
 */
public class TaskC {

    public static String[] format(String s){
        String []a=s.trim().split("\n");

        String l=a[0];
        for (int i=1; i<a.length; i++) {
            if (a[i].length()>l.length()) {
                l = a[i];
            }
        }
        for (int i=0; i<a.length; i++){
            int dif=l.length()-a[i].length();
            StringBuffer sb=new StringBuffer(a[i]);
            Pattern p=Pattern.compile(" ");
            Matcher m=p.matcher(sb);
            int count=0;
            while (m.find()&&count<dif){
                sb.insert(m.start()," ");
                count++;
            }
            a[i]=sb.toString();
        }
        return a;
    }

    public static long conc(String s){
        long t1= System.currentTimeMillis();
        String [] m=s.toLowerCase().split("[^а-яА-ЯёЁ]+");
        String con="";
        for (int i=0; con.length()<999990; i++){
            con=con.concat(m[(int)(Math.random()*m.length-1)]).concat(" ");
        }
        int dif=1000000-con.length();
        String add="";
        for (int i=0; i<m.length; i++){
            if (m[i].length()==dif){
                add=m[i];
                break;
            }
        }
        con=con.concat(add);
        long t2= System.currentTimeMillis();
        long t=t2-t1;
        System.out.println(con);
    return t;
    }

    public static long strMilsb(String s){
        long t1= System.currentTimeMillis();
        String [] m=s.toLowerCase().split("[^а-яА-ЯёЁ]+");
        StringBuilder mil=new StringBuilder();
        for (int i=0; mil.length()<999990; i++){
            mil.append(m[(int)(Math.random()*m.length-1)]+" ");
        }
        int dif=1000000-mil.length();
        String add="";
        for (int i=0; i<m.length; i++){
            if (m[i].length()==dif){
                add=m[i];
                break;
            }
        }
        mil.append(add);
        long t2= System.currentTimeMillis();
        long t=t2-t1;
        System.out.println(mil.toString());
        return t;
    }

    public static String[][] sortCountWords(String s){
        String [] poem=s.toLowerCase().split("[^а-яА-ЯёЁ]+");
        for (int i=0; i<poem.length-1; i++) {
            for (int j = i + 1; j < poem.length; j++) {

                if (poem[i].length() < poem[j].length()) {
                    String ex = poem[j];
                    poem[j] = poem[i];
                    poem[i] = ex;
                }
                if (poem[i].length() == poem[j].length()) {
                    StringBuffer sb1 = new StringBuffer(poem[i]);
                    StringBuffer sb2 = new StringBuffer(poem[j]);
                    Pattern p=Pattern.compile("[аАеЕёЁиИоОуУэЭюыЮяЯ]");
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

                    if (count1 > count2) {
                        String ex = poem[j];
                        poem[j] = poem[i];
                        poem[i] = ex;
                    }
                }
            }
        }
            String[][] a = new String[poem.length][2];
            for (int i = 0; i < poem.length; i++) {
                if (poem[i] != "") {
                    int count = 1;
                    for (int j = i + 1; j < poem.length; j++) {
                        if (poem[i].equals(poem[j])) {
                            count++;
                            poem[j] = "";
                        }
                    }

                    a[i][0] = poem[i];
                    if (count>1) {
                        a[i][1] = Integer.toString(count);
                    }
                }
            }

        return a;
    }
}
