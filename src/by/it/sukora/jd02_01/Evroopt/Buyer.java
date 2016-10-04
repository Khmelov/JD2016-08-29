package by.it.sukora.jd02_01.Evroopt;


import com.sun.corba.se.impl.orbutil.threadpool.ThreadPoolImpl;

import java.util.regex.Matcher;

public class Buyer implements Runnable, IBuyer, IBacket {

    private int number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Buyer(int number) {
        this.number = number;
        this.setName("Buyer № " + number);
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " Senter to Evroopt");
    }

    @Override
    public void chooseGoods() {
        for (int i = 0; i < Helper.rnd(1,4); i++) {
            Helper.sleep(Helper.rnd(100, 200));
            String goodname=Goods.random();
            System.out.println(this + " choosed goods: "+goodname);
            putGoodsBacket();
        }


    }

    @Override
    public void goToOut() {
        System.out.println(this + " go to out from Evroopt");
    }

    @Override
    public String toString() {
        return "Buyer №" + number;
    }

    @Override
    public void takeBacket() {
        Helper.sleep(Helper.rnd(100, 200));
        System.out.println(this + " take backet");
    }

    @Override
    public void putGoodsBacket() {
        Helper.sleep(Helper.rnd(100,200));
        System.out.println(this + " put goods to backet");
    }
}
