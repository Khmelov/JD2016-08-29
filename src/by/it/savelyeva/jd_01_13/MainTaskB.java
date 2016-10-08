package by.it.savelyeva.jd_01_13;
//if znam ==0 throw, catch in main
/**
 * Created by nato on 9/26/16.
 */
public class MainTaskB {
    public static void main(String[] args) {
        try {
            level1();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index is out of range");
            StackTraceElement[] stack = e.getStackTrace();
            StackTraceElement err = stack[0];
            System.out.printf("Error occured in the file '%s' in method '%s' on line %d\n",
                    err.getFileName(), err.getMethodName(), err.getLineNumber());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void level1() throws Exception {
        System.out.println("Start level 1");
        level2();
        System.out.println("Stop level 1");
        //throw new Exception("Our error");
    }

    static void level2() throws ArrayIndexOutOfBoundsException {
        System.out.println("Start level 2");
        level3();
        System.out.println("Stop level 2");
    }

    static void level3() throws ArrayIndexOutOfBoundsException {
        System.out.println("Start level 3");
        int[] mas = new int[2]; mas[0] = 1; mas[1] = 10;
        int i = (int) Math.round(Math.random()*2);
        try {
            int j = 10/i;
            int k = mas[i];
            System.out.printf("i = %d, j = %d, k = %d\n", i, j, k);
        } catch (ArithmeticException e) {
            System.out.println("Division by zero");
            //e.printStackTrace();
        }
        System.out.println("Stop level 3. I=" + i);
    }
}
