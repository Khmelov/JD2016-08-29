package by.it.akhmelev.jd01_08._05_AbstractCard;

/**
 * Created by Alex on 16.02.2016.
 */
public class CreditCardAction extends AbstractCardAction {
    // поля, конструкторы, методы
    @Override // аннотация указывает на полиморфную природу метода
    // метод должен быть реализован в подклассе
    public void doPayment(double amountPayment) { // переопределенный метод
        // реализация
        System.out.println("complete from credit card!");
    }
}


