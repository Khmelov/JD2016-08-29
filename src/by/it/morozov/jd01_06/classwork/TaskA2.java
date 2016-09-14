package by.it.morozov.jd01_06.classwork;

/**
 * Created by BukTpbI4 on 13.09.2016.
 */
public class TaskA2 {
    static void taskA2(){
        String[] words=Data.POEM.split("[^а-яА-яёЁ]+");
        for (int i = 0; i < words.length; i++){
            if (words[i] != ""){
                int counter = 1;
                for (int j = i + 1; j < words.length; j++){
                    if (words[i].equalsIgnoreCase(words[j])){
                        counter++;
                        words[j] = "";
                    }
                }
                System.out.println(words[i]+":"+counter);
            }
        }

    }
}
