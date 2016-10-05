package by.it.rudzko.jd01_12;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Leta on 25.09.2016.
 */
public class MyCollect {

    public static ArrayList <Integer> getCross(HashSet <Integer> a, HashSet <Integer> b){
        ArrayList <Integer> list=new ArrayList <Integer>();
        Integer [] arr=new Integer[a.size()];
        a.toArray(arr);
        for(int i=0; i<arr.length; i++){
            if (b.contains(arr[i])){
                list.add(arr[i]);
            }
        }

        return list;
    }

    public  static HashSet <Integer> getUnion (HashSet <Integer> a, HashSet <Integer> b){
        a.addAll(b);
        return a;
    }
}