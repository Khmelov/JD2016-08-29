package by.it.tsydzik.jd01_03;

public class Util {
    public static double[] sortBubble(double[] mas) {
        int last = mas.length - 1;
        boolean sorted;
        do {
            sorted = true;
            for (int i = 0; i < mas.length - 1; i++) {
                if (mas[i] > mas[i + 1]) {
                    double tmp = mas[i];
                    mas[i] = mas[i + 1];
                    mas[i + 1] = tmp;
                    sorted = false;
                    /*
                    int a = 5, b = 3;
                    a = a + b -(b=a);
                    System.out.printf("a=%d, b=%d", a,b);
                    //Note: here we will have a restriction to the values of a and b to put them both into int type
                    */
                }
            }
            last--;
        } while (last > 0);
        return mas;
    }

    public static double[] uniSort(double[] mas, boolean upDirection) {
        for (int i = 1; i < mas.length - 1; i++) {
            for (int j = i + 1; j < mas.length; j++) {
                if (upDirection && mas[i] > mas[j] ||
                        !upDirection && mas[i] < mas[j]) {
                    double tmp = mas[i];
                    mas[i] = mas[j];
                    mas[j] = tmp;
                }
            }
        }
        return mas;
    }
}
