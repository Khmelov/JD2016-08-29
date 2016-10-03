package by.it.tsydzik.jd02_01;

/**
 * @author Eugene Tsydzik
 * @since 10/03/16.
 */
public class Buyer extends Thread implements IBuyer {

    private int number;

    public Buyer(int number) {
        this.number = number;
        this.setName("Buyer №" + number);
    }

    @Override
    public String toString() {
        return "Buyer №" + number;
//        return this.getName();
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to market");
    }

    @Override
    public void chooseGoods() {
        Helper.sleep(Helper.rnd(500, 2000));
        System.out.println(this + " choose goods");
    }

    @Override
    public void goToOut() {
        System.out.println(this + " go to out");
    }
}
