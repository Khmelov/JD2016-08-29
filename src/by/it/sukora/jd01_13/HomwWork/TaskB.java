package by.it.sukora.jd01_13.HomwWork;


public class TaskB {
    public static void main(String[] args) {
       try{
           level1();
       }
       catch (ArrayIndexOutOfBoundsException e){
           System.out.println("Выход за границы массива");
           StackTraceElement[] stack =e.getStackTrace();
           StackTraceElement err=stack[0];
           int line = err.getLineNumber();
           String name = err.getMethodName();
           String file = err.getFileName();
           System.out.println("В файле "+file+" возникла ошибка в методе "+name+" в строке "+line);
       }
       catch (Exception e)
       {
           System.out.println("Ошибка "+e.getMessage());
       }

    }
    static void level1()throws ArrayIndexOutOfBoundsException, Exception{
        System.out.println("Start Level 1");
        level2();

        System.out.println("Stop Level 1");
        throw new Exception("Наша ошибка");
    }
    static void level2()throws ArrayIndexOutOfBoundsException{
        System.out.println("Start Level 2");
        level3();
        System.out.println("Stop Level 2");
    }
    static void level3() throws ArrayIndexOutOfBoundsException{
        System.out.println("Start Level 3");
        int[] mas = new int[2]; mas[0]=1; mas[1]=10;
        int i = (int)Math.round(Math.random()*3);
        try {
            int j = 10 / i;
            int k = mas[i] / 10;
            System.out.println("I= " + i + " J= " + j + " k= " + k);

        }
        catch (ArithmeticException e){
            System.out.println("Деление на ноль");
        }
        System.out.println("Stop Level 3");
    }
}
