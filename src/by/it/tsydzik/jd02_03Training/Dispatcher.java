package by.it.tsydzik.jd02_03Training;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Eugene Tsydzik
 * @since 11.10.16.
 */
public class Dispatcher {

    static ExecutorService poolCashier = Executors.newFixedThreadPool(5);

    //сколько планируется покупателей
    final static int PLAN_COUNT_BUYERS = 10;

    //общий счетчик покупателей
    static AtomicInteger countBuyers = new AtomicInteger(0);

    static boolean planComplete() {
        return countBuyers.get() >= PLAN_COUNT_BUYERS;
    }

    //метод определяющий конец обслуживания
    static boolean finish() {
        return countCompleteBuyers.get() >= PLAN_COUNT_BUYERS;
    }

    //общий счетчик обслуженных покупателей
    static AtomicInteger countCompleteBuyers = new AtomicInteger(0);

    //общий счетчик кассиров
    static int countCashiers = 0;


}
