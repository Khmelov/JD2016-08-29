package by.it.senchenko.jd01_02;

/**
 * Created by User on 06.09.2016.
 */
public class TaskA {
    static String getMax(int array[]){
        int lenMax = 0;
        Integer max = Integer.MIN_VALUE;
        for (Integer i:array){
            if(max<i){
                max=i;
            }
        }
        return "Строка с максимальной длинной: " + max.toString() + " её динна = " + max.toString().length();
    }


    static String getMin(int array[]){
        int lenMax = 0;
        Integer min = Integer.MAX_VALUE;
        for (Integer i : array){
            if (min > i){
                min = i;
            }
        }
        return "Строка с минимальной длинной: " + min.toString() + " её длинна = " + min.toString().length();
    }

    static double mean(int array[]){
        double res = 0;
        for (int i:array) res = res + i;
        res = res/array.length;
        return res;
    }

    //задание 3

    static boolean uniqueDigits(Integer value){
        char ch[]=value.toString().toCharArray();
        for (int i = 0; i < ch.length; i++) {
            for (int j = i+1; j < ch.length; j++) {
                if (ch[i]==ch[j]) return false;
            }
        }
        return true;
    }
}
