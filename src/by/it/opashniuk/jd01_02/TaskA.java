package by.it.opashniuk.jd01_02;


public class TaskA {

    static public int getShortNum(int[] mas) {
        int result=Integer.MIN_VALUE;
        for (int value:mas) {
            int lenValue=String.valueOf(value).length();
            int lenResult=String.valueOf(result).length();
            if (lenResult>=lenValue) {
                result=value;
            }
        }
        return result;
        }

    static public int getLongNum(int[] mas) {
        int result=0;
        for (int value:mas) {
            int lenValue=String.valueOf(value).length();
            int lenResult=String.valueOf(result).length();
            if (lenResult<=lenValue) {
                result=value;
            }
        }
        return result;
    }

    static public double getAverageNum(int[] mas) {
        int sum=0;
        for (int value:mas) {
            int lenValue=String.valueOf(value).length();
                sum=sum + value;
        }
        return sum;
    }
}
