package by.it.laurynovich.jd_01_02;


/**
 * Created by vseotdala on 31.08.2016.
 */
public class TaskA {

    public static int getShortNum(int[] mas){
        int result = Integer.MIN_VALUE;
        for (int value:mas){      // 111 2222 33
            int lenValue=String.valueOf(value).length();
            int lenRes=String.valueOf(result).length();
            if (lenRes > lenValue){
                result = value;
            }
        }
        return result;
    }

    public static int getLongNum(int[] mas){
        int result=0;
        for (int value:mas){      // 111 2222 33
            int lenValue=String.valueOf(value).length();
            int lenRes=String.valueOf(result).length();
            if (lenRes < lenValue){
                result = value;
            }
        }
        return result;
    }

    public static int averageNum ( int [] mas){
        int temp = 0;
        int aver = 0;

        for (int i = 0; i < mas.length; i++) {
            temp = temp + mas[i];
            aver = temp / (i+1);

        }
        return aver;
    }

    public static boolean diffChar(Integer value) {
        boolean res = false;
        char[] mas = value.toString().toCharArray();
        for (int i = 0; i < mas.length; i++)
            for (int j = i + 1; j < mas.length; j++)
                if (mas[i] == mas[j]) {
                    res = false;
                    return false;
                }
        return true;
    }

    // public static int differNum (int [] mas ){

}
