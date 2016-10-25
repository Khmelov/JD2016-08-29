package by.it.grishechkin.jd01_15;

import java.util.List;

/**
 * Created by Yury on 24.10.2016.
 */
public class Runner {
    public static void main(String[] args) {

        List<Integer> list = TaskA.generateNumbers();
        TaskA.writeMatrix(list);

        StringBuilder text = TaskB.read();
        TaskB.delite(text);
    }
}
