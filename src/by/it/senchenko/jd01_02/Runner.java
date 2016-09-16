package by.it.senchenko.jd01_02;

import java.io.IOException;

/**
 * Created by User on 06.09.2016.
 */
public class Runner {
    public static void main(String[] args) throws IOException{
        //String text="1 22 333 4444 55555 666666";
        System.out.println("Введите числа через пробел");
        String text = Util.getOneLine();
        int arr[]=Util.lineToIntArray(text);
        String max= TaskA.getMax(arr);
        System.out.println(max);
        String min= TaskA.getMin(arr);
        System.out.println(min);

        //задание 2
        double mean= TaskA.mean(arr);
        System.out.print("Числа меньше "+mean+": ");
        for (int i:arr) {
            if(i<mean){
                System.out.print(" | " +i+" |");
            }
        }
        System.out.println();

        //задание 3
        for(int i:arr){
            if(TaskA.uniqueDigits(i)){
                System.out.println("Число из разных цифр: "+i);
            }
        }
    }
}
