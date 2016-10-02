package by.it.emelyanov.jd01_14;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        System.out.println("TaskA");
        TaskA.createFileWith20Numbs();
        TaskA.readFileWith20Numbs();

        System.out.println("\nTaskB");
        TaskB.checkPunctuation();
        TaskB.checkWords();

        System.out.println("\nTaskC");
        TaskC.printCatalogAndFileList();
    }
}
