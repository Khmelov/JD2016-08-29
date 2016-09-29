package by.it.tsiamruk.jd01_06;

public class Main {
    public static void main(String[] args){
        TaskA.task1();
        System.out.println();
        TaskA.task2();
        System.out.println();
        TaskA.task3();
        System.out.println();
        //////////TaskB////////////
        StringBuilder first = new StringBuilder(Data.POEM);
        System.out.println("___TASK1 of TASK B___");
        TaskB1.task1(first.toString());
        System.out.println("___Task2 of TASK B___");
        //deleteing lines
        first = new StringBuilder(Data.POEM.replaceAll("\\n", " "));
        //testing getting array of sentences method.
        //TaskB2.arrayOfSentences(myString.toString());
        String[] senteces = TaskB2.arrayOfSentences(first.toString());
        //test array of word
        //TaskB2.wordsAmount(senteces);
        //test sort method
        int[] wordsAmount = TaskB2.wordsAmount(senteces);
        TaskB2.sort(senteces, wordsAmount);
        System.out.println("___Task3 of TASK B___");
        String textForTask = new String(Data.POEM);
        TaskB3.textCleaner(textForTask);
        TaskB3.sorter(TaskB3.textCleaner(textForTask), 'о');





    }
}
