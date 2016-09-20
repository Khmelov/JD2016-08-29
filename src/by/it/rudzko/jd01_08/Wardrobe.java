package by.it.rudzko.jd01_08;

/**
 * Created by Leta on 18.09.2016.
 */
public class Wardrobe extends Locker {
    @Override
    public void descr() {
        System.out.println("\n\nWardrobe\nLength: "+super.getL()+".\nWidth: "+super.getW()+".\nPrice: "+super.getP()+".");
    }

    @Override
    public void descr(float[] prices) {

        prices[4]=super.getP();
    }
}
