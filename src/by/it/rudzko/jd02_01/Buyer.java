package by.it.rudzko.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Olga Rudzko
 *
 */
public class Buyer extends Thread implements IBuyer, IUseBasket{

    private int number;
    private boolean pensioner;

    public Buyer(int number, boolean pensioner){
        this.number=number;
        this.pensioner=pensioner;
        this.setName("Buyer "+this.number);
    }


    @Override
    public void run() {
        enterShop();
        takeBasket();
        putGoods();
        leaveShop();
    }

    @Override
    public void enterShop() {
        System.out.println(this.getName()+" entered the shop.");
    }

    @Override
    public void takeBasket() {
        if(!pensioner) { Helper.performing(Helper.random(100, 200)); }
        else { Helper.performing(Helper.random(400, 800)); }
        System.out.println(this.getName()+" took the basket.");
    }

    /**
     * @return the list of products buyer chose
     *
     */
    @Override
    public HashMap<String, Double> chooseGoods() {
        Map<String, Double> goods=new HashMap<String, Double>();
        goods.put("milk", 1.0);              goods.put("butter", 2.0);        goods.put("eggs", 1.5);
        goods.put("meat", 10.0);             goods.put("cheese", 8.5);        goods.put("sweets", 3.0);
        goods.put("fish", 15.0);             goods.put("water", 2.0);         goods.put("fruits", 3.0);
        goods.put("vegetables", 3.0);        goods.put("bread", 1.0);         goods.put("tea", 2.5);
        goods.put("napkins", 1.0);           goods.put("sauce", 2.5);         goods.put("oil", 2.5);
        List<String> list=new ArrayList<String>(goods.keySet());
        HashMap <String, Double> choice=new HashMap<String, Double>(){
            @Override
            public String toString() {
                StringBuilder sb=new StringBuilder();
                ArrayList <String> list=new ArrayList<String>(this.keySet());
                for (int i=0; i<list.size(); i++) {
                    if (i!=list.size()-1){
                    sb.append(list.get(i)+" (price: "+this.get(list.get(i))+" rubles), ");
                    } else sb.append(list.get(i)+" (price: "+this.get(list.get(i))+" rubles).");
                }
                return sb.toString();
            }
        };
        int amount=Helper.random(4);
        for (int i=0; i<amount; i++){
            int pos=Helper.random(14);
            if(!pensioner) { Helper.performing(Helper.random(500, 2000)); }
            else { Helper.performing(Helper.random(2000, 8000)); }
            choice.put(list.get(pos), goods.get(list.get(pos)));
        }

        return choice;
    }

    @Override
    public void putGoods() {
        if (!pensioner) { Helper.performing(Helper.random(100, 200)); }
        else { Helper.performing(Helper.random(400, 800)); }
        System.out.println(this.getName()+" bought "+chooseGoods());
    }

    public boolean getPensioner(){
        return this.pensioner;
    }

    @Override
    public void leaveShop() {
        System.out.println(this.getName()+" left the shop.");
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
