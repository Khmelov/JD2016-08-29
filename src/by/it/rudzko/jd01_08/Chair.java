package by.it.rudzko.jd01_08;

/**
 * Created by Leta on 18.09.2016.
 */
public class Chair extends Seat {
    @Override
    public void descr() {
        System.out.println("\n\nArmchair\nLength: "+super.getL()+".\nWidth: "+super.getW()+".\nPrice: "+super.getP()+".");
    }

    @Override
    public void descr(float[] prices) {

        prices[2]=super.getP();
    }
}
