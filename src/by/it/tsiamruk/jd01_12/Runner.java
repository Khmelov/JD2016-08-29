package by.it.tsiamruk.jd01_12;

import by.it.tsiamruk.jd01_12.TaskA.MyCollect;
import by.it.tsiamruk.jd01_12.TaskA.TaskA1;
import by.it.tsiamruk.jd01_12.TaskA.TaskA2;
import by.it.tsiamruk.jd01_12.TaskA.TaskA3;
import by.it.tsiamruk.jd01_12.TaskB.TaskB1;
import by.it.tsiamruk.jd01_12.TaskB.TaskB2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
        System.out.println("<<Task B2>>");
        List<String> b2ArrayList = new ArrayList<String>(TaskB2.processArray(TaskB2.getArrayPeoples(), 0));
        System.out.println("processArray result:" + b2ArrayList);
        List<String> b2LinkedList = new LinkedList<String>(TaskB2.processLinked(TaskB2.getLinkedPeoples(), 0));
        System.out.println("processLinked result:" + b2LinkedList);



    }
}
