package by.it.laurynovich.jd01_12;

import java.util.*;

/**
 * Created by nadabratb on 09.10.2016.
 */
public class TaskA12 {

    /*A1. Создать список оценок учеников с помощью ArrayList, заполнить случайными оценками.
     *Удалить неудовлетворительные оценки из списка.
     * Вывести на консоль оба варианта.*/
    protected static void A1() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < (int) (Math.random() * 200 + 5); i++) {
            arrayList.add(i, (int) (Math.random() * 11));
        }
        System.out.println(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) < 4) {
                arrayList.remove(i);
                i--;
            }
        }
        System.out.println(arrayList);

    }

    /*A2. Определить два множества (A и B) на основе целых чисел.
     *Создать отдельный класс MyCollect и статические методы в нем для определения
     * пересечения множеств getCross и объединения множеств getUnion.
     * Показать работу этих методов на примере двух множеств (A и B).*/
    protected HashSet<Integer> A2() {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < (int) (Math.random() * 200 + 5); i++) {
            Integer elem = new Integer((int) (Math.random() * 20 + 5));
            //System.out.println(elem);
            hashSet.add(elem);

        }
        System.out.println(hashSet);
        return hashSet;
    }

    /*A3. Не используя вспомогательных объектов (т.е. без обмена местами переменных), переставить
            отрицательные элементы произвольного списка чисел в конец, а положительные — в начало списка.*/
    protected static void A3() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < (int) (Math.random() * 200 + 5); i++) {
            arrayList.add(i, (int) (Math.random() * 20 - 11));
        }
        System.out.println(arrayList);
        Collections.sort(arrayList);
        Collections.reverse(arrayList);
        System.out.println(arrayList);
    }

}
