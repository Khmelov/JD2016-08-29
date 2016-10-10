package by.it.tsydzik.jd02_03Training;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Eugene Tsydzik
 * @since 11.10.16.
 */
public class Dispatcher {
    //сколько планируется покупателей
    private static final int planCount = 5;

    //общий счетчик покупателей
    static int countBuyers = 0;

    static boolean planComplete() {
        return countBuyers >= planCount;
    }

    //общий счетчик обслуженных покупателей
    static int countCompleteBuyers = 0;

    //метод определяющий конец обслуживания
    static boolean finish() {
        return countCompleteBuyers >= planCount;
    }

    //обий счетчик обслуженных покупателей
    static AtomicInteger acountCompleteBuyers = new AtomicInteger(0);

    //общий счетчик кассиров
    static int countCashiers = 0;


}
