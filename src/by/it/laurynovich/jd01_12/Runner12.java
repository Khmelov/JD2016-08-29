package by.it.laurynovich.jd01_12;

import by.it.emelyanov.jd01_12.TaskA;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by nadabratb on 09.10.2016.
 */
public class Runner12 {

    public static void main(String[] args) {
        System.out.println("Task A1");
        TaskA12.A1();

        System.out.println("Task A2");
        Set<Integer> a = new TaskA12().A2();
        Set<Integer> b = new TaskA12().A2();
        System.out.println( "cross" +MyCollect.getCross(a , b));
        System.out.println( "union" +MyCollect.getUnion(a , b));

        System.out.println("Task A3");
        TaskA12.A3();
    }

}
