package by.it.emelyanov.jd02_03;

class Buyer extends Thread implements IBuyer, IUseBasket {

    int num; //номер покупателя
    public boolean iWait = false;

    //конструктор покупателя
    public Buyer() {
        num = ++Dispatcher.countBuyers;
        this.setName("Покупатель № " + num + " ");
        start();
    }

    @Override
    public void run() {
        enterToMarket();//зашёл
        takeBacket();//взял корзинку
        chooseGoods();//выбирает товар
        putGoodsToBacket();//кладёт товар в корзинку
        goToQueue();//очередь
        goToOut();//вышел
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "Вошел в магазин");
    }

    @Override
    public void chooseGoods() {
        int pause = Helper.fromTo(500, 2000);
        Helper.sleep(pause);
        System.out.println(this + "Выбрал товар");
    }

    @Override
    public void goToQueue() {
        synchronized (this) {
            System.out.println(this + "Встал в очередь на кассу");
            QueueBuyers.add(this);
            iWait = true;
            while (iWait) try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this + "Закончил оплату товаров на кассе");

        }
    }

    @Override
    public void goToOut() {
        System.out.println(this + "Вышел из магазина");
    }

    @Override
    public void takeBacket() {
        System.out.println(this + "Берёт корзинку");

    }

    @Override
    public void putGoodsToBacket() {
        System.out.println(this + "Кладёт товары в корзину");
        double fullPrice=0;
        for (int i = 0; i < Basket.takeGoods(); i++) {
            Basket basket = new Basket();
            Object[] keys=basket.goods().keySet().toArray();
            String good=(String)keys[(int)(Math.random()*keys.length)];
            System.out.println(this+ "кладёт в корзину "+  good+" стоимость "+basket.goods().get(good));
            fullPrice+=basket.goods().get(good);
        }
        System.out.println(this + "добавил товары в корзину на "+fullPrice+" рублей");
    }
}
