package by.it.laurynovich.jd01_03;

/**
 * Created by vseotdala on 02.09.2016.
 */
public class Utill {
    static double[] bubbleSort(double[] mas) {
        int last = mas.length - 1;
        boolean sorted=true;
        do {
            for (int n = 0; n < mas.length - 1; n++)
                for (int i = 0; i < mas.length - 1; i++) {
                    if (mas[i] > mas[i + 1]) {
                        double tmp = mas[i];
                        mas[i] = mas[i + 1];
                        mas[i + 1] = tmp;
                        sorted=false;
                    }

                }
            last--;
        }
        while (!sorted);
        return mas;
    }

    static double[] uniSort(double[] mas) {
        for (int i = 0; i < mas.length - 1; i++) {
            for (int j = 0; j < mas.length; j++) {
                if (mas[i] > mas[j]) {
                    double tmp = mas[i];
                    mas[i] = mas[i + 1];
                    mas[i + 1] = tmp;

                }

            }

        }
        return mas;
    }
}
