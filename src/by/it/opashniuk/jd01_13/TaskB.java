package by.it.opashniuk.jd01_13;


import java.lang.Exception;

public class TaskB {
    public static void main(String[] args) {
        try {
            level1();
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Выъод за границы массива");
            StackTraceElement[] stack = e.getStackTrace();
            StackTraceElement error = stack[0];
            int errLine = error.getLineNumber();
            String errName = error.getMethodName();
            String errFileName = error.getFileName();
            System.out.println("В файле " + errFileName + " возникла ошибка в методе " + errName + " в строке " + errLine);
        }
        catch (Exception e){
            System.out.println("Ошибка"+e.getMessage());
        }
    }

    static void level1() throws ArrayIndexOutOfBoundsException, Exception{
        System.out.println("Start Level 1");
        level2();
        System.out.println("Stop Level 1");
        throw new Exception("Наша ошибка");
    }

    static void level2() throws ArrayIndexOutOfBoundsException{
        System.out.println("Start Level 2");
        level3();
        System.out.println("Stop Level 2");
    }

    static void level3() throws ArrayIndexOutOfBoundsException{
        System.out.println("Start Level 3");
        int[] mas=new int[2]; mas[0]=1; mas[1]=10;
        int i=(int) Math.round(Math.random()*3);
    try{
        int j = 10 / i;
        int k = mas[i] / 10;
        System.out.println("I = " + i + " J = " + j + " K = " + k);
    }
    catch (ArithmeticException e){
        System.out.println("Деление на ноль");
    }
    System.out.println("End level 3 I = " + i);
    }
}
