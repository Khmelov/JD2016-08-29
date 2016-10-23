package by.it.laurynovich.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by nadabratb on 10/16/2016.
 */
public class Dispatcher {
    static ExecutorService poolCashiers= Executors.newFixedThreadPool(5);


    static public AtomicInteger countCashiers=new AtomicInteger(0);
    static AtomicInteger countBuyers=new AtomicInteger(0);
    static AtomicInteger countOutBuyers=new AtomicInteger(0);
    static final int PLAN_COUNT_BUYERS=100;

    static boolean isFinished(){
        return (countOutBuyers.get()>=PLAN_COUNT_BUYERS);
    }

    static boolean needCashiers(){
        boolean res=(countCashiers.get() * 5 < QueueBuyers.getSize());
        if (!res && countCashiers.get()==1)
            res=!Dispatcher.isFinished();
        if (countCashiers.get() >=5 && res)
            res=false;
        return res;
    }
}

