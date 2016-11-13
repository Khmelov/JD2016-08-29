package by.it.rudzko._Project.java.Strings;

public interface Patterns {
    String LOGIN = "[a-zA-Z0-9]{3,25}";
    String PASSWORD = "[a-zA-Z0-9]{6,25}";
    String YEAR = "(19[0-9]{2})||(200[0-9])";
    String TITLE = "([а-яА-Я]{1,15}( ){0,1}){1,2}";
    String INDEX = "[0-9]{5}";
    String AUDIENCE = "[A-Z]{1}[a-z]{2,18}";
}
