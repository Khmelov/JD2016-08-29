package by.it.rudzko.jd01_13;

/**
 * Created by Leta on 28.09.2016.
 */
public class Runner {
    public static void main (String[]args){

        TaskA.FindSQRT();

        try{
            TaskB.heigth();
        }
        catch(ArithmeticException e){
            System.out.println(e);
            StackTraceElement[] stack=e.getStackTrace();
            StackTraceElement err=stack[0];
            int line=err.getLineNumber();
            String name=err.getMethodName();
            String file=err.getFileName();
            System.out.println("В файле "+file+" возникла ошибка в методе "+name+" в строке "+line);
        }
        catch (NumberFormatException e){
            System.out.println("Некорректный ввод числа.");
        }

    }

}
