package by.it.tsiamruk.project.java.controller;

/**
 * Created by waldemar on 02/11/2016.
 */
public interface Patterns {
    String LOGIN="^[aA-zZ0-9_-]{3,15}$";
    String PASSWORD="^.{5,12}$";
    String EMAIL="^[aA-zZ0-9._%+-]+@[aA-zZ0-9.-]+\\.[aA-zZ]{2,6}$";
    String NAME ="[aA-zZаА-яЯёЁ]+";
    String NUMBERS = "[0-9]+";
}
