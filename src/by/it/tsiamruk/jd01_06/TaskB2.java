package by.it.tsiamruk.jd01_06;

public class TaskB2 {

    //Getting Array of sentences.
    static String[] arrayOfSentences(String a){

        String[] sentences = a.trim().split("[.!?]+\\s*");
        //test
        //System.out.println(sentences.length);
        return sentences;
    }
    //now we need to get array of word in every element of array sentences
    //couse we need to get array in every element, we need to iterate over all of those.
    static int[] wordsAmount(String[] array){
        int[] wordsAmount = new int[array.length];
        for (int i = 0; i < array.length; i++) {
             wordsAmount[i] = array[i].split("\\s").length;
        }
        return wordsAmount;
    }
    //now we must sort arrays
    static void sort(String[] sentences, int[] wordsAmount){

        for (int i = 0; i < wordsAmount.length; i++) {
            for (int j = 0; j < wordsAmount.length - 1; j++) {
                if (wordsAmount[j] > wordsAmount[j + 1]) {
                    int a = wordsAmount[j];
                    wordsAmount[j] = wordsAmount[j + 1];
                    wordsAmount[j + 1] = a;

                    String s = sentences[j];
                    sentences[j] = sentences[j + 1];
                    sentences[j + 1] = s;
                }
            }
        }

        for (String s: sentences){
            System.out.println(s);
        }
    }


}
