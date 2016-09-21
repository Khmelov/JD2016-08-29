package by.it.grishechkin.jd01_02;

/**
 * Created by Yury on 31.08.2016.
 */
public class TaskA {

    static public int getShortNumber (int[] mas) {

        int result = Integer.MIN_VALUE;

        for (int value : mas) {
            int lenVal = String.valueOf(value).length();
            int lenRez = String.valueOf(result).length();

            if (lenRez > lenVal) {
                result = value;
            }
        }
        return result;
    }

    static public int getLongNumber (int[] mas) {

        int result = 0;

        for (int value : mas) {
            int lenVal = String.valueOf(value).length();
            int lenRez = String.valueOf(result).length();

            if (lenRez < lenVal) {
                result = value;
            }
        }
        return result;
    }

    static public int getLengthNumber (int num) {
        return Integer.toString(num).length();
    }

    static public double meanNumbers (int[] mas) {
        double average = 0;
        if (mas.length > 0)
        {
            double sum = 0;
           /* for (int j = 0; j < mas.length; j++) {
                sum += mas[j];
            }
            average = sum / mas.length;*/

            int j = 0;
            while (j < mas.length) {
                sum += mas[j];
                j++;
            }
            average = sum / mas.length;
        }
        return average;
    }

    /**
     *
     * @param num
     * @return true if number is of different digits
     */

    static public boolean isNumberOfDifferentDigits(int num) {
        String str = Integer.toString(num);
        boolean flag = true;
        char [] myCharArray = str.toCharArray ();
        for (int i = 0; i < myCharArray.length; i++) {
            for (int j = i; j < myCharArray.length; j++) {
                if (myCharArray[i] == myCharArray[j] && i != j) {
                    flag = false;
                    break;
                }
            }
        }
        if (flag) return true;
        else return false;
    }

}
