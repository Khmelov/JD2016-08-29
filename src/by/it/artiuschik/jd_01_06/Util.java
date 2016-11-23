package by.it.artiuschik.jd_01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
    //Вставить пробелы в строку
    static String insertSpacesToString(int number, String str) {
        int index;
        StringBuilder line = new StringBuilder(str);
        while (number > 0) {
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
            str = line.toString();
        }

        return line.toString();
    }

    //поделить строку на слова
    static String[] words(String str) {
        return str.split("[^а-яА-ЯёЁ]+");
    }

    //найти слово заданной длины
    static String findWord(String[] words, int length) {
        for (String word : words) {
            if (word.length() == length) {
                return word;
            }

        }
        return "";
    }

    static long timeWin() {
        long startString = System.currentTimeMillis();
        TaskC2.createMillionString();
        long endString = System.currentTimeMillis();
        long startStringBuilder = System.currentTimeMillis();
        TaskC2.createMillionStringBuilder();
        long endStringBuilder = System.currentTimeMillis();
        return (endString - startString) - (endStringBuilder - startStringBuilder);
    }

}
