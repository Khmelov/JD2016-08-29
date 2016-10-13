package by.it.emelyanov.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher {

    private static final int planCount = 40;

    static int countBuyers = 0;

    static boolean planComplete() {   //метод определяющий выполнение плана
        return countBuyers >= planCount;
    }

    static int countCompleteBuyers = 0;

    static boolean finish() {
        return countCompleteBuyers >= planCount;
    }

    static AtomicInteger acountCompleteBuyers = new AtomicInteger(0);

    static int countCashiers = 0;


}
