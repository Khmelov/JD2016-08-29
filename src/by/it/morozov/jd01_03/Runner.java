package by.it.morozov.jd01_03;

/**
 * Created by BukTpbI4 on 02.09.2016.
 */
public class Runner {
    public static void main(String[] args) {
        //String line=InOut.consoleRadLine();
        String line ="2 4.6 8.8 9 71";
        System.out.println(line);
        double mas[]=InOut.arrayFromString(line);
        InOut.arrayPrint(mas, "m", 3);
        mas=Util.bubbleSort(mas);
        System.out.println("\nSorted M");
        InOut.arrayPrint(mas,"m",3);
        System.out.println("\nSorted Unisort");
        mas=Util.uniSort(mas,true);
        InOut.arrayPrint(mas,"m",3);
    }
}
