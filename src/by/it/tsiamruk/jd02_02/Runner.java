package by.it.tsiamruk.jd02_02;

public class Runner {
    public static void main(String[] args) {
        int countBuyer = 0;
        while (countBuyer < 8) {
            int n = Helper.rnd(2);
            for (int i = 0; i < n; i++) {
                Buyer buyer = new Buyer(++countBuyer);
                if (countBuyer % 4 == 0)
                    buyer.setPensioner(true);
                Thread th = new Thread(buyer);
                th.start();
                if (countBuyer == 20)
                    break;
            }
            Helper.sleep(1000);
        }
    }
}
