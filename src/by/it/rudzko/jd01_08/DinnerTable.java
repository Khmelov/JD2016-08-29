package by.it.rudzko.jd01_08;

/**
 * Created by Leta on 18.09.2016.
 */
public class DinnerTable extends Table {

    public DinnerTable(){
        super.getPar();
        super.getPrice();
    }

    @Override
    public void descr(float [] prices){

        prices[1]=super.getP();
    }

    @Override
    public void descr() {
        System.out.println("\n\nCoffee Table\nLength: "+super.getL()+".\nWidth: "+super.getW()+".\nPrice: "+super.getP()+".");
    }
}
