package by.it.rudzko.jd01_02B;

/**
 * Created by Kir on 05.09.2016.
 */
public class InOut {

    static void arPrint(int a[], int cols) {
        int c = 0;
        for (int value : a) {
            System.out.printf("%5s", String.valueOf(a[c]));
            c++;
            if (c % cols == 0 || c == a.length)
                System.out.println();
        }
    }


}


