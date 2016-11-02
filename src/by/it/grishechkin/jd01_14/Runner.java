package by.it.grishechkin.jd01_14;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by Yury on 24.10.2016.
 */
public class Runner {

    public static void main(String[] args) {
        try {
            File file = TaskA.write();
            TaskA.mean(TaskA.read(file));

            String text= TaskB.read();
            System.out.println("\n" + text);
            TaskB.countWords(text);
            TaskB.countDigits(text);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
