package by.it.emelyanov.jd01_12;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Util {

     static <T> void print(String description, Collection<T> data){
        System.out.println(description);
        for (T i: data){
            System.out.printf("%3d ", i);
        }
        System.out.println();
    }

     static void print(String description, HashMap<String,Integer> data){
        System.out.println(description);
        for (Map.Entry<String,Integer> i: data.entrySet()){
            System.out.println(i.getKey() + "    " + i.getValue() + " раз(а)");
        }
        System.out.println();
    }
}
