package by.it.tsiamruk.jd02_01;

/**
 * Created by waldemar on 03/10/2016.
 */
public class Main {
    public static void main(String[] args) {
        int countBuyer = 0;
        while (countBuyer < 20) {
            int n = Helper.rnd(2);
            for (int i = 0; i < n; i++) {
                Buyer buyer = new Buyer(++countBuyer);
                buyer.start();
                if (countBuyer == 20)
                    try {
                        buyer.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
            Helper.sleep(1000);
        }
    }
}
