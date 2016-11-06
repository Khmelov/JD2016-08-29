package by.it.grishechkin.jd02_03;

import java.util.*;

/**
 * Created by Yury on 06.11.2016.
 */
public class Buyer implements Runnable {

   public int num;
    public Map <String, Double> bucket = new HashMap<>();

    Buyer(int num) {
        this.num = num;

        Random random = new Random();
        Goods goods = new Goods();
        HashMap<String, Double> goodsList = (HashMap<String, Double>) goods.getGoods();
        Iterator iter = goodsList.keySet().iterator();
        ArrayList<Object> keys = new ArrayList<>();
        while (iter.hasNext()) {
            keys.add(iter.next());
        }

        for (int i = 1; i < 5; i++) {
            int ind = random.nextInt(keys.size());
            this.bucket.put(keys.get(ind).toString(), goodsList.get(keys.get(ind)));
        }


    }

    @Override
    public String toString() {
        return "Покупатель № " + num;
    }


    @Override
    public void run() {

        System.out.println(this.toString() + " вошел в магазин");
        TaskB.sleep(5000);

        System.out.println(this.toString() + " выбрал товары");
        System.out.println(this.toString() + " стал в очередь");
        BuyerQueue.add(new Buyer(Runner.enteredBuyer));
        //когда покупатель стал в очередь в зал можно запустать следующего
        // т.к. одновременно только 10 человекможет быть в зале
        Runner.buyerOnRoom--;

    }
}
