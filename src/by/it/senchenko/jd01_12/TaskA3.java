package by.it.senchenko.jd01_12;


import java.util.*;

public class TaskA3 {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        Random myRandom = new Random();
        while (hashSet.size()<10){
            hashSet.add(myRandom.nextInt(21)-10);
        }
        System.out.println(hashSet);
        TreeSet<Integer> treeSet = new TreeSet<>(hashSet);
        System.out.println(treeSet);
        NavigableSet<Integer> set = treeSet.descendingSet();
        System.out.println(set);
    }
}
