package by.it.emelyanov.jd01_01;

public class PrintArgs {
    public void showArgs(String[] args) {
        for (String str : args)
            System.out.printf("Аргумент==> %s%n", str);
    }
}