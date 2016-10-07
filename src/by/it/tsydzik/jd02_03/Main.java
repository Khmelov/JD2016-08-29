package by.it.tsydzik.jd02_03;

/**
 * @author Eugene Tsydzik
 * @since 10/03/16.
 */
public class Main {
    public static void main(String[] args) {
        int countBuyer = 0;
        while (countBuyer < 20) {
            int n = Helper.rnd(10);
            for (int i = 0; i < n; i++) {
                Buyer buyer = new Buyer(++countBuyer);
                Thread th = new Thread(buyer);
                th.start();
                if (countBuyer == 20) {
                    break;
                }
            }
            Helper.sleep(1000);
        }
    }
}
