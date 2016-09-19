package by.it.tsydzik.jd01_06;

/**
 * @author Eugene Tsydzik
 * @since 9/15/16.
 */
public class TaskB2 {

    public static void taskB2() {
        String[] sentenceArray = Data.POEM.replaceAll("\\n", " ").split("[.!?;]+[\\s]");

        int[] numberOfWordsInSentence = new int[sentenceArray.length];
        for (int i = 0; i < sentenceArray.length; i++) {
            numberOfWordsInSentence[i] = sentenceArray[i].split("\\s").length;
        }

        for (int i = 0; i < numberOfWordsInSentence.length - 1; i++) {
            for (int j = i + 1; j < numberOfWordsInSentence.length; j++) {
                if (numberOfWordsInSentence[i] > numberOfWordsInSentence[j]) {
                    int a = numberOfWordsInSentence[i];
                    numberOfWordsInSentence[i] = numberOfWordsInSentence[j];
                    numberOfWordsInSentence[j] = a;

                    String s = sentenceArray[i];
                    sentenceArray[i] = sentenceArray[j];
                    sentenceArray[j] = s;
                }
            }
        }

        for (String s : sentenceArray) {
            System.out.println(s);
        }
    }
}
