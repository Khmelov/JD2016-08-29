package by.it.tsydzik.jd01_06;

/**
 * Created by user on 09.09.2016.
 */
public class TaskA2 {
    public static void taskA2() {

        String[] words = Data.POEM.split("[^а-яА-ЯЁё]+");

        for (int i = 0; i < words.length; i++) {
            if (words[i] != "") {
                int count = 1;
                for (int j = i + 1; j < words.length; j++) {
                    if (words[i].equalsIgnoreCase(words[j])) {
                        count++;
                        words[j] = "";
                    }
                }
                System.out.println("Word = " + words[i] + " : found " + count);
            }
        }

    }

}
