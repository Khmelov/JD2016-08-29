package by.it.rudzko.jd01_02B;

import java.util.Scanner;

/**
 * Created by Kir on 05.09.2016.
 */
public class Util {

    public static boolean Incl (int num, int min, int max){
        if (num>=min && num<=max){
            return true;
        }
        return false;
    }

    public static int[] fillAr(int x) {
        int ar[] = new int[x];
        int s = 0;
        for (int i=0; i<x; i++) {
            ar[i] = s + 1;
            s++;
        }
        return ar;
    }

    public static int getNum() {
        Scanner s = new Scanner(System.in);
        String x = s.nextLine();
        int a=Integer.valueOf(x);
        return a;
    }

    public static void printDay(int x){
        switch (x){
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid data");
        }
    }


}
