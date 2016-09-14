package by.it.savelyeva.jd_01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nato on 9/13/16.
 */
public class TaskC3 {
    private static StringBuilder vowels = new StringBuilder("аеёиоуыэюя");

    private static int[] nextWordCoords(int position, StringBuilder sb) {
        /**
         * @return an int[2] array where:
         * posCoords[0] = word start position,
         * posCoords[1] is the position of the first symbol after word
         */
        //StringBuilder word = new StringBuilder("");
        if (position < sb.length()) {
            while (Pattern.matches("[^а-яА-ЯёЁ]", String.valueOf(sb.charAt(position)))) {
                position++;
                if (position == sb.length()) break;
            }
        }
        int startPos = position;
        if (position < sb.length()) {
            while (Pattern.matches("[а-яА-ЯёЁ]", String.valueOf(sb.charAt(position)))) {
                //word.append(sb.charAt(position));
                position++;
                if (position == sb.length()) break;
            }
        }
        //System.out.println(word);
        int endPos = position;
        int[] posCoords = {startPos, endPos};
        return posCoords;
    }

    private static int vowelsCount(StringBuilder word) {
        int count = 0;
        for (int i=0; i<vowels.length(); i++) {
            int j = 0;
            while (j < word.length()) {
                if (String.valueOf(word.charAt(j)).compareTo(String.valueOf(vowels.charAt(i))) == 0) count++;
                j++;
            }
        }
        return count;
    }


    public static StringBuilder sortWords(StringBuilder sb) {
        int[] curCoords, nextCoords;
        boolean replacementsDone;
        do {
            replacementsDone = false;
            int i = 0, j = 0;
            while (i < sb.length()) {
                curCoords = TaskC3.nextWordCoords(j, sb);
                if (curCoords[0] == curCoords[1]) break;
                nextCoords = TaskC3.nextWordCoords(curCoords[1], sb);
                if (nextCoords[0] == nextCoords[1]) break;
                StringBuilder curWord = new StringBuilder(sb.substring(curCoords[0], curCoords[1]));
                StringBuilder nextWord = new StringBuilder(sb.substring(nextCoords[0], nextCoords[1]));
                if (nextWord.length() > curWord.length()
                        || (nextWord.length() == curWord.length() && vowelsCount(curWord) > vowelsCount(nextWord))) {
                    sb.delete(nextCoords[0], nextCoords[0] + nextWord.length());
                    sb.insert(nextCoords[0], curWord);
                    sb.delete(curCoords[0], curCoords[0] + curWord.length());
                    sb.insert(curCoords[0], nextWord);
                    j = nextCoords[1] - curWord.length();
                    replacementsDone = true;
                }
                else j = nextCoords[0];
            }
        } while (replacementsDone);
        return sb;
    }

}
