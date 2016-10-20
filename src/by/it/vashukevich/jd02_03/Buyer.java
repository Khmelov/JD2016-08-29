package by.it.vashukevich.jd02_03;

public class Buyer implements IBuyer, Runnable, IUseBacket {
    private int num;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Buyer(int num) {
        this.num = num;
        this.setName("Покупатель № " + num);
    }


    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        goToQueue();
        goToOut();

    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " вошел в магазин");

    }

    @Override
    public void chooseGoods() {
        for(int i=1;i< Help.fromTo(1,4);i++){
        Help.sleep(Help.fromTo(100, 200));
        String goodName = Goods.random();
        System.out.printf( "%s выбрал : %s, %.2f\n",this,goodName,Goods.table.get(goodName));
        putGoodsToBacket();
    }
}
    @Override
    public void goToQueue() {
      synchronized (QueueBuyers.monitorQueueBuyer){
          QueueBuyers.add(this);
          System.out.println(this+" встал в очередь");
      }
      synchronized (this){
          try{
              this.wait();
          }catch (InterruptedException e){
              e.printStackTrace();
          }
      }
    }

    @Override
    public void goToOut() {
        Dispatcher.countOutBuyers.incrementAndGet();
        System.out.println(this + " вышел из магазина");
    }

    @Override
    public String toString() {
        return "Покупатель № " + num;
    }

    @Override
    public void takeBacket() {
        Help.sleep(Help.fromTo(100, 200));
        System.out.println(this + " взял корзину");
    }

    @Override
    public void putGoodsToBacket() {
        Help.sleep(Help.fromTo(100, 200));
        System.out.println(this + " положил товар в корзину");
    }


}

