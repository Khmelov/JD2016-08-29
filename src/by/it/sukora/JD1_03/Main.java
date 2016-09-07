package by.it.sukora.JD1_03;

/**
 * Created by stasi on 05.09.2016.
 */
public class Main {
    public static void main(String[] args){
        //String line=InOut.consoleReadLine();
        String line ="2 4.6 8.8 9 71 56 4 8 9 56 4 895 4 5";
        System.out.println(line);
        double mas[]=InOut.arrayFromString(line);
        InOut.arrayPrint(mas,"m",2);
        mas=Util.bubbleSort(mas);
        System.out.println("\nSorted M");
        InOut.arrayPrint(mas,"m",2);
        System.out.println("\nSorted Unisort");
        mas=Util.uniSort(mas,true);
        InOut.arrayPrint(mas,"m",2);


    }
}
