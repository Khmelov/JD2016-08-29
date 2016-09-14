package by.it.savelyeva.jd_01_05.math;

/**
 * Created by nato on 9/12/16.
 */
public class Task7 {
    public static int[] createArrayA(int arrayLength, int leftBound, int rightBound) {
        int[] resultArray = new int[arrayLength];
        for (int i=0; i<arrayLength; i++) {
            resultArray[i] = Math.round(leftBound + (float) Math.random() * (rightBound - leftBound + 1));
        }
        return resultArray;
    }

    public static int[] createArrayFromArray(int[] inputArray) {
        int count = 0;
        for (int i=0; i<inputArray.length; i++) {
            if (inputArray[i] * 0.1 > i) count++;
        }
        int[] resultArray = new int[count];
        for (int i=0, j=0; i<inputArray.length; i++) {
            if (inputArray[i] * 0.1 > i) {
                resultArray[j++] = inputArray[i];
            }
        }
        sortIntArray(resultArray);
        return resultArray;
    }

    public static int[] sortIntArray(int[] mas) {
        for (int i=0; i< mas.length-1; i++) {
            for (int j=i+1; j< mas.length; j++) {
                if (mas[i] > mas[j]) {
                    int tmp = mas[i];
                    mas[i] = mas[j];
                    mas[j] = tmp;
                }
            }
        }
        return mas;
    }
}
