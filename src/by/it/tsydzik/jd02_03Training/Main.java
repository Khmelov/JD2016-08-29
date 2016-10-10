package by.it.tsydzik.jd02_03Training;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Eugene Tsydzik
 * @since 11.10.16.
 */
public class Main {
    public static void main(String[] args) {
        ExecutorService executor= Executors.newFixedThreadPool(5);
executor.execute(new Buyer());
    }

}
