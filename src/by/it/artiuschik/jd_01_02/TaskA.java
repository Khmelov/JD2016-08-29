package by.it.artiuschik.jd_01_02;

public class TaskA {
    static int getShortNum(int[] mas) {
        int result = Integer.MIN_VALUE;
        for (int value : mas) {
            int lenValue = String.valueOf(value).length();
            int lenResult = String.valueOf(result).length();
            if (lenResult > lenValue) {
                result = value;
            }
        }

        return result;
    }

    static int getLongNum(int[] mas) {
        int result = 0;
        for (int value : mas) {
            int lenValue = String.valueOf(value).length();
            int lenResult = String.valueOf(result).length();
            if (lenResult < lenValue) {
                result = value;
            }
        }

        return result;
    }

    static double mean(int[] array) {
        double res = 0;
        for (int i : array) res += i;
        res = res / array.length;
        return res;
    }

    static boolean uniqueDigits(Integer value) {
        char[] charArray = value.toString().toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            for (int j = i + 1; j < charArray.length; j++) {
                if (charArray[i] == charArray[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
