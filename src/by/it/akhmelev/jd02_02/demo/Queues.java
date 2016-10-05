package by.it.akhmelev.jd02_02.demo;

import java.util.ArrayDeque;
import java.util.Deque;

class Queues {
    static final Deque<Buyer> buyers = new ArrayDeque<Buyer>() {
        @Override
        public void addLast(Buyer buyer) {
            synchronized (buyers) { //мы не знаем из какого потока будет вызвано добавление
                super.addLast(buyer);
                //создадим кассу В МОМЕНТ добавления человека в ОЧЕРЕДЬ.
                //это логичнее и позволяет даже не проверять размер очереди (как минимум один в ней точно есть)
                //но мы проверим. Пусть будет 2 и более человека на кассу. А касс не более 5. Тогда условние:
                if (Runner.countCashiers < 5 && Queues.buyers.size()>Runner.countCashiers*5) {
                    Cashier cashier = new Cashier(++Runner.countCashiers);
                    new Thread(cashier).start();
                }
            }
        }
    };

}
