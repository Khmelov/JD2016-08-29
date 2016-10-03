package by.it.tsiamruk.jd01_14;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by waldemar on 02/10/2016.
 */
public class TaskA {
    protected static void taskA() {
        //создание перменных для занесения в файл
        int[] variables = new int[20];
        for (int i = 0; i < variables.length; i++) {
            variables[i] = (int) (Math.floor(Math.random() * 1000));
        }
        //занесение в файл
        try (FileOutputStream fos = new FileOutputStream("/Users/waldemartsiamruk/test.txt");) {
            for (int i = 0; i < variables.length; i++) {
                fos.write(variables[i]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден." + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода" + e.getMessage());
        }
        //вывод из файла
        try (FileInputStream fis = new FileInputStream("/Users/waldemartsiamruk/test.txt")) {
            System.out.println("Размер файла: " + fis.available() + " байт(а)");
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer, 0, fis.available());
            System.out.print("Все Числа: ");
            for (int i = 0; i < buffer.length; i++) {
                System.out.printf("%d ", (int) buffer[i]);
            }
            double average = 0;
            if (buffer.length > 0) {
                double sum = 0;
                for (int i = 0; i < buffer.length; i++) {
                    sum += (int) buffer[i];
                }
                average = sum / buffer.length;
            }
            System.out.println("\nСредне арифметическое: " + average);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
