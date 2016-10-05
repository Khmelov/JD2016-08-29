package by.it.opashniuk.jd01_13;


public class TaskA {
    public static void main(String[] args) {
        String line;
        double sum = 0;
        while (!(line = Util.oneLine()).equals("END")) {
            try {
                double value = Double.valueOf(line.trim());
                if (value < 0) {
                    ArithmeticException e = new ArithmeticException("Отрицательное число");
                    throw e;
                }
                sum = sum + Math.sqrt(value);
                System.out.flush();
                System.out.println("Value" + value + " Sum=" + sum);
            }
            catch (NumberFormatException e) {
                System.out.println("Возникла ошибка преобразования числа " + e.getLocalizedMessage());
            }
            catch (ArithmeticException e) {
                System.out.println("Возникла ошибка " + e.getMessage());
            }
            catch (Exception e) {
                System.out.println("Возникла ошибка " + e.getLocalizedMessage());
                e.printStackTrace();
            }
        }

    }
}
