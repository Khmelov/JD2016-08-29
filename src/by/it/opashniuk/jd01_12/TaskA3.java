package by.it.opashniuk.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TaskA3 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList=new ArrayList<Integer>(Arrays.asList(-2, 4, 15, -11, 0, 7, -5, 10, 32, -17, 1));
        Collections.sort(arrayList);
        Collections.reverse(arrayList);
        System.out.println(arrayList);
    }
}
