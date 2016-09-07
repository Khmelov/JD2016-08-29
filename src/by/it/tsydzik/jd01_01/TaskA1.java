package by.it.tsydzik.jd01_01;

/**
 * @author Eugene Tsydzik
 * @since 9/6/16.
 */
public class TaskA1 {
    public static String getLongNum(int[] array) {

        int result = 0;
        for (int value : array) {
            int lenValue = String.valueOf(value).length();
            int lenResult = String.valueOf(result).length();

            if (lenResult < lenValue) {
                result = value;
            }
        }
        return "Max = " + Integer.toString(result) + ", length = " + Integer.toString(result).length();
    }

    public static String getShortNum(int[] array) {
        int result = Integer.MAX_VALUE;
        for (int value : array) {
            int lenValue = String.valueOf(value).length();
            int lenResult = String.valueOf(result).length();

            if (lenResult > lenValue) {
                result = value;
            }
        }
        return "Min = " + Integer.toString(result) + ", length = " + Integer.toString(result).length();
    }
}
