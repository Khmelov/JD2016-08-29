package by.it.grishechkin.jd02_01;

/**
 * Created by Yury on 03.10.2016.
 */
public class Runner {
    public static void main(String[] args) {
        int countBuyer = 0;
        while (countBuyer < 20) {
            int n = Helper.rnd(2);
            for (int i = 0; i < n; i++) {
                Buyer buyer = new Buyer(++countBuyer);
                Thread th1 = new Thread(buyer);
                th1.start();
                if (countBuyer == 20)
                    break;
            }
           Helper.sleep(1000);
        }
    }
}
