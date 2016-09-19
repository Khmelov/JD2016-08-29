package by.it.sukora.JD1_01;

/**
 * Created by stasi on 08.09.2016.
 */
public class HelloWorld {
    public static void main(String[] args){
        MyClass myFirstClass=new MyClass();
        myFirstClass.printSlogan();
        myFirstClass.setSlogan("Привет мир");
        myFirstClass.printSlogan();

        Main printArgs=new Main();
        printArgs.showArgs(args);
    }
}
