package by.it.artiuschik.jd_01_03;
public class Util {
    static double[] bubbleSort(double[] mas) {
        int last = mas.length - 1;
        boolean sorted;
        do {
            sorted = true;
            for (int i = 0; i < last; i++) {
                if (mas[i] > mas[i + 1]) {
                    double tmp = mas[i];
                    mas[i] = mas[i + 1];
                    mas[i + 1] = tmp;
                    sorted = false;
                }
            }
            last--;
        }
        while (!sorted);
        return mas;
    }

    static double[] uniSort(double[] mas, boolean upDirection) {
        for (int i = 0; i < mas.length - 1; i++) {
            for (int j = i + 1; j < mas.length; j++) {
                if ((!upDirection && mas[i] < mas[j]) ||
                        (upDirection && mas[i] > mas[j])) {
                    double tmp = mas[i];
                    mas[i] = mas[j];
                    mas[j] = tmp;
                }
            }
        }

        return mas;
    }
}
