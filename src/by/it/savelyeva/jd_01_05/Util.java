package by.it.savelyeva.jd_01_05;

/**
 * Created by nato on 9/7/16.
 */
public class Util {

    public static double[] convertStringsToNums(String[] strArray) {
        double[] result = new double[strArray.length];
        for (int i=0; i<strArray.length; i++) {
            result[i] = Double.parseDouble(strArray[i]);
        }
        return result;
    }

}
