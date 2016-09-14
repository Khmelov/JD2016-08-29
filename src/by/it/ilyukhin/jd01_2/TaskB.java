package by.it.ilyukhin.jd01_2;

public class TaskB {
    public static void main(String[] args) {
        /*System.out.println("Введите значение k");
        int k = Util.inputK();
        System.out.println("Введите значение n");
        int n = Util.inputN();
        System.out.println("Введите значение m");
        int m = Util.inputM();
        if (k >= n && k <= m) {
            System.out.println("k принадлежит индервалу [n;m]");
        } else {
            System.out.println("k не принадлежит интервалу [n;m]");
        }
        /**
         * @param N число столбцов и строк массива
         * @param K конечное значение интервала
         */

        System.out.println("Введите натуральное значение k");
        double K =  3;//Math.sqrt(Util.inputK());
        System.out.println("Введите значение N");
        int N = 5;//Util.inputN2();
        int col = 0;
        double[][] mas = new double[N][N];
        N = mas.length;
        for (int i = 1; i <=K; i++) {
            System.out.printf("%-6d", i);
            col++;
            if ((0 == col % N) || (mas.length== i)) {

                System.out.println();
            }
        }
    }
}










