package by.it.grishechkin.jd01_15;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Yury on 24.10.2016.
 */
public class TaskB {

    public static StringBuilder read() {
        String src = System.getProperty("user.dir") + "/src/by/it/grishechkin/";
        String filename = src + "jd01_15/TaskB.java";
        File file = new File(filename);
        String line;
        StringBuilder text = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {

            int flag = 1;
            while ((line = br.readLine()) != null) {
                if (flag < 10)
                text.append("0" + flag + " " + line + "\n");
                else text.append(flag + " " + line + "\n");
                flag++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }


    public static void delite(StringBuilder text) {
        System.out.println(text);

        String src = System.getProperty("user.dir") + "/src/by/it/grishechkin/";
        String filename = src + "jd01_15/TaskB.txt";
        File file = new File(filename);

        Pattern pat = Pattern.compile("(?!\")//.*"); // регулярное выражение поиска комментариев
        Matcher match = pat.matcher(text); // получаем объект соответствий к строке
        String result = match.replaceAll(""); // заменяем все соответствия пустой строкой

        pat = Pattern.compile("/\\*(?:.|[\r\n])*?\\*/"); /* регулярное выражение поиска комментариев*/
        match = pat.matcher(result); /* получаем объект соответствий к строке*/
        result = match.replaceAll(""); /* заменяем все соответствия пустой строкой*/
        System.out.println(result);

        try (BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)))) {
                br.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
