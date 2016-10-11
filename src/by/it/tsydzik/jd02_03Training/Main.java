package by.it.tsydzik.jd02_03Training;

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

        while (!Dispatcher.isPlanCompleted()) {
            Helper.sleep(1000);
            int count= Helper.rnd(0, 2);    // то количество покупателей,
                                            // которое может пройти: 0 1 2
            for (int i = 0; i <= count; i++) {
                Buyer buyer = new Buyer(Dispatcher.countBuyers.incrementAndGet());
                Thread th = new Thread(buyer);
                th.start();
                if (Dispatcher.isPlanCompleted())
                    break;
            }
        }
        //завершениe сервиса касс (нельзя будет добавить новые)
        //однако сами кассы продолжают работу, т.к. они уже выполняются
        Dispatcher.poolCashiers.shutdown();
    }

}
