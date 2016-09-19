package by.it.vashukevich.jd01_02;

import java.util.Scanner;

/*
 * Created by Admin on 31.08.16.
 */
public class Util {
    static String readFromConsole(){
        String result;
       Scanner scanner = new Scanner(System.in);
       result=scanner.nextLine();
        return result;
    }
    static int[] getArrayInt(String line){
        String strArray[]=line.split(" ");
        //split преобразовывает строку в массив целых данных
        int mas[]=new int[strArray.length];
        for (int i=0;i<strArray.length;i++){
            mas[i]=Integer.parseInt(strArray[i]);
        }
        return mas;
    }
    static void printArray(int[] mas){
        for (int value:mas){
            System.out.println(" "+value);
        }
    }
}
