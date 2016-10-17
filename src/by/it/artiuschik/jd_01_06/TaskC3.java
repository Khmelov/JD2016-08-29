package by.it.artiuschik.jd_01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC3 {
    public static int vowelAmount(String word) {
        int counter = 0;
        Pattern p = Pattern.compile("[аАэ-яЭ-ЯуУёЁоОиИ]");
        Matcher m = p.matcher(word);
        while (m.find()) {
            counter++;
        }
        return counter;
    }

    public static String[] sortByLength(String[] mas) {
        for (int i = 0; i < mas.length - 1; i++) {
            for (int j = i + 1; j < mas.length; j++) {
                if (mas[i].length() < mas[j].length()) {
                    String temp = mas[i];
                    mas[i] = mas[j];
                    mas[j] = temp;
                } else {
                    if (mas[i].length() == mas[j].length()) {
                        if (vowelAmount(mas[j]) < vowelAmount(mas[i])) {
                            String temp = mas[i];
                            mas[i] = mas[j];
                            mas[j] = temp;
                        }
                    }
                }
            }

        }
        return mas;
    }

    public static int wordAmount(String[] mas, String word) {
        int counter = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i].equalsIgnoreCase(word) == true) {
                counter++;
            }
        }
        return counter;
    }

    public static void printWords(String[] mas) {
        String [] words=new String[mas.length];
        for (int i = 0; i < words.length; i++) {
            words[i]=mas[i];
        }
        for (int i = 0; i < words.length; i++) {
            if ((words[i].equalsIgnoreCase("") == false)) {
                if (wordAmount(mas, words[i]) > 1) {
                    System.out.println(words[i] + " " + wordAmount(mas, words[i]));
                    for (int j = i+1; j < words.length; j++) {
                        if(words[j].equalsIgnoreCase(words[i]))
                        {
                            words[j]="";
                        }
                    }
                } else {
                    System.out.println(words[i]);
                }
            }

        }
    }
    public static void main(String[] args) {
        System.out.println("--------Исходный текст---------");
        System.out.println(by.it.artiuschik.jd_01_06.Data.POEM);
        System.out.println("--------Результат---------");
        printWords(sortByLength(by.it.artiuschik.jd_01_06.Util.words(Data.POEM)));
    }

}


