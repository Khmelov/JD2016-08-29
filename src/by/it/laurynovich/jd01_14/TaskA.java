package by.it.laurynovich.jd01_14;

import java.io.*;

/**
 Записать в двоичный файл 20 случайных чисел. Прочитать записанный файл, распечатать числа и их среднее арифметическое.
 */
public class TaskA {

    private static String src = System.getProperty("user.dir") + "/src/by/it/laurynovich/jd01_14/file/";
    static String filename = src + "numbers.bin";
    static File file = new File(filename);

    protected static void createFile() throws IOException {
        DataOutputStream outStream = null;
        try {
            outStream = new DataOutputStream(new FileOutputStream(file));
            for (int i = 0; i < 20; i++) {
                outStream.writeInt((int) (Math.random() * 10 + 5));
            }
            System.out.println("Числа записаны в файл " + file);
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден " + filename);
        } finally {
            try {
                if (outStream != null) {
                    outStream.close();
                }
            } catch (IOException e) {
                System.err.println("Файл не закрыт " + e);
            }
        }
    }

    protected static void readFile() throws IOException {
        int sum = 0;
        int count = 0;
        try (DataInputStream inStream = new DataInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            while (inStream.available() > 0) {
                int number = inStream.readInt();
                //System.out.print(number + " ");
                sum += number;
                count++;
            }
            System.out.println("Среднее арифметическое = " + sum / count);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }

    }
}

