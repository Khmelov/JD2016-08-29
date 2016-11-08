package by.it.savelyeva.project.java.controller;

/**
 * Created by nato on 11/2/16.
 */
public interface IPattern {

    String ID = "[0-9]+";
    String LOGIN = "^[a-zA-Z0-9_-]{3,16}$";
    String SERIAL = "^[a-zA-Z0-9-]{3,16}$";
    String PASSWORD = "^[a-zA-Z0-9_-]{8,18}$";
    String EMAIL = "^([a-zA-Z0-9_\\.-]+)@([a-zA-Z0-9_\\.-]+)\\.([a-zA-Z\\.]{2,6})$"; //"^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
    String DATE = "^(19|20)\\d\\d[-](0[1-9]|1[012])[-](0[1-9]|[12][0-9]|3[01])$";
    String BOOL = "(true|false)";
    String WORD = "[a-zA-Zа-яА-Я]+";
    String WORDOREMPTY = "(^$|[a-zA-Zа-яА-Я]+)";

}
