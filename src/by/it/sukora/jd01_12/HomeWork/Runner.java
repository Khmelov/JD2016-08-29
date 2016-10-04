package by.it.sukora.jd01_12.HomeWork;

import java.util.ArrayList;

public class Runner {

    public static void main(String[] args) {
        //TaskA1
        System.out.println("TaskA");
        System.out.println();
        System.out.println("Список оценок учеников.");
        ArrayList<ArrayList> result = TaskA.listArray(20);
        System.out.println("Первоначальный список: " + result.get(0));
        System.out.println("Список положительных оценок: " + result.get(1));
        //TaskA2
        MyCollect A = new MyCollect(11, 23, 5, 4, 6, 74, 8, 7, 15);
        MyCollect B = new MyCollect(9, 4, 5, 6, 3, 1, 7, 5, 2, 6, 5, 4);
        MyCollect cross = MyCollect.getCross(A, B);
        MyCollect union = MyCollect.getUnion(A, B);
        System.out.println("A=" + A);
        System.out.println("B=" + B);
        System.out.println("Cross=" + cross);
        System.out.println("Union=" + union);
        //TaskA3
        result = TaskA.moveNegativeToEnd(20);
        System.out.println("Первоначальный список: " + result.get(0));
        System.out.println("Полученный список: " + result.get(1));
        //TaskB1
        TaskB.worde(Txt.TEXT);
        //TaskB2
        long start = System.nanoTime();
        TaskB.processArray(5);
        long end = System.nanoTime();
        System.out.println("ArrayList time=" + (end - start));
        start = System.nanoTime();
        TaskB.processLinked(5);
        end = System.nanoTime();
        System.out.println("LinkedList time=" + (end - start));
        System.out.println("Быстрее ArrayList");
        //TaskC1
        System.out.println("TaskC1");
        System.out.println(TaskC.buildList(Txt.OBJECT_NAMES));
        System.out.println(TaskC.deleteEqual(TaskC.buildList(Txt.OBJECT_NAMES)));
        //TaskC2
        System.out.println("TaskC2");
        MyGeneralCollect<Character> collect1=new MyGeneralCollect<>('q','r','u','c','a');
        MyGeneralCollect<Character> collect2=new MyGeneralCollect<>('a','b','c','d');
        System.out.println("A="+collect1);
        System.out.println("B="+collect2);
        MyGeneralCollect genCross=MyGeneralCollect.getCross(collect1,collect2);
        MyGeneralCollect genUnion=MyGeneralCollect.getUnion(collect1,collect2);
        System.out.println("cross="+genCross);
        System.out.println("union="+genUnion);
        //TaskC3
        System.out.println("TaskC3");
        String expr="(4*9)+)+(1))";
        System.out.println(expr+" "+TaskC.isBracketsCorrect(expr));
        expr="(6+1)+(19+6)";
        System.out.println(expr+" "+TaskC.isBracketsCorrect(expr));
    }


}
