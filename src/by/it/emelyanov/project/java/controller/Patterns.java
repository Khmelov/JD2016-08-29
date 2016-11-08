package by.it.emelyanov.project.java.controller;

public interface Patterns {
    String LOGIN = "^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$";
    String PASSWORD = "^[a-z0-9_-]{6,18}$";
    String EMAIL = "\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,6}";
    String DATE = "(\\d{4})-(0\\d|1[012])\\-([0-2]\\d|3[01])";
    String NUMB = "\\d{1,3}";
    String MONEY = "-?\\d+(\\.\\d{0,})?";
}
