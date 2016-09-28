package by.it.senchenko.jd01_12;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;



public class TaskA2 {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        HashSet<Integer> hashSet2 = new HashSet<>();
        HashSet<Integer> hashSet3 = new HashSet<>();
        Random myRandom = new Random();

        while (hashSet.size()<10){
            hashSet.add(myRandom.nextInt(20));
            hashSet2.add(myRandom.nextInt(20));
        }

        System.out.println("Множество А: "+hashSet);
        System.out.println("Множество В: "+hashSet2);

        Iterator<Integer> iterator = hashSet2.iterator();

        while (iterator.hasNext() && iterator.hasNext()){
            Integer i2=iterator.next();
            if (hashSet.contains(i2)){
                hashSet3.add(i2);
            }
        }
        System.out.println("Пересечение множеств А и В: "+hashSet3);
    }
}
