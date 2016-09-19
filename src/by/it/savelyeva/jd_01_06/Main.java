package by.it.savelyeva.jd_01_06;

/**
 * Created by nato on 9/9/16.
 */
public class Main {
    public static void main(String[] args) {

        String[] words;
        StringBuilder sb;
        int count;

        System.out.println("Task A1: in all words with length>=5 replace 5th and 7th symbols with #.");
        sb = TaskA1.replaceChars(Data.POEM);
        System.out.println(sb.toString());
        System.out.println();


        System.out.println("Task A2: count words frequency.");
        words = Util.splitToWords(Data.POEM, false);
        TaskA2.countWordsFrequency(words);
        System.out.println();


        System.out.println("Task A3: find all words which start and end with vowels.");
        words = Util.splitToWords(Data.POEM, false);
        count = TaskA3.countWordsStartEndVowels(words);
        System.out.printf("All words with vowels at start and end = %d\n", count);
        String[] diffWords = TaskA3.removeRepeatedWords(words);
        count = TaskA3.countWordsStartEndVowels(diffWords);
        System.out.printf("Different words with vowels at start and end = %d (case ignored)\n", count);
        System.out.println();


        System.out.println("Task B1: delete all words of length 5 which start with a consonant.");
        sb = TaskB1.remove5LetterWords(Data.POEM);
        System.out.println(sb.toString());
        System.out.println();


        System.out.println("Task B2: sort ascending all statements by words count, display statements without new line symbols.");
        String[] statements = Util.splitToStatements(Data.POEM);
        sb = TaskB2.sortStatements(statements);
        System.out.println(sb.toString());
        System.out.println();


        System.out.println("Task B3: sort descending all words by frequency of given symbol, if equal then sort alphabetically.");
        words = Util.splitToWords(Data.POEM, true);
        words = TaskB3.sortWordsBySymbolFrequency(words, "а");
        Util.printArray(words);
        System.out.println();


        System.out.println("Task C1: make each line of a poem to have same length by adding spaces between words.");
        sb = TaskC1.formatPoem(Data.POEM);
        System.out.println(sb.toString());
        System.out.println();


        System.out.println("Task C2: create a string of 1 million symbls in length, compare time execution if using String and StringBuilder.");
        Long t1, t2, delta1, delta2;
        System.out.println("Started random string of million symbols using String[]...");
        t1 = System.currentTimeMillis();
        TaskC2.millionSymbols(Data.POEM);
        t2 = System.currentTimeMillis();
        delta1 = t2 - t1;
        System.out.printf("Method using String[] took %10.3f seconds\n\n", (double) (delta1 / 1000.0));
        System.out.println("Started random string of million symbols using StringBuilder...");
        t1 = System.currentTimeMillis();
        TaskC2.millionSymbolsBuilder(Data.POEM);
        t2 = System.currentTimeMillis();
        delta2 = t2 - t1;
        System.out.printf("Method using StringBuilder took %10.6f seconds (%d milliseconds)\n\n", (double) (delta2 / 1000.0), delta2);
        System.out.printf("Speed improvement: %10.3f seconds (%d microseconds)", (double) (delta1 - delta2) / 1000.0, (delta1 - delta2)*1000000);
        System.out.println();


        System.out.println("Task C3: sort words by lengths descending, if lengths are equal, sort by frequency of vowels ascending");
        sb = new StringBuilder(Data.POEM.toLowerCase());
        sb = TaskC3.sortWords(sb);
        System.out.println(sb.toString());
        words = Util.splitToWords(sb.toString(), false);
        TaskA2.countWordsFrequency(words);

    }
}
