package by.it.tsydzik.jd02_03Homework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Eugene Tsydzik
 * @since 11.10.16.
 */
public class Dispatcher {

    static ExecutorService poolCashiers = Executors.newFixedThreadPool(5);

    //сколько планируется покупателей
    final static int PLAN_COUNT_BUYERS = 100;

    //общий счетчик кассиров
    static AtomicInteger countCashiers = new AtomicInteger(0);

    //общий счетчик покупателей
    static AtomicInteger countBuyers = new AtomicInteger(0);

    //общий счетчик обслуженных покупателей
    static AtomicInteger countCompleteBuyers = new AtomicInteger(0);


    static boolean isPlanCompleted() {
        return countBuyers.get() >= PLAN_COUNT_BUYERS;
    }

    //метод определяющий конец обслуживания
    static boolean finish() {
        return countCompleteBuyers.get() >= PLAN_COUNT_BUYERS;
    }

    static boolean needCashiers() {
        if (!Dispatcher.isPlanCompleted()) {
            if (countCashiers.get() < 5 && (countCashiers.get() * 5 < QueueBuyers.getSize())) {
                return true;
            }
        } else if (countCashiers.get() < 5
                && Dispatcher.countBuyers.get() != Dispatcher.countCompleteBuyers.get()
                && QueueBuyers.needService()) {
            // То есть мы будем нуждаться в кассиры даже когда план будет завершена,
            // если у нас есть покупатели внутри
            return true;
        }
        return false;
    }


}
