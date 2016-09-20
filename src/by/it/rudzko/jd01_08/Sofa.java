package by.it.rudzko.jd01_08;

/**
 * Created by Leta on 18.09.2016.
 */
public class Sofa extends Seat {
    @Override
    public void descr() {
        System.out.println("\n\nSofa\nLength: "+super.getL()+".\nWidth: "+super.getW()+".\nPrice: "+super.getP()+".");
    }

    @Override
    public void descr(float[] prices) {

        prices[3]=super.getP();
    }
}
