package by.it.grishechkin.jd01_15;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Yury on 24.10.2016.
 */
public class TaskA {

    public static List generateNumbers() {
        List <Integer> list = new ArrayList<>();
        Random r = new Random(System.currentTimeMillis());
        for (int i = 0; i < 16; i++) {
            Integer q = r.nextInt(31) - 15;
            list.add(q);
        }
        return list;
    }

    public static void writeMatrix(List <Integer> list) {
        String src = System.getProperty("user.dir") + "/src/by/it/grishechkin/";
        String filename = src + "jd01_15/matrix.txt";
        File file = new File(filename);

        for (int i = 0; i < 4; i++) {
            for (int j = i*4; j < i*4 + 4; j++) {
                System.out.printf("%3d ", list.get(j));
            }
            System.out.println();
        }

        try (PrintStream p = new PrintStream(new BufferedOutputStream
                (new FileOutputStream(file, false)))) {

            for (int i = 0; i < 4; i++) {
                for (int j = i*4; j < i*4 + 4; j++) {
                    p.printf("%3d ", list.get(j));
                }
                p.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
