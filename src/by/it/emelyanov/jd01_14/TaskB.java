package by.it.emelyanov.jd01_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TaskB {
    static String src = System.getProperty("user.dir") + "/src/by/it/emelyanov/jd01_14/data/";
    static String filename = src + "text.txt";

    static void checkPunctuation() {
        int counterP = 0;
        try {
            Scanner sc = new Scanner(new File(filename));
            sc.useDelimiter("[^.,!?\"()-;:]+");
            while (sc.hasNext()) {
                sc.next();
                counterP++;
            }
            sc.close();
            System.out.println("Количество знаков препинания " + counterP);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + filename);
        }
    }

    static void checkWords() {
        int counterW = 0;
        try {
            Scanner sc = new Scanner(new File(filename));
            sc.useDelimiter("[^a-zA-Z]+");
            while (sc.hasNext()) {
                sc.next();
                counterW++;
            }
            sc.close();
            System.out.println("Количество слов " + counterW);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + filename);
        }
    }
}
