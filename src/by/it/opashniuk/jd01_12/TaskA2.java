package by.it.opashniuk.jd01_12;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class TaskA2 {
    public static void main(String[] args) {
        Set<Integer> arrayA=new HashSet<>();
        Set<Integer> arrayB=new HashSet<>();
        Random myRandom = new Random();
        for (int i = 0; i < 20; i++) {
            arrayA.add(myRandom.nextInt(100));
            arrayB.add(myRandom.nextInt(100));
        }
        System.out.println("Множество A: "+arrayA);
        System.out.println("Множество B: "+arrayB);

        MyCollect.getCross(arrayA,arrayB);
        MyCollect.getUniuon(arrayA,arrayB);
    }
}
