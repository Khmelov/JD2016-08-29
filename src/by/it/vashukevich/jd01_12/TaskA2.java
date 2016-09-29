package by.it.vashukevich.jd01_12;

import java.util.*;

/**
 * Created by Admin on 26.09.16.
 */
public class TaskA2 {
    public static void main(String[] args) {
        Set<Integer> ar = new HashSet<>();
        Set<Integer> br = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            int a = (int) Math.round(Math.random() * 10);
            int b = (int) Math.round(Math.random() * 10);
            ar.add(a);
            br.add(b);
        }
        System.out.println("Первое множество "+ar);
        System.out.println("Второе множество "+br);
        MyCollect.getCross(ar,br);
        MyCollect.getUniuon(ar,br);
    }
}
