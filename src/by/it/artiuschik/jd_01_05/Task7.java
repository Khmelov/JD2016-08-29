package by.it.artiuschik.jd_01_05;

import java.util.Arrays;

import static java.lang.Math.*;

public class Task7 {
    public static double[][] function() {
        double[][] res = new double[2][];
        double[] T = new double[34];
        double[] temp = new double[34];
        int length = 0;
        for (int i = 0; i < T.length; i++) {
            T[i] = (double) round((random() * 5 + 4) * 100) / 100;//округление до 0.01
            if (T[i] < 0.4 * i) {
                temp[length] = T[i];
                length++;
            }

        }
        double[] K = new double[length];
        System.arraycopy(temp, 0, K, 0, length);
        Arrays.sort(K);
        res[0] = K;
        res[1] = T;
        return res;
    }
}
