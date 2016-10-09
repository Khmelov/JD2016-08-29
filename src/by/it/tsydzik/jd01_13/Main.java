package by.it.tsydzik.jd01_13;

/**
 * @author Eugene Tsydzik
 * @since 09/26/16.
 */
public class Main {
    public static void main(String[] args) {
       // TaskA.taskA();

        try {
            TaskB.level1();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за границы массива");
            StackTraceElement[] stackTrace = e.getStackTrace();
            StackTraceElement error = stackTrace[0];
            int lineNumber = error.getLineNumber();
            String fileName = error.getFileName();
            String methodName = error.getMethodName();
            System.out.println("In file " + fileName + " in method " + methodName + " error in lineNumber " + lineNumber);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
