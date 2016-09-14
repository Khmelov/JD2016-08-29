package by.it.savelyeva.jd_01_05;

/**
 * Created by nato on 9/7/16.
 */
import java.util.Scanner;

public class InOut {
    public static final String leftTop = "\u2554";      // "╔";
    public static final String rightTop = "\u2557";     // "╗";
    public static final String leftBottom = "\u255A";   // "╚";
    public static final String rightBottom = "\u255D";  // "╝";
    public static final String crossTop = "\u2566";     // "╦";
    public static final String crossBottom = "\u2569";  // "╩";
    public static final String crossInner = "\u256C";   // "╬";
    public static final String horLine = "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550";    // "═";
    public static final String vertLine = "\u2551";     // "║";
    public static final String crossLeft = "\u2560";    // "╠";
    public static final String crossRight = "\u2563";   // "╣";
    public static final String emptyCell = "            \u2551"; // "║";

    public static String[] readFromConsole() {
        //String line = "-21 7 2 567 44 55 -3 88 999";
        System.out.print("Enter space-separated numbers: ");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] strArray = line.split(" ");
        return strArray;
    }

    public static void printArray(double[] mas, String name, int cols) {
        System.out.printf("Array %s:\n", name);
        int col = 0;
        for (int i = 0; i < mas.length; i++) {
            System.out.printf("%s[% -3d]=%-8.5f ", name, i, mas[i]);
            col++;
            if ((0 == col % cols) || (mas.length - 1 == i)) System.out.println();
        }
    }

    public static void printArray(int[] mas, String name, int cols) {
        System.out.printf("Array %s:\n",name);
        int col = 0;
        for (int i=0; i<mas.length; i++) {
            System.out.printf("%s[% -3d]=%d ", name, i, mas[i]);
            col++;
            if ((0 == col%cols) || (mas.length-1 == i)) System.out.println();
        }
    }

    private static void drawLine(String leftEnd, String cellSeparator, String rightEnd, int countCells) {
        String borderLine = leftEnd;
        for (int j=0; j<countCells; j++) {
            borderLine += horLine;
            if (j != countCells - 1) borderLine += cellSeparator;
        }
        borderLine += rightEnd;
        System.out.println(borderLine);
    }

    private static void drawCells(String nameMas, int[] valuesMas, int startCell, int countCells, boolean byRow) {
        System.out.print(vertLine);
        int rows = (int) valuesMas.length / countCells;
        int forStart = byRow ? 0 : startCell ;
        int forEnd = byRow ? countCells : startCell+countCells;

        for (int j = forStart; j < forEnd; j++) {
            int k = byRow ? startCell + j * rows : j ;
            if (k < valuesMas.length) {
                System.out.printf(" %s[% -3d]=%s %s", nameMas, k, valuesMas[k], vertLine);
            } else {
                System.out.print(emptyCell);
            }
        }
        System.out.println();
    }

    public static void drawArray(int[] mas, String name, int cols, boolean byRow) {
        System.out.printf("Draw array %s:\n", name);
        int col = 0;
        int n = byRow ? mas.length/cols+1 : mas.length ;
        int increment = byRow ? 1 : cols ;
        for (int i=0; i<n; i+=increment) {
            if (0 == i) {
                drawLine(leftTop, crossTop, rightTop, cols);
            } else {
                drawLine(crossLeft, crossInner, crossRight, cols);
            }
            drawCells(name, mas, i, cols, byRow);
        }
        drawLine(leftBottom, crossBottom, rightBottom, cols);
    }
}
