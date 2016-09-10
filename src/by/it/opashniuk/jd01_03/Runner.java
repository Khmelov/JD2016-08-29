package by.it.opashniuk.jd01_03;

public class Runner {
    public static void main(String[] args) {
        String line="1 2.3 123";
        System.out.println(line);
        double mas[]=InOut.arrayFromString(line);
        InOut.arrayPrint(mas,"m",3);
        mas=Util.bubbleSort(mas);
        System.out.println("\nSorted M\n");
        InOut.arrayPrint(mas,"m",3);

    }
}
