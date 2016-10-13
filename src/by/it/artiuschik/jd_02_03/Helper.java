package by.it.artiuschik.jd_02_03;

public class Helper {
    protected static int rnd(int from, int to) {
        return from + (int) (Math.round(Math.random() * (to - from)));
    }

    protected static int rnd(int max) {
        return rnd(0, max);
    }

    protected static void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void enterBuyers() {
        int сountBuyers = 0;
        int counter = 3;
        boolean addPensioneer = false;
        while (сountBuyers < Dispatcher.PLAN_COUNT_BUYERS) {
            for (int i = 1; i < 31; i++) {
                if (сountBuyers >= counter) {
                    addPensioneer = true;
                }
                int n = Helper.rnd(2);
                if (Dispatcher.countBuyers.get() < 10 + i) {
                    for (int j = 0; j < n; j++) {
                        Buyer buyer = new Buyer(++сountBuyers);
                        if (addPensioneer) {
                            buyer.setPensioneer(true);
                            addPensioneer = false;
                            counter += 4;
                        }
                        new Thread(buyer).start();
                        if (сountBuyers == Dispatcher.PLAN_COUNT_BUYERS)
                            return;
                    }
                }
                try {
                    Thread.sleep(1000);//через 1 секунду
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            for (int i = 31; i <= 60; i++) {
                if (сountBuyers >= counter) {
                    addPensioneer = true;
                }
                int n = Helper.rnd(2);
                if (Dispatcher.countBuyers.get() <= 40 + 30 - i) {
                    for (int j = 0; j < n; j++) {
                        Buyer buyer = new Buyer(++сountBuyers);
                        if (addPensioneer) {
                            buyer.setPensioneer(true);
                            addPensioneer = false;
                            counter += 4;
                        }
                        new Thread(buyer).start();
                        if (сountBuyers == Dispatcher.PLAN_COUNT_BUYERS)
                            return;
                    }
                }

            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

