package by.it.tsiamruk.jd01_12;

import by.it.tsiamruk.jd01_12.TaskA.MyCollect;
import by.it.tsiamruk.jd01_12.TaskA.TaskA1;
import by.it.tsiamruk.jd01_12.TaskA.TaskA2;
import by.it.tsiamruk.jd01_12.TaskA.TaskA3;
import by.it.tsiamruk.jd01_12.TaskA.TaskB.TaskB1;

import java.util.ArrayList;

/**
 * Created by waldemar on 28/09/2016.
 */
public class Runner {
    public static void main(String[] args) {
        System.out.println("<<Task A1>>");
        TaskA1.firstTask();
        System.out.println("<<Task A2>>");
        MyCollect.getCross(TaskA2.statementA(), TaskA2.statementB());
        MyCollect.getUnion(TaskA2.statementA(), TaskA2.statementB());
        System.out.println("<<Task A3>>");
        //создам колллекцию которая будет хранить в себе как положительные так и отрицательные числа
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 15; i++) {
            if (i < 7) {
                list.add((int) (Math.random() * 9 + 1));
            } else {
                list.add((int) (Math.random() * -7 - 1));
            }
        }
        System.out.println("Длинна списка чисел " + list.size());
        System.out.println("Список чисел " + list.toString());
        TaskA3.sortSet(list);
        System.out.println("<<Task B1>>");
        TaskB1.createHM();

    }
}
