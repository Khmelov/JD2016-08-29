package by.it.tsydzik.jd01_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by User on 31.08.2016.
 */
public class Util {

    static String getOneLine() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
//        br.close();
        return line;
    }

    static int[] lineToIntArray(String line) {
        String[] strArray = line.split(" ");

        int[] result = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            result[i] = Integer.parseInt(strArray[i]);
        }
        return result;
    }

    static String[] lineToStringArray(String line) {
        String[] strArray = line.split(" ");
        return strArray;
    }

    static int lineToInt() throws IOException {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();
//        br.close();
            return Integer.parseInt(line);
        }catch (NumberFormatException e){
            System.out.println("You don't entered the number\nENTER THE NUMBER");
            return  lineToInt();
        }

    }
}
