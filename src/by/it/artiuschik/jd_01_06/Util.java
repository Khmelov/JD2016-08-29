package by.it.artiuschik.jd_01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
    //Вставить пробелы в строку
    public static String insertSpacesToString(int number,String str)
    {
        int index=0;
        StringBuffer line=new StringBuffer(str);
        while(number>0) {
            Pattern p = Pattern.compile("\\b[^а-яА-ЯёЁ]+\\b");
            Matcher m = p.matcher(str);
            index = 0;
            while (m.find()) {
                line.insert(m.end() + index, ' ');
                number--;
                if (number == 0) {
                    break;
                }
                index++;
            }
        str=line.toString();
        }

        return line.toString();
    }
    //поделить строку на слова
    public static String[] words(String str)
    {
        String[] result=str.split("[^а-яА-ЯёЁ]+");
        return result;
    }
    //найти слово заданной длины
    public static String findWord(String[] words,int length)
    {
        for (int i = 0; i <words.length ; i++) {
            if(words[i].length()==length)
            {
                return words[i];
            }

        }
        return "";
    }
    public static long timeWin(String str)
    {
        long startString=System.currentTimeMillis();
        TaskC2.createMillionString(str);
        long endString=System.currentTimeMillis();
        long startStringBuilder=System.currentTimeMillis();
        TaskC2.createMillionStringBuilder(str);
        long endStringBuilder=System.currentTimeMillis();
        return (endString-startString)-(endStringBuilder-startStringBuilder);
    }

}
