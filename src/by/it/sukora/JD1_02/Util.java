package by.it.sukora.JD1_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by stasi on 04.09.2016.
 */
public class Util {
    static String getOneLine() throws IOException
    {
        BufferedReader stin = new BufferedReader(new InputStreamReader(System.in));
        String line = stin.readLine();
        stin.close();
        return line;
    }
    static int[] LineToIntArray(String line){
        String[] strArray = line.split(" ");
        int[] array = new int[strArray.length];
        for(int j=0;j<strArray.length;j++)
        {
            array[j]= Integer.parseInt(strArray[j]);
        }
        return array;
    }
}
