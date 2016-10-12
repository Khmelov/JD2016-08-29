package by.it.laurynovich.jd01_14;

import java.io.IOException;

/**
 * Created by nadabratb on 09.10.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("TaskA jd01_14");
        TaskA.createFile();
        TaskA.readFile();
        System.out.println();

        System.out.println("TaskB jd01_14");
        TaskB.countWords();
    }
}
