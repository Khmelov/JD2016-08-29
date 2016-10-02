package by.it.emelyanov.jd01_14;

import java.io.*;

public class TaskA {
    private static String src = System.getProperty("user.dir") + "/src/by/it/emelyanov/jd01_14/data/";
    static String filename = src + "numbers.dat";
    static File file = new File(filename);

    static void createFileWith20Numbs() throws IOException {
        DataOutputStream outStream = null;
        try {
            outStream = new DataOutputStream(new FileOutputStream(file));
            for (int i = 0; i < 20; i++) {
                outStream.writeInt((int) (Math.random() * 10 + 1));
            }
            System.out.println("Осуществлена запись чисел " + file);
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден " + filename);
        } finally {
            try {
                if (outStream != null) {
                    outStream.close();
                }
            } catch (IOException e) {
                System.err.println("Ошибка закрытия " + e);
            }
        }
    }

    static void readFileWith20Numbs() throws IOException {
        int sum = 0;
        int count = 0;
        try (DataInputStream inStream =
                     new DataInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            while (inStream.available() > 0) {
                int number = inStream.readInt();
                System.out.print(number + " ");
                sum += number;
                count++;
            }
            System.out.println("Среднее арифметическое " + sum / count);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }

    }


}
