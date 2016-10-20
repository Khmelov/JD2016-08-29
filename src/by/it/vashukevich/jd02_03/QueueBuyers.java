package by.it.vashukevich.jd02_03;

import java.util.ArrayDeque;

 class QueueBuyers {
    static final Integer monitorQueueBuyer=0;
    private static ArrayDeque<Buyer>queue=new ArrayDeque<>();

    public static int getSize(){
        int res;
        synchronized (monitorQueueBuyer){
           res=queue.size();
        }
        return res;
    }

    public static void add(Buyer b) {
        queue.addLast(b);
        if(Dispatcher.needCashiers()){
            new Thread(new Cashier()).start();
            //Dispatcher.pooLCashiers.execute(new Cashier());
            }
        }

    static Buyer extract(){
        Buyer b;
        synchronized (monitorQueueBuyer){
            b=queue.pollFirst();
        }
        return b;
    }
    static boolean needService(){
        boolean needService;
        synchronized (monitorQueueBuyer){
            needService=(queue.size()>0);
        }
        return needService;
    }


}

