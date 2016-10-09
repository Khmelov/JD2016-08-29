package by.it.rudzko.jd_02_03;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Olga Rudzko
 */
public class Buyer extends Thread implements IBuyer, IUseBasket {

    private int number;
    private boolean pensioner;
    static final int AMOUNT_OF_BUYERS = 100;
    static AtomicInteger countBuyers = new AtomicInteger(0);
    Map<String, Double> choice = new HashMap<String, Double>() {
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ArrayList<String> list = new ArrayList<>(this.keySet());
            for (int i = 0; i < list.size(); i++) {
                int l = list.get(i).toCharArray().length;
                StringBuilder sb2 = new StringBuilder();
                for (int j = 0; j < 10 - l; j++) {
                    sb2.append(" ");
                }
                sb.append(list.get(i) + sb2 + this.get(list.get(i)) + "\n");
            }
            return sb.deleteCharAt(sb.length() - 1).toString();
        }
    };

    public Buyer(int number, boolean pensioner) {
        this.number = number;
        this.pensioner = pensioner;
        this.setName("Buyer " + this.number);
    }


    @Override
    public void run() {
        enterShop();
        takeBasket();
        chooseGoods();
        putGoods();
        gotoQueue();
        leaveShop();
    }

    @Override
    public void enterShop() {
        System.out.println(this.getName() + " entered the shop.");
    }

    @Override
    public void takeBasket() {
        if (!pensioner) {
            Helper.performing(Helper.random(100, 200));
        } else {
            Helper.performing(Helper.random(400, 800));
        }
        System.out.println(this.getName() + " took the basket.");
    }


    @Override
    public void chooseGoods() {
        Map<String, Double> goods = new HashMap<>();
        goods.put("milk", 1.0);         goods.put("butter", 2.0);       goods.put("eggs", 1.5);
        goods.put("meat", 10.0);        goods.put("cheese", 8.5);       goods.put("sweets", 3.0);
        goods.put("fish", 15.0);        goods.put("water", 2.0);        goods.put("fruits", 3.0);
        goods.put("porridge", 3.0);     goods.put("bread", 1.0);        goods.put("tea", 2.5);
        goods.put("napkins", 1.0);      goods.put("sauce", 2.5);        goods.put("oil", 2.5);
        List<String> list = new ArrayList<>(goods.keySet());

        int amount = Helper.random(4);
        for (int i = 0; i < amount; i++) {
            int pos = Helper.random(14);
            if (!pensioner) {
                Helper.performing(Helper.random(500, 2000));
            } else {
                Helper.performing(Helper.random(2000, 8000));
            }
            choice.put(list.get(pos), goods.get(list.get(pos)));
        }
    }

    @Override
    public void gotoQueue() {
        QueueBuyers.addBuyer(this);
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void putGoods() {
        if (!pensioner) {
            Helper.performing(Helper.random(100, 200));
        } else {
            Helper.performing(Helper.random(400, 800));
        }
        ArrayList<String> goods = new ArrayList<String>() {
            @Override
            public String toString() {
                StringBuilder sb = new StringBuilder();
                Iterator<String> i = this.iterator();
                while (i.hasNext()) {
                    sb.append(i.next() + ", ");
                }
                return sb.delete(sb.length() - 2, sb.length()).toString();
            }
        };
        Iterator<String> it = choice.keySet().iterator();
        while (it.hasNext()) {
            goods.add(it.next());
        }
        System.out.println(this.getName() + " put " + goods + " in basket.");
    }

    public boolean getPensioner() {
        return this.pensioner;
    }

    @Override
    public void leaveShop() {
        System.out.println(this.getName() + " left the shop.");
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
