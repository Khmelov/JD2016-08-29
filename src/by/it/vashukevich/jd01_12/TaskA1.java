package by.it.vashukevich.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Admin on 26.09.16.
 */
public class TaskA1 {
    public static void main(String[] args) {
        ArrayList<Integer> marks = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            int d = (int)Math.round(Math.random()*10);
            marks.add(d);
        }

        //список всех оценок
        System.out.print("Список оценок : ");
        for(int a:marks){
            System.out.printf("%2d%c",a,',');
        }
        System.out.println();
        //список положительных оценок
        System.out.print("Список положительных оценок : ");

        Iterator<Integer>minus=marks.iterator();
        while (minus.hasNext()) {
            if (minus.next() < 4)
                minus.remove();
        }
        for(int a:marks){
            System.out.printf("%2d%c",a,',');
        }
    }
}
