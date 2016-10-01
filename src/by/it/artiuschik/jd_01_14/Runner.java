package by.it.artiuschik.jd_01_14;

import java.io.*;

public class Runner {
    public static void main(String[] args) throws IOException {
        String src = System.getProperty("user.dir");
        src = src + "/src/by/it/artiuschik/";
        String fn = src + "jd_01_14/numbers.dat";
        TaskA.writeToFile(fn);
        TaskA.readFromFile(fn);
        //TaskB
        fn = src + "jd_01_14/text.txt";
        String text=TaskB.readText(fn);
        System.out.println(text);
        System.out.println("Количество знаков препинания "+TaskB.numberOfPunctuation(text));
        System.out.println("Количество слов "+TaskB.numberOfWords(text));
        //TaskC
        File file=new File("./src/by/it");
        System.out.println(file.getCanonicalPath());
        System.out.println("---Файлы----");
        for (int i = 0; i < file.listFiles().length; i++) {
            if (file.listFiles()[i].isFile()) {
                System.out.println(file.list()[i]);
            }
        }
        System.out.println("----Каталоги----");
            for (int i = 0; i < file.listFiles().length; i++) {
                if(file.listFiles()[i].isDirectory()) {
                    System.out.println(file.list()[i] + "   ");
                }
        }

    }
}
