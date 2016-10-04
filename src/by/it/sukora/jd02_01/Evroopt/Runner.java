package by.it.sukora.jd02_01.Evroopt;


public class Runner {
    public static void main(String[] args) {
        int countBuyer = 0;
        while (countBuyer < 20) {
            int n = Helper.rnd(2);
            for (int i = 0; i < n; i++) {
                Buyer buyer = new Buyer(++countBuyer);
                Thread th = new Thread(buyer);
                th.start();
                if (countBuyer == 20)
                    break;
            }
            Helper.sleep(1000);
        }
    }
}
