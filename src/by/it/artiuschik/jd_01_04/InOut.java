package by.it.artiuschik.jd_01_04;

class InOut {
    static void printArr(double[][] m) {
        for (double[] aM : m) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.printf("%6.2f ", aM[j]);
            }
            System.out.println();
        }
    }

    static void printArr(double[] m, String name, int cols) {
        int col = 0;
        for (int i = 0; i < m.length; i++) {
            System.out.print(name);
            System.out.printf("[% -3d]=%-9.4f ", i, m[i]);
            col++;
            if ((0 == col % cols) || (m.length - 1 == i)) {
                System.out.println();
            }
        }
    }
}
