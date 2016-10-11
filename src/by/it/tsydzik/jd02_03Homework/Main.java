package by.it.tsydzik.jd02_03Homework;

/**
 * @author Eugene Tsydzik
 * @since 11.10.16.
 */
public class Main {
    public static void main(String[] args) {

        Dispatcher.poolCashiers.execute(new Cashier());
        Dispatcher.poolCashiers.execute(new Cashier());
        Dispatcher.poolCashiers.execute(new Cashier());
        Dispatcher.poolCashiers.execute(new Cashier());
        Dispatcher.poolCashiers.execute(new Cashier());

        long t1 = System.currentTimeMillis();
        // прошло секкунд в минуте
        double t = 0;

        while (!Dispatcher.isPlanCompleted()) {
            Helper.sleep(1000);
            int max = 0;
            int buyersInside = Dispatcher.countBuyers.get() - Dispatcher.countCompleteBuyers.get();
            if (Math.round(t) % 60 < 30) {
                max = 2;
            } else if (buyersInside <= 40 + (30 - t)) {
                max = 2;
            }

            for (int i = 0; i <= Helper.rnd(max); i++) {
                Buyer buyer = new Buyer(Dispatcher.countBuyers.incrementAndGet());
                Thread th = new Thread(buyer);
                th.start();
                if (Dispatcher.isPlanCompleted())
                    break;
            }
            Helper.sleep(1000);
            if (t > 60) {
                t1 = System.currentTimeMillis();
            }
            t = (System.currentTimeMillis() - t1) / 1000;
        }
        //завершениe сервиса касс (нельзя будет добавить новые)
        //однако сами кассы продолжают работу, т.к. они уже выполняются
        Dispatcher.poolCashiers.shutdown();
    }

}
