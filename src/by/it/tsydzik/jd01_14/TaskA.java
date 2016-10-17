package by.it.tsydzik.jd01_14;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Eugene Tsydzik
 * @since 12.10.16.
 */
public class TaskA {
    public static void taskA() {
        String src = System.getProperty("user.dir") + "/src/by/it/tsydzik/";
        String fileName = src + "jd01_14/result.bin";
        File file = new File(fileName);
        DataOutputStream dos = null;
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            dos = new DataOutputStream(bos);
            for (int i = 0; i < 20; i++) {
                int elem = (int) (Math.random() * 100);
                dos.writeInt(elem);
            }
            dos.flush();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println();
            e.printStackTrace();
        }
        readFromFile(fileName);
    }

    public static void readFromFile(String fileName) {
        try (DataInputStream inp = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName))
        )) {
            double sum = 0;
            double count = 0;
            int elem = 0;
            ArrayList<Integer> list = new ArrayList<>();
            while (inp.available() > 0) {
                elem = inp.readInt();
                list.add(elem);
                sum += elem;
                count++;
            }
            System.out.println("The recorded number in the file:");
            printArray(list);
            Collections.sort(list);
            System.out.println("\nSorted array");
            printArray(list);
            System.out.println("\nAverage: " + sum / count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printArray(ArrayList<Integer> list) {
        for (Integer elem : list) {
            System.out.print(elem + " ");
        }
    }
}
