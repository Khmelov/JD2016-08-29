package by.it.laurynovich.jd01.jd01_15;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by vseotdala on 9/30/2016.
 */
public class Task15B {
    public static void taskB() {
        /**
         *   hjghkg
        * */
        String src = System.getProperty("user.dir");

        src = src.concat("\\src\\by\\it\\laurynovich\\");  //get folder
        String fn = src + "\\jd01_15\\Task15B.java";                  //get file path
        System.out.println(fn);
        StringBuilder sb = new StringBuilder();

        try (BufferedReader bufferReader = new BufferedReader(new FileReader(fn))) {
            String line;
            while ((line = bufferReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            System.out.println("file not read");
        }

        Pattern pattern = Pattern.compile("/\\*(?:.|[\r\n])*?\\*/");
        Matcher matcher = pattern.matcher(sb);
        int pos = 0;
        while (matcher.find(pos)) {
            sb.delete(matcher.start(), matcher.end());
            pos = matcher.start();

        }
        System.out.println(sb);
    }
}
