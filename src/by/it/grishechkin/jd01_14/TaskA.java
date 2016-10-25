package by.it.grishechkin.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yury on 24.10.2016.
 */
public class TaskA {

    public static File write() throws FileNotFoundException {
        String src = System.getProperty("user.dir") + "/src/by/it/grishechkin/";
        String filename = src + "jd01_14/text.txt";
        File file = new File(filename);
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(file);
            for (int i = 0; i < 20; i++) {
                Double num = Math.random()*10;
                String strnum = num.toString() + "\n";
                fos.write(strnum.getBytes());
            }
        }
        catch (FileNotFoundException e) {
            throw new FileNotFoundException("File not found");
        }
        catch (IOException e){
            System.err.println(e.getMessage());
        }
        finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    System.err.println("Ошибка закрытия");
                }
            }
        }
        return file;
    }

    public static List read(File file) throws FileNotFoundException {

        String line;
        List <Double> numbers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                numbers.add(Double.valueOf(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numbers;
    }

    public static void mean(List<Double> numbers) {

        Double rez = 0d;
        for (Double num : numbers) {
            rez += num;
        }
        rez /= numbers.size();
        System.out.println("Среднее арифметическое = " + rez);
    }
}
