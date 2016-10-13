package by.it.artiuschik.jd_01_12;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args)
    {
       //TaskA1
        ArrayList<ArrayList> result= TaskA1.marksArray(20);
        System.out.println("Первоначальный список: "+result.get(0));
        System.out.println("Список без неудовлетворительных оценок: "+result.get(1));
        //TaskA2
        MyCollect A=new MyCollect(1,2,3,4,5,6,7,8,9);
        MyCollect B=new MyCollect(2,3,4,5,6);
        MyCollect cross=MyCollect.getCross(A,B);
        MyCollect union=MyCollect.getUnion(A,B);
        System.out.println("A="+A);
        System.out.println("B="+B);
        System.out.println("Cross="+cross);
        System.out.println("Union="+union);
        //TaskA3
        result= TaskA3.moveNegativeToEnd(20);
        System.out.println("Первоначальный список: "+result.get(0));
        System.out.println("Полученный список: "+result.get(1));
        //TaskB1
        TaskB1.wordFrequency(by.it.artiuschik.jd_01_12.Data.TEXT);
        //TaskB2
        long start=System.nanoTime();
        TaskB2.processArray(5);
        long end=System.nanoTime();
        System.out.println("ArrayList time="+(end-start));
        start=System.nanoTime();
        TaskB2.processLinked(5);
        end=System.nanoTime();
        System.out.println("LinkedList time="+(end-start));
        //TaskC1
        System.out.println(TaskC1.buildList(by.it.artiuschik.jd_01_12.Data.OBJECT_NAMES));
        System.out.println(TaskC1.deleteEqual(TaskC1.buildList(Data.OBJECT_NAMES)));
        //TaskC2
        MyGeneralCollect<Character> collect1=new MyGeneralCollect<>('q','r','u','c','a');
        MyGeneralCollect<Character> collect2=new MyGeneralCollect<>('a','b','c','d');
        System.out.println("A="+collect1);
        System.out.println("B="+collect2);
        MyGeneralCollect genCross=MyGeneralCollect.getCross(collect1,collect2);
        MyGeneralCollect genUnion=MyGeneralCollect.getUnion(collect1,collect2);
        System.out.println("cross="+genCross);
        System.out.println("union="+genUnion);
        //TaskC3
        String expr="(8+9)+)+(8))";
        System.out.println(expr+" "+TaskC3.isBracketsCorrect(expr));
        expr="(2+3)+(6+7)";
        System.out.println(expr+" "+TaskC3.isBracketsCorrect(expr));


    }
}
