package by.it.tsiamruk.jd02_01;

/**
 * Created by waldemar on 03/10/2016.
 */
public class Main {
    public static void main(String[] args) {
        int countBuyer = 0;
        double time = System.nanoTime();
        if (time < 30 * 1e9) {
            while (countBuyer < 10) {
                int n = Helper.rnd(2);
                for (int i = 0; i < n; ++i) {
                    Buyer buyer = new Buyer(++countBuyer);
                    if (countBuyer % 4 == 0)
                        buyer.setPensioner(true);
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
        } else if (time > 30 * 1e9) {
            while (countBuyer < 40) {
                int n = Helper.rnd(2);
                for (int i = 0; i < n; ++i) {
                    Buyer buyer = new Buyer(++countBuyer);
                    if (countBuyer % 4 == 0)
                        buyer.setPensioner(true);
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
}
