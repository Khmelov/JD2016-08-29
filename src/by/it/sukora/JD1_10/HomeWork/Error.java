package by.it.sukora.JD1_10.HomeWork;

public class Error {
    //должен наследоваться extends Exception
    //но материала не было, поэтому будет просто вывод
    public Error(String hint) {
        System.out.println("ERR:" + hint);
    }
}
