package by.it.tsydzik.jd01_15;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Eugene Tsydzik
 * @since 9/30/16.
 */
public class TaskB {

    /**
     * @since 9/30/16.
     */
    public static void taskB() {
        String src = System.getProperty("user.dir");    //get Project path
        src = src.concat("/src/by/it/tsydzik/");        //get Folder path
        String fn = src + "/jd01_15/TaskB.java";        //get File path
        System.out.println(fn);
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(fn))) {

            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
//            System.out.println(sb);

        } catch (FileNotFoundException e) {
            System.out.println("File not read");
        } catch (IOException e) {
            System.out.println("File not read");
            e.printStackTrace();
        }

        //processing

        Pattern pattern = Pattern.compile("/\\*((.|\\n)+\\*)?/");
        Matcher matcher = pattern.matcher(sb);

        int position = 0;
        while (matcher.find(position)) {
            sb.delete(matcher.start(), matcher.end());
            position = matcher.start();
        }
        System.out.println(matcher.group());

    }
}
