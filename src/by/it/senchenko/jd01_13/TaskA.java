package by.it.senchenko.jd01_13;

import java.util.Scanner;

    public class TaskA {
        public static void main(String[] args) {
            String line;
            boolean on = true;
            double sqrt = 0;
            while (on) {
                try {
                    Scanner in = new Scanner(System.in);
                    line = in.nextLine().trim();

                    if (!line.equals("END")) {
                        double value = Double.valueOf(line);
                        if (value < 0) {
                            ArithmeticException e = new ArithmeticException("Отрицательное число");
                            throw e;
                        }
                        sqrt += Math.sqrt(value);
                        System.out.println("Введено число: "+value+" Сумма всех корней равна: "+sqrt);
                    } else
                        on = false;

                } catch (NumberFormatException e) {
                    System.out.println("Возникла ошибка преобразования числа " + e.getLocalizedMessage());
                } catch (ArithmeticException e) {
                    System.out.println();
                }
            }
        }
}
