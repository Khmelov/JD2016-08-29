package by.it.savelyeva.jd_01_06;

import java.util.Random;

/**
 * Created by nato on 9/13/16.
 */
public class TaskC2 {
    private static final int COUNT = 1000000;

    private static String selectWord(int wordLength, String[] wordsSet) {
        int i = 0;
        while (wordLength != wordsSet[i].length()) {
            i++;
        }
        return wordsSet[i];
    }

    public static String millionSymbols(String data) {
        String[] wordsSet = Util.splitToWords(data, false);
        String resultStr = "";
        Random rnd = new Random();
        while (COUNT - resultStr.length() > 10) {
            resultStr += wordsSet[rnd.nextInt(wordsSet.length)] + " ";
        }
        String lastWord = selectWord(COUNT - resultStr.length(), wordsSet);
        resultStr += lastWord;
        //System.out.println(lastWord);
        //System.out.println(resultStr.length());
        return resultStr;
    }

    public static StringBuilder millionSymbolsBuilder(String data) {
        String[] wordsSet = Util.splitToWords(data, false);
        StringBuilder sb = new StringBuilder("");
        Random rnd = new Random();
        while (COUNT - sb.length() > 10) {
            sb.append(wordsSet[rnd.nextInt(wordsSet.length)]);
            sb.append(" ");
        }
        String lastWord = selectWord(COUNT - sb.length(), wordsSet);
        sb.append(lastWord);
        //System.out.println(lastWord);
        //System.out.println(sb.length());
        //System.out.println(sb.toString());
        return sb;
    }

}
