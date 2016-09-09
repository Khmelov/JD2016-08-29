package by.it.emelyanov.jd01_02;

public class TaskB {
    static String getAffiliations(int aff) {
        //B1.
        int n = 0;
        int m = 100;
        if (aff > n && aff < m) {
            System.out.println("Число " + aff + " принадлежит интервалу [" + n + "," + m + "]");
        } else {
            System.out.println("Число " + aff + " не принадлежит интервалу [" + n + "," + m + "]");
        }
        return "";
    }

    //B2.
    static String getArray(int K) {
        // слева направо
        int count1 = 1;
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                System.out.printf("%3s", count1++);
            }
            System.out.println();
        }
        System.out.println("");
        // сверху вниз
        int count2 = 1;
        for (int i = 1; i <= K; i++) {
            for (int j = 1; j < K; j++) {
                System.out.printf("%3s", count2 + " ");
                count2 += 6;
            }
            System.out.println(count2);
            count2 = i + 1;
        }
        return "";
    }
}
