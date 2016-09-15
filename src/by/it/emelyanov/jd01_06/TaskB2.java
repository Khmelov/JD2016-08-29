package by.it.emelyanov.jd01_06;

import java.util.Arrays;

public class TaskB2 {

    public static void Comp() {
        StringBuilder text = new StringBuilder(Data.getString());
        String s[] = text.toString().trim().split("[.!?]+\\s*");//sentence
       //for comp.
        int arr[] = new int[s.length];
        int k[] = new int[s.length];
        //summ
        for (int i = 0; i <= s.length-1; i++) {
            int t = 0;
            String w[] = s[i].toString().trim().split(" ");
            for (int j = 0; j <= w.length-1; j++) {
                t++;
            }
            arr[i] = t;
            k[i] = t;
        }
        //sort and repl
        Arrays.sort(arr);
        for (int i = 0; i <= arr.length - 1; i++) {
            for (int j = 0; j <= arr.length - 1; j++) {
                if (arr[i] == k[j]) {
                    System.out.println(k[j]);
                    System.out.println(s[j].replaceAll("\n", " "));
                }
            }
        }
    }
}