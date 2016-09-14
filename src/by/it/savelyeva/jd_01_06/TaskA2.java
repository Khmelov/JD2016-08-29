package by.it.savelyeva.jd_01_06;

/**
 Created by nato on 9/9/16.
 */
public class TaskA2 {
    public static void countWordsFrequency(String[] words) {
        for (int i=0; i<words.length; i++) {
            if (words[i] != "") {
                int count = 1;
                for (int j=i+1; j<words.length; j++) {
                    if (words[i].equalsIgnoreCase(words[j])) {
                        count++;
                        words[j] = "";
                    }
                }
                System.out.printf("Word = %s found %d time(s)\n", words[i], count);
            }
        }

    }

}
