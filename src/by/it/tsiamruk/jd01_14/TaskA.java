package by.it.tsiamruk.jd01_14;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by waldemar on 02/10/2016.
 */
public class TaskA {
    static void taskA() {
        //создание перменных для занесения в файл.
        int[] variables = new int[20];
        for (int i = 0; i < variables.length; i++) {
            variables[i] = (int) (Math.floor(Math.random() * 1000));
        }
        //занесение в файл.
        try (FileOutputStream fos = new FileOutputStream("/Users/waldemartsiamruk/IdeaProjects/Students/JD2016-08-29v2/src/by/it/tsiamruk/jd01_14/data/text.txt");) {
            for (int variable : variables) {
                fos.write(variable);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден." + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода" + e.getMessage());
        }
        try (FileInputStream fis = new FileInputStream("/Users/waldemartsiamruk/test.txt")) {
            System.out.println("Размер файла: " + fis.available() + " байт(а)");
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer, 0, fis.available());
            System.out.print("Все Числа: ");
            for (byte aBuffer1 : buffer) {
                System.out.printf("%d ", (int) aBuffer1);
            }
            double average = 0;
            if (buffer.length > 0) {
                double sum = 0;
                for (byte aBuffer : buffer) {
                    sum += (int) aBuffer;
                }
                average = sum / buffer.length;
            }
            System.out.println("\nСредне арифметическое: " + average);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
