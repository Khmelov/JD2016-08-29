package by.it.artiuschik.jd_02_03;

class Runner {
    public static void main(String[] args) {
        Helper.enterBuyers();
        while (!Dispatcher.isFinished())
            Helper.sleep(100);
        Dispatcher.poolCashiers.shutdown();
    }
}

