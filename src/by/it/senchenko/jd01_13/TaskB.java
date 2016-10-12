package by.it.senchenko.jd01_13;

public class TaskB {
    public static void main(String[] args) {
        try {
            procedure1();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за границы массива");
            StackTraceElement[] stackTraceElements = e.getStackTrace();
            StackTraceElement error = stackTraceElements[0];
            int line = error.getLineNumber();
            String name = error.getMethodName();
            String file = error.getFileName();
            System.out.println("В файле " + file + " возникла ошибка в процедуре " + name + "строке");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Ошибка " + e.getMessage());
        }
    }

    static void procedure1() throws ArrayIndexOutOfBoundsException {
        System.out.println("Старт процедуры №1");
        procedure2();
        System.out.println("Завершение процедуры №1");

    }

    static void procedure2() throws ArrayIndexOutOfBoundsException {
        System.out.println("Старт процедуры №2");
        procedure3();
        System.out.println("Завершение процедуры №2");
    }

    static void procedure3() throws ArrayIndexOutOfBoundsException {
        System.out.println("Старт процедуры №3");
        int[] array = new int[2];
        array[0] = 1;
        array[1] = 10;
        int i = (int) Math.round(Math.random() * 3);
        try {
            int j = 10 / i;
            int k = array[i] / 10;
            System.out.println("Завершение процедуры №3. I=" + i);
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        }
    }
}
