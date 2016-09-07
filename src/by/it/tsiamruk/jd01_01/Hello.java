package by.it.tsiamruk.jd01_01;


public class Hello {
    public static void main(String[] args){
        MyFirstClass myFirstClass=new MyFirstClass();
        myFirstClass.printSlogan();
        myFirstClass.setSlogan("Привет мир");
        myFirstClass.printSlogan();

        PrintArgs printArgs=new PrintArgs();
        printArgs.showArgs(args);
    }
}
