package by.it.rudzko.jd01_02A;

/**
 * Created by Kir on 02.09.2016.
 */
public class Task2 {
    public static float AMean (int ar[]) {
        float s = 0;
        for (int value : ar) {
            String num = String.valueOf(value);
            float n = num.length();
            s+= n;
        }
        float am = s/ar.length;
        return am;
    }
    public static int qShort (int ar[], float am){

        int nums = 0;
        for (int value : ar) {
            String num = String.valueOf(value);
            float n = num.length();
            if (n < am)
                nums++;
        }
        return nums;
    }

    public static int[] shortNumsAr (int ar[], int x, float am){
        int shortNums[]=new int[x];
        int a = 0;
        for (int value: ar) {
            String num = String.valueOf(value);
            float n = num.length();
            if (n < am) {
                shortNums[a] = value;
                a++;
            }
        }
        return shortNums;
        }
    }

