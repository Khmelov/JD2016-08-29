package by.it.vashukevich.jd01_12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by Admin on 28.09.16.
 */
public class TaskA3 {
    public static void main(String[] args) {
        ArrayList<Integer> revers=new ArrayList<>();
        for(int i=0;i<20;i++){
            int a=(-10)+(int)Math.round(Math.random()*(10-(-10)+1));
            revers.add(a);
        }
        System.out.println("Список случайных чисел"+revers);
        Collections.sort(revers);
        Collections.reverse(revers);
        System.out.println("Переставленный список"+revers);
    }
}
