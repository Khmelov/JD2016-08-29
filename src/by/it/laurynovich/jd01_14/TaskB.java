package by.it.laurynovich.jd01_14;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by nadabratb on 09.10.2016.
 */
public class TaskB {

    private static String src = System.getProperty("user.dir") + "/src/by/it/laurynovich/jd01_14/file/";
    static String filename = src + "testText.txt";
    static File file = new File(filename);

    //D:\it-academy\IdeaProjects\JD2016-08-29\src\by\it\laurynovich\jd01_14\file\testText
    protected static void countWords() {
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayListPunkt = new ArrayList<>();
        FileReader fileReader = null;

        try {
            fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = "";

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("[^a-zA-Z]+");
                for (String word : words) {
                    arrayList.add(word);
                }
                String[] punkts = line.split("[,|.|?|!|:|;]+");
                for (String punkt : punkts) {
                    arrayListPunkt.add(punkt);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int words = arrayList.size();
        int p = arrayListPunkt.size();
        System.out.println("Количество знаков препинания в тексте = " + p);
        System.out.println("Количество слов в тексте = " + words);
    }

}
