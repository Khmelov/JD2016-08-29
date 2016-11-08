package by.it.artiuschik.project.java.controller;

public interface Patterns {
    String LOGIN="[a-zA-Z0-9а-яА-Я]+";
    String PASSWORD="[a-zA-Z0-9.-]+";
    String TEXT="(([a-zA-Z]+)|([а-яА-Я]+))";//Паттерн для имени, фамилии, текстовых данных
}
