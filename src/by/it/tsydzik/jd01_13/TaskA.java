package by.it.tsydzik.jd01_13;

/**
 * @author Eugene Tsydzik
 * @since 09/26/16.
 */
public class TaskA {
    static void taskA(){
        String line;
        double sum = 0;
        while (!(line = Util.oneLine()).equals("END")) {
            try {
                double value = Double.valueOf(line.trim());

                if (value < 0) {
                    throw new ArithmeticException("Вы ввели отрицательное число. Введите положительное");
                }

                sum = sum + Math.sqrt(value);
                System.out.println("Value = " + value + " sum = " + sum);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка преобразования числа: " + line);
            } catch (ArithmeticException e) {
                System.out.println(e);
            } catch (Exception e) {
                System.out.println("Occurred error " + e.getLocalizedMessage());
                e.printStackTrace();
            }
        }
    }

}
