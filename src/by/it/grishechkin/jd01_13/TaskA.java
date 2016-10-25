package by.it.grishechkin.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Yury on 21.10.2016.
 */
public class TaskA {

    public static void readAndPrint() {

        List <Integer> numbers = new ArrayList<>();
        while (true) {
            System.out.println("Введите число, для завершения введите \"END\":");
            String line = new Scanner(System.in).nextLine();
            if (line.equals("END")) System.exit(0);
            try {
                numbers.add(Integer.valueOf(line));
            }
            catch (NumberFormatException e) {
                System.err.println(" Невозможно преобраховать строку в число");
                System.exit(0);
            }
            System.out.println("Введенное число: " + numbers.get(numbers.size() - 1) + " ---- Сумма корней = " + sqrtSum(numbers));
        }
    }

    public static double sqrtSum(List<Integer> numbers) {
        double sum = 0;
        for (Integer value : numbers) {
            if (value < 0) {
                System.err.println(" Невозможно извлечь корень");
                System.exit(0);
            }
            sum += Math.sqrt((double) value);
        }
        return sum;
    }
}
