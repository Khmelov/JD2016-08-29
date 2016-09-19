package by.it.senchenko.jd01_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by User on 06.09.2016.
 */
public class Util {
    static String getOneLine() throws IOException{
        BufferedReader stln = new BufferedReader(new InputStreamReader(System.in));
        String line = stln.readLine();
        stln.close();
        return line;
    }

    static int[] lineToIntArray(String line){
        String[] strArray = line.split(" ");
        int[] array = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            array[i] = Integer.parseInt(strArray[i]);
        }
        return array;
    }
}
