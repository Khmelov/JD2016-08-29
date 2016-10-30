package by.it.senchenko.jd02_06;

public class Main {
    public static void main(String[] args) {
        int var=1;
        Logger logger=Logger.getInstance();
        for (int i = -5; i < 5; i++) {
            try {
                var /= i;
            }catch (ArithmeticException e){
                logger.errToLog("Деление на ноль");
            }
        }
    }
}
