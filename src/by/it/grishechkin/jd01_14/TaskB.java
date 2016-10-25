package by.it.grishechkin.jd01_14;

import java.io.*;

/**
 * Created by Yury on 24.10.2016.
 */
public class TaskB {

    public static String read() throws FileNotFoundException {

        File file = null;
        try {
            String src = System.getProperty("user.dir") + "/src/by/it/grishechkin/";
            String filename = src + "jd01_14/taskbtext.txt";
            file = new File(filename);
        }
        catch (NullPointerException e) {
            System.err.println("Файл не найден");
        }

        String line;
        String text = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {

            while ((line = br.readLine()) != null) {
                text += line + " ";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    public static String strClear (String str) {
        str = str.replaceAll("\\n", " ");
        str = str.replaceAll("\\p{Punct}", "");
        str = str.replaceAll("  ", " ");
        return str;
    }

    public static void countWords(String str) {
        String[] mas = strClear(str).split(" ");
        System.out.println("Количество слов = " + mas.length);
    }

    public static void countDigits(String text) {

        int before = text.length();
        int after = text.replaceAll("[,.:;-]", "").length();
        System.out.println("Количество знаков препинания в тексте: " + (before - after));
    }
}
