package by.it.tsydzik.jd02_03Training;

/**
 * @author Eugene Tsydzik
 * @since 11.10.16.
 */
public class Buyer implements Runnable, IBuyer {

    int number;                    //номер покупателя
    public boolean iWait = false; //флаг того, что покупатель в ожидании

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Buyer(int number) {
        this.number = number;
        this.setName("Покупатель №" + number);
    }

    @Override
    public String toString() {
        return "Покупатель №" + number;
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " вошел в магазин");
    }

    @Override
    public void chooseGoods() {
        Helper.sleep(Helper.rnd(500, 1500));
        System.out.println(this + " выбрал товар");
    }

    @Override
    public void goToQueue() {
        QueueBuyers.add(this);
        System.out.println(this + " добавлен в очередь");
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void goToOut() {
        System.out.println(this + " вышел из магазина");
    }

    @Override
    public void run() {
        enterToMarket();
//        takeBacket();
        chooseGoods();
        goToQueue();
        goToOut();
    }
}
