package by.it.akhmelev.jd01_08._05_AbstractCard;

/**
 * Created by Alex on 16.02.2016.
 */
public abstract class AbstractCardAction {
    private int id;
    public AbstractCardAction() { // конструктор
    }
    // more methods
    public boolean checkLimit() { // собственный метод
        return true; // stub
    }
    public abstract void doPayment(double amountPayment);
}