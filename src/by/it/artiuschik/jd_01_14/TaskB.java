package by.it.artiuschik.jd_01_14;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static int numberOfPunctuation(String text)
    {
        int counter=0;
        Pattern p= Pattern.compile("[\\\\p{Punkt}]");
        Matcher m=p.matcher(text);
        while(m.find())
        {
            counter++;
        }
        return counter;
    }

    public static String readText(String fn) {
        StringBuilder sb=new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fn))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("File not read");
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static int numberOfWords(String text)
    {
        int counter=0;
        Pattern p= Pattern.compile("\\b[а-яА-ЯёЁa-zA-Z]+\\b");
        Matcher m=p.matcher(text);
        while(m.find())
        {
            counter++;
        }
        return counter;
    }

}
