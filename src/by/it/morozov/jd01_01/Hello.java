package by.it.morozov.jd01_01;

/**
 * Created by BukTpbI4 on 13.09.2016.
 */
public class Hello {
    public static void main(String[] args) {
        MyFirstClass myFirstClass=new MyFirstClass();
        myFirstClass.printSlogan();
        myFirstClass.setSlogan("Привет Мир");
        myFirstClass.printSlogan();
        PrintArgs printArgs=new PrintArgs();
        printArgs.showArgs(args);
    }
}
