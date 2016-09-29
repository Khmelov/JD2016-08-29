package by.it.emelyanov.jd01_12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {

        /**
         * A1. Создать список оценок учеников с помощью ArrayList, заполнить случайными оценками. Удалить
         неудовлетворительные оценки из списка. Вывести на консоль оба варианта.
         */
        System.out.println("A1");
        ArrayList<Integer> allMarks = TaskA.generateMarks(47);
        Util.print("Список всех оценок ", allMarks);
        ArrayList<Integer> goodMarks = TaskA.deleteMarks(allMarks);
        Util.print("Список положительных оценок ", goodMarks);
        /**
         * A2. Определить два множества (A и B) на основе целых чисел. Создать отдельный класс MyCollect и
         статические методы в нем для определения пересечения множеств getCross и объединения множеств
         getUnion. Показать работу этих методов на примере двух множеств (A и B).
         */
        System.out.println("\nA2");
        Set<Integer> set1 = TaskA.generateSet(15, 0);
        Util.print("Множество A ", set1);
        Set<Integer> set2 = TaskA.generateSet(12, 7);
        Util.print("Множество B ", set2);
        Util.print("Пересечение А и В ", MyCollect.getCross(set1, set2));
        Util.print("Объединение А и В ", MyCollect.getUnion(set1, set2));
        /**
         * A3. Не используя вспомогательных объектов (т.е. без обмена местами переменных), переставить
         отрицательные элементы произвольного списка чисел в конец, а положительные — в начало списка.
         */
        System.out.println("\nA3");
        ArrayList<Integer> list = TaskA.generateElements(47);
        Util.print("Отсортированный список", TaskA.sortElemetns(list));
        /**
         *B1. Задать текст на английском языке (100 и более слов). Вывести все различные слова. Для каждого слова
         подсчитать частоту его встречаемости. Слова, отличающиеся регистром букв, считать различными.
         Использовать класс HashMap.
         */
        System.out.println("\nB1");
        HashMap<String, Integer> words = TaskB.createHM();
        Util.print("Все различные слова и кол-во их повторений", words);
        /**
         * B2. В кругу стоят N человек, пронумерованных от 1 до N. При ведении счета по кругу вычеркивается каждый
         второй человек, пока не останется один. Составить два метода processArray и prоcessLinked
         моделирующие процесс. Первый должен использовать класс ArrayList, а второй — LinkedList. Какой из
         двух методов работает быстрее? Почему? Докажите. (см. пример на слайдах).
         */
        System.out.println("\nB2");
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("Холодный запуск.");
        System.out.println(TaskB.processArray(47));
        System.out.println("\nЗапуск на разогретой JVM.");
        System.out.println(TaskB.processArray(47));
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("Холодный запуск.");
        System.out.println(TaskB.processLinked(47));
        System.out.println("\nЗапуск на разогретой JVM.");
        System.out.println(TaskB.processLinked(47));

    }

}
