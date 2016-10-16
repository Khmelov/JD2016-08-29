package by.it.ilyukhin.jd01_13;


public class TaskA {
    public static void main(String[] args) {
        String str=Util.line();
        double sum = 0;
        while (!(str.equals("END"))){
            try {
                double value = Double.valueOf(str.trim());
                if (value < 0) {
                    ArithmeticException e = new ArithmeticException("Отрицательное число");
                    throw e;
                }
                sum = sum + Math.sqrt(value);
                System.out.flush();
                System.out.println("Value= " + value + " Sum = " + sum);
            } catch (NumberFormatException e) {
                System.out.println("Возникла ошибка преобразования числа: " + e.getLocalizedMessage());

            } catch (ArithmeticException e) {
                System.out.println("Возникла ошибка: " + e.getMessage());

            }
        }
    }
}