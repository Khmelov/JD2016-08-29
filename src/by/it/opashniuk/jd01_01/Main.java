package by.it.opashniuk.jd01_01;

public class Main {
    public static void main(String[] args) {
        MyFirstClass myFirstClass=new MyFirstClass();
        myFirstClass.setSlogan("Hello, World!");
        myFirstClass.printSlogan();
        myFirstClass.setSlogan("Привет Мир!");
        myFirstClass.printSlogan();
        new PrintArgs() .showArgs(args);
    }
}
