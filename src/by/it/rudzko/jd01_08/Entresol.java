package by.it.rudzko.jd01_08;

/**
 * Created by Leta on 18.09.2016.
 */
public class Entresol extends Locker {

    public Entresol() {
        super.getPar();
        super.getPrice();
    }

    @Override
    public float findSq() {
        return 0;
    }

    @Override
    public void descr() {
        System.out.println("\n\nEntresol\nLength: "+super.getL()+".\nWidth: "+super.getW()+".\nPrice: "+super.getP()+".");
    }

    @Override
    public void descr(float[] prices) {

        prices[5]=super.getP();
    }
}
