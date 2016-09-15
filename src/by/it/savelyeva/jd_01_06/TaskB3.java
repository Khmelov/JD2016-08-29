package by.it.savelyeva.jd_01_06;

/**
 * Created by nato on 9/12/16.
 */
public class TaskB3 {
    private static String[] wordsUniSort(String[] words, String symbol) {
        /**
         * This method sorts array of strings either alphabetically or by frequency of given symbol.
         * The method is private and contains sorting logic -
         * this allows other sorting methods to be short and public, they will serve as wrappers.
         * The method does not support sorting direction since it is not required in the task.
         */
        int last = words.length - 1;
        boolean sorted, tmpCondition;
        do {
            sorted = true;
            for (int i=0; i<words.length-1; i++) {
                if (symbol.compareTo("") == 0) {
                    tmpCondition = words[i].compareTo(words[i+1]) > 0;
                }
                else {
                    tmpCondition = (" "+words[i]+" ").split(symbol).length < (" "+words[i+1]+" ").split(symbol).length;
                }
                if (tmpCondition) {
                    String tmp = words[i];
                    words[i] = words[i+1];
                    words[i+1] = tmp;
                    sorted = false;
                }
            }
            last--;
        } while (last>0);
        return words;
    }

    public static String[] sortWordsBySymbolFrequency(String[] words, String symbol) {
        /**
         * A wrapper [public] method for private method 'wordsUniSort()'
         */
        words = sortWordsByAlphabet(words);
        words = wordsUniSort(words, symbol);
        return words;
    }

    public static String[] sortWordsByAlphabet(String[] words) {
        /**
         * A wrapper [public] method for private method 'wordsUniSort()'
         */
        return wordsUniSort(words, "");
    }
}
