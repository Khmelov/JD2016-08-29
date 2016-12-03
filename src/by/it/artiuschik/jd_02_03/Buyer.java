package by.it.artiuschik.jd_02_03;

import java.util.HashMap;
import java.util.Map;

class Buyer implements Runnable, IBuyer, IBucket {
    private int number;//номер покупателя
    private String name;//имя
    private boolean isPensioneer = false;

    void setPensioneer(boolean pensioneer) {
        isPensioneer = pensioneer;
    }

    private Map<String, Double> goods = new HashMap<>();//покупки

    String getName() {
        return name;
    }

    Map<String, Double> getGoods() {
        return goods;
    }

    void setName(String name) {
        this.name = name;
    }


    Buyer(int num) {
        this.number = num;
        this.isPensioneer = false;
        this.setName("Buyer №" + number);
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToQueue();
        goToOut();
    }

    boolean isPensioneer() {
        return isPensioneer;
    }

    @Override
    public void enterToMarket() {
        Dispatcher.countBuyers.incrementAndGet();
    }

    @Override
    public void goToQueue() {
        synchronized (QueueBuyers.monitorQueueBuyers) {
            QueueBuyers.add(this);
            if (Dispatcher.flag.get()) {
                synchronized (Dispatcher.monitorWaitingBuyer) {
                    Dispatcher.monitorWaitingBuyer.notify();/*обслуживание пассажира,
                                                            добавившегося в очередь*/
                }
            }
        }
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void chooseGoods() {
        for (int i = 1; i < Helper.rnd(1, 4); i++) {
            Helper.sleep(Helper.rnd(500, 2000));
            String goodName = Goods.random();
            goods.put(goodName, Goods.getTable().get(goodName));
            putGoodsToBucket();
        }
    }

    @Override
    public void putGoodsToBucket() {
        Helper.sleep(Helper.rnd(100, 200));
    }

    @Override
    public void goToOut() {
        Dispatcher.countBuyers.decrementAndGet();
        Dispatcher.countOutBuyers.incrementAndGet();
    }

    @Override
    public String toString() {
        if (!isPensioneer) {
            return "Buyer №" + number;
        } else
            return "pensioneer";
    }


}