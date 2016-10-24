package by.it.ilyukhin.jd02_1;


public class Runner {
    public static void main(String[] args) {
        int countBuyer = 0;
        while (countBuyer < 21) {
            int n = (int) (Math.round(Math.random() * 2));
            for (int i = 0; i < n; i++) {
                Buyer buyer = new Buyer(++countBuyer);
                buyer.start();
                if (countBuyer == 20)
                    try {
                        buyer.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
