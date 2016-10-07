package by.it.tsiamruk.jd01_15;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by waldemar
 */
public class TaskB {

    static String filePath() {
        String src = System.getProperty("user.dir");    // get project Path
        src = src.concat("/src/by/it/tsiamruk/");   //get folder
        return src + "jd01_15/TaskB.txt";
    }


    static StringBuilder readToStringBuilder() {
        String src = System.getProperty("user.dir");    // get project Path
        src = src.concat("/src/by/it/tsiamruk/");   //get folder
        String fn = src + "jd01_15/TaskB.java";    //get file Path

        //System.out.println(fn);
        StringBuilder sb = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fn))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            //System.out.println(sb.toString());
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("File not read");
            e.printStackTrace();
        }
        //delete javadoc comment

        Pattern p = Pattern.compile("//.*|(\\\"(?:\\\\\\\\[^\\\"]|\\\\\\\\\\\"|.)*?\\\")|(?s)/\\\\*.*?\\\\*/");
        Matcher m = p.matcher(sb);
        int pos = 0;
        while (m.find(pos)) {
            sb.delete(m.start(), m.end());
            pos = m.start();
        }

        //delete usual comments

        return sb;
    }

    static StringBuilder indexator(StringBuilder sb) {
        StringBuilder res = new StringBuilder();
        int n = 1;
        int i = 0;
        while (i < sb.length()) {
            int start = i;
            int end = sb.indexOf("\n", start);
            res.append(n).append(": ").append(sb.substring(start, end)).append("\n");
            n++;
            i = end + 1;
        }
        return res;
    }

    static void consolePrint(StringBuilder sb) {
        System.out.println(sb);
    }

    static void filePrint(String filePath, StringBuilder sb) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
            pw.print(sb);
        } catch (IOException e) {
            System.out.print("Ошибка ввода вывода ");
            e.printStackTrace();
        }
    }
}
