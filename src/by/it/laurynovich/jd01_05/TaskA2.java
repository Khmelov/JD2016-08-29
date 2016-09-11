package by.it.laurynovich.jd01_05;

/**
 * Created by vseotdala on 09.09.2016.
 */
public class TaskA2 {

    public static void main(String[] args) {
        System.out.println("TaskA1 02");
        String [] words = Data.POEM.split("[^а-яА-ЯёЁ]+");

        for (int i = 0; i < words.length; i++) {
            if (words[i] != ""){
                int counter=1;
                for (int j = i+1; j <words.length ; j++) {
                    if (words[i].equalsIgnoreCase(words[j])) {
                        counter++;
                        words[j] = "";
                    }
                }

                System.out.println(words[i]+":"+counter);
            }
        }
    }
}
