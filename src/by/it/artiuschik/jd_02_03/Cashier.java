package by.it.artiuschik.jd_02_03;

import java.util.Map;

class Cashier implements Runnable {
    private int number;

    Cashier() {
        synchronized (Dispatcher.monitorCountCashiers) {
            number = Dispatcher.numberOfCashier.incrementAndGet();
            Dispatcher.countCashiers.incrementAndGet();
            System.out.println("////////Открылась касса №" + number + "////////");
        }
    }

    public void run() {

        while (QueueBuyers.needService()) {
            synchronized (Dispatcher.monitorForSystemOut) {
                Buyer b = QueueBuyers.extract();
                OutputStrings.printInterval((this.number - 1) * 35);
                System.out.println(this + " start service " + b);
                Helper.sleep(Helper.rnd(2000, 5000));
                OutputStrings.printInterval((this.number - 1) * 35);
                System.out.println("Billing ... " + b);
                for (Map.Entry<String, Double> good : b.getGoods().entrySet()) {
                    OutputStrings.printInterval((this.number - 1) * 35);
                    System.out.println(good.getKey() + " " + good.getValue());
                    Dispatcher.allCash.addAndGet(good.getValue().intValue());
                }
                OutputStrings.printInterval((this.number - 1) * 35);
                System.out.print("Stop service ");
                OutputStrings.printInterval((-35 * (this.number - 1)) + 35 + 150);
                System.out.println((QueueBuyers.getBuyers().size() + QueueBuyers.getPensioneers().size()) + "            " + Dispatcher.allCash);
                synchronized (b) {
                    b.notify();//покупатель ушел
                }
                if (!QueueBuyers.needService() && (Dispatcher.numberOfCashier.get() == 5) && (Dispatcher.countOutBuyers.get() < Dispatcher.PLAN_COUNT_BUYERS - 1)) {
                    Dispatcher.flag.set(true);
                    synchronized (Dispatcher.monitorWaitingBuyer) {
                        try {
                            /*если остался последний кассир, а план не выполнен,
                            то он обслуживает всех, кто будет добавляться в очередь,
                             пока не будет выполнен план*/
                            Dispatcher.monitorWaitingBuyer.wait();
                            Dispatcher.flag.set(false);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }
        synchronized (Dispatcher.monitorCountCashiers) {
            System.out.println(this + " stop");
            Dispatcher.countCashiers.decrementAndGet();
        }

    }

    @Override
    public String toString() {
        return "Касса №" + number;
    }
}
