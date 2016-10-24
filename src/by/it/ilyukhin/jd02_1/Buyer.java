package by.it.ilyukhin.jd02_1;


public class Buyer extends Thread implements IBuyer {

    private int number;

    public Buyer(int number){
        this.number=number;
        this.setName("Buyer №"+number);

    }
    @Override
    public void enterToMarket() {
        System.out.println(this+" enter to Market");

    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToOut();
    }

    @Override
    public void chooseGoods()  {
        try {
            sleep(500+(int)Math.round((Math.random()*1500)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this + " choose goods");
        }


    @Override
    public void goToOut() {
        System.out.println(this+" go out from Market");

    }

    @Override
    public String toString() {
        return "Buyer № "+ number;
    }
}

