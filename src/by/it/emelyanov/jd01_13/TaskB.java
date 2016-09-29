package by.it.emelyanov.jd01_13;

public class TaskB {
    public static void main(String[] args) {
        try {
            level1();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за границы массива");
            StackTraceElement[] stack = e.getStackTrace();
            StackTraceElement err = stack[0];
            int line = err.getLineNumber();
            String name = err.getMethodName();
            String file = err.getFileName();
            System.out.println("В файле " + file + " В методе " + name + " В строке " + line);
        } catch (Exception e) {
            System.out.println("Ошибка " + e.getMessage());
        }
    }

    static void level1() throws Exception {
        System.out.println("Start level1");
        level2();

        System.out.println("Stop level1");
        throw new Exception("Наша ошибка");
    }

    static void level2() throws ArrayIndexOutOfBoundsException {

        System.out.println("Start level2");
        level3();
        System.out.println("Stop level2");
    }

    static void level3() throws ArrayIndexOutOfBoundsException {
        System.out.println("Start level3");
        int mass[] = new int[2];
        mass[0] = 1;
        mass[1] = 10;
        int i = (int) Math.round(Math.random() * 3);
        try {
            int j = 10 / i;
            int k = mass[i] / 10;
            System.out.println("i= " + i + " j= " + j + " k= " + k);
        } catch (ArithmeticException e) {
            System.out.println("Деление на 0");
        }
        System.out.println("Stop level3, i= " + i);
    }
}
