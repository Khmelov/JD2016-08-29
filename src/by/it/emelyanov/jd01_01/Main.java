package by.it.emelyanov.jd01_01;

public class Main {
    public static void main(String[] args) {
        MyFirstClass myFirstClass = new MyFirstClass();
        myFirstClass.setSlogan("Hello, world!"); //!!!Установален в MyFirstClass
        myFirstClass.printSlogan();
        myFirstClass.setSlogan("Привет, мир!");
        myFirstClass.printSlogan();
        new PrintArgs().showArgs(args);
    }
}
