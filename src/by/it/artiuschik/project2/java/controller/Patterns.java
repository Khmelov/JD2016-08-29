package by.it.artiuschik.project2.java.controller;

public interface Patterns {
    String LOGIN="[a-zA-Z0-9а-яА-Я]+";
    String PASSWORD="[a-zA-Z0-9.-]+";
    String TEXT="[a-zA-Zа-яА-ЯёЁ]+";
    String TEST_NAME="\\b[a-zA-ZА-Яа-яёЁ ]*\\b";
    String QUESTION_TEXT="\\b[a-zA-ZА-Яа-яёЁ ,!?.]*\\b";
}
