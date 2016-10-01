package by.it.artiuschik.jd_01_15;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task15B {
    /**
     * @param args input parans
     */
    public static void main(String[] args) {
        String src = System.getProperty("user.dir");//get project path
        src = src + "/src/by/it/artiuschik/";//get folder
        String fn = src + "jd_01_15/Task15B.java";
        System.out.println(fn);
        StringBuilder sb=new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fn))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("File not read");
            e.printStackTrace();
        }
        //processing
        Pattern pattern= Pattern.compile("/\\*((.|\\n)+\\*)?/");
        Matcher matcher= pattern.matcher(sb);
        int pos=0;
        while(matcher.find(pos)){
            sb.delete(matcher.start(),matcher.end());
            pos=matcher.start();
        }
        System.out.println(sb);

    }
}
