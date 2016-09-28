package by.it.tsiamruk.jd01_12.TaskA;

import java.util.HashSet;

/**
 * Created by waldemar on 28/09/2016.
 */
public class TaskA2 {
    public static HashSet<Integer> statementA() {
        HashSet<Integer> statement = new HashSet<Integer>();

        for (int i = 0; i < 20; i++) {
            statement.add((int) (Math.random() * 100 + 1));
        }
        System.out.println("Множество А: " + statement.toString());
        return statement;
    }

    public static HashSet<Integer> statementB() {
        HashSet<Integer> stateB = new HashSet<Integer>();

        for (int i = 0; i < 20; i++) {
            stateB.add((int) (Math.random() * 100 + 1));
        }
        System.out.println("Множество Б:" + stateB.toString());
        return stateB;
    }


}
