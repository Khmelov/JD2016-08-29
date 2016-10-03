package by.it.tsydzik.jd02_01;

/**
 * @author Eugene Tsydzik
 * @since 10/03/16.
 */
public class Main {
    public static void main(String[] args) {
        int countBuyer = 0;
        while (countBuyer < 20) {
            int n = Helper.rnd(2);
            for (int i = 0; i < n; i++) {
                Buyer buyer = new Buyer(++countBuyer);
                buyer.start();
                if (countBuyer == 20) {
                    try {
                        buyer.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            Helper.sleep(1000);
        }
    }
}
