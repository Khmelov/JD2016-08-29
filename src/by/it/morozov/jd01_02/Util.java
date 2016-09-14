package by.it.morozov.jd01_02;
import java.util.Scanner;
/**
 * Created by BukTpbI4 on 13.09.2016.
 */
public class Util {
    static public String readFromConsole(){
        String result;
        Scanner scanner=new Scanner(System.in);
        result=scanner.nextLine();
        return result;
    }
    static public int[] getArrayInt(String line){
        String strArray[]=line.split(" ");
        int result[]=new int[strArray.length];
        for (int i = 0; i < strArray.length; i++){
            result[i]=Integer.parseInt(strArray[i]);
        }
        return result;
    }
    static public void printArray(int[] mas){
        for (int value:mas){
            System.out.println(" "+value);
        }
        System.out.println();
    }
}
