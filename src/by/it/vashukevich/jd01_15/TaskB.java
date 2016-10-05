package by.it.vashukevich.jd01_15;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @ param args input params
 */
public class TaskB {
    public static void main(String[] args) {
        String src = System.getProperty("user.dir");//get projectPath
        src = src.concat("/src/by/it/vashukevich/");//get folder
        // String fn="D:\\Java\\JD2016-08-29\\JD2016-08-29\\src\\by\\it\\vashukevich\\jd01_15\\TaskB.java";
        String fn = src + "jd01_15/TaskB.java";//get file Pat
        System.out.println(fn);
        StringBuilder sb = new StringBuilder();
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(fn));
                FileReader fileReader = new FileReader(fn);) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line + "\n");
                //System.out.println(sb);//в скобках вызывается .toString
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("File not read");
            e.printStackTrace();
        }
        //processing

       /* Pattern pattern = Pattern.compile("/\\*((.|\\n)+\\*)?/");
        Matcher matcher = pattern.matcher(sb);
        int pos=0;
        while (matcher.find()) {
            sb.delete(matcher.start(),matcher.end());
            pos=matcher.start();
        }
        System.out.println(sb);*/
    }
}
