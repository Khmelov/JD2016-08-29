package by.it.artiuschik.jd_02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher {
    static ExecutorService poolCashiers= Executors.newFixedThreadPool(5);
    static AtomicInteger countBuyers=new AtomicInteger(0);//количество покупателей в магазине
    static AtomicInteger countCashiers=new AtomicInteger(0);//количество кассиров в магазине
    static AtomicInteger countOutBuyers=new AtomicInteger(0);//количество обслуженных покупателей
    static AtomicInteger numberOfBuyer=new AtomicInteger(0);//номер покупателя
    static AtomicInteger numberOfCashier=new AtomicInteger(0);//номер кассира
    static AtomicInteger allCash=new AtomicInteger(0);//выручка магазина
    static AtomicBoolean flag=new AtomicBoolean(false);
    static final int PLAN_COUNT_BUYERS=30;
    final static Integer monitorCountCashiers=0;
    final static Integer monitorForSystemOut=0;
    final static Integer monitorWaitingBuyer =0;
    static boolean isFinished(){
        return (countOutBuyers.get()>=PLAN_COUNT_BUYERS);
    }//выполнен ли план?

}

