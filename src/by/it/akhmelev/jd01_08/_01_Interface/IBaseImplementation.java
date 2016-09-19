package by.it.akhmelev.jd01_08._01_Interface;

/**
 * Created by Alex on 16.02.2016.
 */
public class IBaseImplementation implements IBaseAction {
    public boolean openAccount() {
        return false;
    }
    public boolean closeAccount() {
        return false;
    }
    public void blocking() {
        System.out.print("blocking");
    }
    public void unBlocking() {
        System.out.print("unBlocking");
    }
}