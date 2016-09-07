package by.it.tsydzik.jd01_01;

/**
 * Created by User on 31.08.2016.
 */
public class TaskA3 {
    public static void isDifferentNumbers(int[] intArray) {
        int[] plusArray = new int[intArray.length];

        for (int i = 0; i < intArray.length; i++) {
            plusArray[i] = Math.abs(intArray[i]);
        }

        for (int i = 0; i < plusArray.length; i++) {
            if (diffChar(plusArray[i])) {
                System.out.println("Result = " + intArray[i]);
                break;
            }
        }
    }

    public static boolean diffChar(int value) {
        char[] mas = Integer.toString(value).toCharArray();
        boolean result = false;
        for (int i = 0; i < mas.length - 1; i++) {
            for (int j = 0; j < mas.length; j++) {
                if (mas[i] != mas[j]) {
                    return true;
                }
            }
        }
        return result;
    }
}
