package by.it.tsiamruk.project.java.controller;

/**
 * Created by waldemar on 02/11/2016.
 */
public interface Patterns {
    String LOGIN="^[aA-zZ0-9_-]{3,15}$";
    String PASSWORD="^.{6,12}$";
    String EMAIL="^[Aa-Zz0-9._%+-]+@[Az-Zz0-9.-]+\\.[Aa-Zz]{2,6}$";
}
