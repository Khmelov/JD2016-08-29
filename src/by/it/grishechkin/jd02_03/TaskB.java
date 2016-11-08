package by.it.grishechkin.jd02_03;

/**
 * Created by Yury on 06.11.2016.
 */
public class TaskB {

    public static void sleep (int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
