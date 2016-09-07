package by.it.tsydzik.jd01_03;

public class Main {

    public static void main(String[] args) {
        //String line = InOut.consoleReadLine();
        String line = "1 2 3 123 1 2 3 45";
        System.out.println(line);

        double mas[] = InOut.arrayFromString(line);
        InOut.arrayPrint(mas, "m", 3);

        mas = Util.sortBubble(mas);
        System.out.println("\n\nSorted array:");
        InOut.arrayPrint(mas, "m", 3);
    }
}
