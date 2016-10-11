package by.it.ilyukhin.jd01_12;


import java.util.ArrayList;
import java.util.Set;

public class Runner {
    public static void main(String[] args){
        //Задание А1
        System.out.println("Список всех оценок: "+TaskA.listMarks());
        System.out.println("Список с положительными оценками: "+TaskA.goodMarks());
        //Задание A2
        Set<Integer> set1=TaskA.generateSet1(3);
        Set<Integer> set2=TaskA.generateSet2(4);
        System.out.println("Множество А: "+set1);
        System.out.println("Множество B: "+set2);
        System.out.println("Пересечение множеств А и В: "+MyCollect.getCross(set1,set2));
        System.out.println("Объединение множеств А и В: "+MyCollect.getUnion(set1,set2));
        ArrayList<Integer> list = TaskA.generateElements();
        System.out.println("Отсортированный список: "+ TaskA.sortElemetns(list));



    }
}
