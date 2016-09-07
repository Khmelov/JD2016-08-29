package by.it.rudzko.jd01_02A;

/**
 * Created by Kir on 01.09.2016.
 */
public class Task1 {
    public static int findShortest(int x[]){
        int a=Integer.MIN_VALUE;
        for (int value: x){
            String text1=String.valueOf(value);
            int length1=text1.length();
            String text2=String.valueOf(a);
            int length2=text2.length();
            if (length2>length1){
            a=value;
            }

        }
        return a;
    }
    public static int findLongest(int x[]){
        int a=0;
        for (int value: x){
            String text1=String.valueOf(value);
            int length1=text1.length();
            String text2=String.valueOf(a);
            int length2=text2.length();
            if (length2<=length1){
                a=value;
            }

        }
        return a;
    }
}
