package by.it.artiuschik.jd_01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String args[]) {
        System.out.println(by.it.artiuschik.jd_01_06.Data.POEM);
        String stroka = by.it.artiuschik.jd_01_06.Data.POEM;
        Pattern p = Pattern.compile("\\n");
        Matcher m = p.matcher(stroka);
        stroka = m.replaceAll(" ");
        String sentences[] = stroka.split("\\b[?!.] \\b");
        int[] sentenceLength = new int[sentences.length];
        String[][] words = new String[sentences.length][];
        for (int i = 0; i < sentences.length; i++) {
            words[i] = sentences[i].toString().split("[^а-яА-ЯёЁ]+");
            sentenceLength[i] = words[i].length;
        }
        Arrays.sort(sentenceLength);
        for (int i = 0; i < sentenceLength.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (words[j].length == sentenceLength[i]) {
                    System.out.println(sentences[j]);
                }
            }

        }

    }


}
