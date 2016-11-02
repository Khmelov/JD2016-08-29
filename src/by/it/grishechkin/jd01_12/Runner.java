package by.it.grishechkin.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Yury on 20.10.2016.
 */
public class Runner {

    public static void main(String[] args) {
        List <Integer> marks = TaskA.markList();
        Util.printIntArr(marks);
        List <Integer> A = marks;
        List <Integer> B = TaskA.deleteNegativeMarks(marks, 4);
        Util.printIntArr(B);
        List<Integer> cross = MyCollet.getCross(A, B);
        List<Integer> union = MyCollet.getUnion(A, B);
        System.out.println("Cross:");
        Util.printIntArr(cross);
        System.out.println("Union:");
        Util.printIntArr(union);
        System.out.println("Add negative numbers:");
        List <Integer> negativNumbers = new ArrayList<>(TaskA.addNegativeNumbers(union));
        Util.printIntArr(negativNumbers);
        Util.printIntArr(TaskA.swap(negativNumbers));
        Map <String, Integer> repeat = TaskB.repeat(TaskB.splitting());
        Util.printIntMap(repeat);
        TaskB.processArray(10000);
        TaskB.processLinked(10000);
        // На N = 10 000 быстрее работает LinkedList (при значении в 1 000 то один работал быстрее, то второй).
        // По идее аррэй лист должен был сработать лучно но это было бы так если бы я не использовал итератор.
        // При использовании итерратора линкедлист все таки опережает аррэй лист.
        // А вообще, аррэй лист работает медленнее, если приходится удалять элемент из начала т.к. он потом сдвигает все элементы
        // на одну позицию влево, а линкед лист просто меняет указатели.

    }
}
