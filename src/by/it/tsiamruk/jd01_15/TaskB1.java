package by.it.tsiamruk.jd01_15;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by waldemar on 30/09/2016.
 */
public class TaskB1 {
    /**
     * @param args input args
     */

    public static void main(String[] args) {
        String src = System.getProperty("user.dir");    // get project Path
        src = src.concat("/src/by/it/tsiamruk/");   //get folder
        String fn = src + "jd01_15/TaskB1.java";    //get file Path
        System.out.println(fn);
        StringBuilder sb = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fn))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line + "\n");
            }
            //System.out.println(sb.toString());
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("File not read");
            e.printStackTrace();
        }
        //processing

        Pattern p = Pattern.compile("/\\*((.|\\n)+\\*)?/");
        Matcher m = p.matcher(sb);
        int pos = 0;
        while (m.find(pos)) {
            sb.delete(m.start(), m.end());
            pos = m.start();
        }

        System.out.println(sb.toString());


    }
}
