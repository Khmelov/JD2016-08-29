package by.it.vashukevich.jd1_03;

import java.io.IOException;

/*
 * Created by Admin on 03.09.16.
 */
public class Runner {
       public static void main(String[] args) throws IOException {
        String line= InOut.consoleReadLine();
        double mas[]= InOut.stringLineToInArray(line);
        System.out.println("Массив v");
        InOut.arrayPrint(mas,"m",5);

        double[][] mass= InOut.inArrayPrint2D();
        System.out.println("Двумерный массив");
        //InOut.arrayPrint2D(mas);
        InOut.arrayPrint2D(mass,"m");

        mas= Util.sortMas(mas);
        System.out.println("Сортировка Bubble sort");
        InOut.arrayPrint(mas,"m",2);
        System.out.println("\nSorted Unisort");

        mas= Util.sortIntArray(mas,true);
        InOut.arrayPrint(mas,"m",2);

       }
}



