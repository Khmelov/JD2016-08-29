package by.it.tsiamruk.jd01_13;

/**
 * Created by waldemar on 26/09/2016.
 */
public class TaskB {
    public static void main(String[] args) {
        try {
            level1();
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Выход за границы массива");
            StackTraceElement[] stack = e.getStackTrace();
            StackTraceElement error = stack[0];
            int errLine = error.getLineNumber();
            String errName = error.getMethodName();
            String errFileName = error.getFileName();
            System.out.println("В файле " + errFileName + " возникла ошибка в методе " + errName + " в строке " + errLine);
        }
        catch (Exception e){
            System.out.println("Ошибка " + e.getMessage());
        }
    }
    static void level1() throws ArrayIndexOutOfBoundsException, Exception{
        System.out.println("Start level 1");
        level2();
        System.out.println("End level 1");
        throw new Exception("Наша ошибка");

    }
    static void level2() throws ArrayIndexOutOfBoundsException{
        System.out.println("Start level 2");
        leve3();
        System.out.println("End level 2");
    }
    static void leve3() throws ArrayIndexOutOfBoundsException{
        System.out.println("Start level 3");
        int[] mas = new int[2]; mas[0] = 1; mas[1] = 10;
        int i = (int) Math.round(Math.random()*3);
        try {
            int j = 10/i;
            int k = mas[i]/10;
            System.out.println("I = " + i + " J = " + j + " K = " + k);
        }
        catch (ArithmeticException e){
            System.out.println("Деление на ноль");
        }
        System.out.println("End level 3 I = " + i);
    }
}
