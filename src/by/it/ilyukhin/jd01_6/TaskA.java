package by.it.ilyukhin.jd01_6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Data.POEM);
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]{5,}");
        Matcher m = p.matcher(sb);
        while (m.find()) {
            int start = m.start();
            sb.setCharAt(start + 4, '#');
            if (m.group().length() >= 7) {
                sb.setCharAt(start + 6, '#');
            }
        }
        System.out.println(sb.toString());

        String[] words = Data.POEM.split("[^а-яА-ЯёЁ]+");

        for (int i = 0; i < words.length; i++) {
            if (words[i] != "") {
                int counter = 1;
                for (int j = i + 1; j < words.length; j++) {
                    if (words[i].equalsIgnoreCase(words[j])) {
                        counter++;
                        words[j] = "";
                    }
                }
                System.out.println(words[i] + ":" + counter);
            }
        }
        Pattern p2 = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher m2 = p2.matcher(Data.POEM);
        int counter = 0;
        while (m2.find())
            if (Vowel.Glasnaya(m2.group())) {
                counter++;
                System.out.println(m2.group());
            }

            System.out.print(counter);

        }
    }




