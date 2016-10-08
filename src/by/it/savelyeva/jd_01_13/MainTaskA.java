package by.it.savelyeva.jd_01_13;

/**
 * Created by nato on 9/26/16.
 */
public class MainTaskA {
    public static void main(String[] args) {
        String line;
        double sum = 0;
        System.out.println("Введите число (END для выхода)");
        while(!(line = Util.oneLine()).equals("END")) {
            try {
                double value = Double.valueOf(line.trim());
                if (value < 0) {
                    Exception e = new ArithmeticException("Отрицательное значение");
                    throw e;
                }
                sum += Math.sqrt(value);
                System.out.println("Значение = " + value + "; Сумма квадратных корней = " + sum);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка преобразования в число: " + line);
            } catch (ArithmeticException e) {
                System.out.println("Арифметическая ошибка: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Возникла ошибка: " + e.getLocalizedMessage());
                e.printStackTrace();
            }
        }
    }
}
