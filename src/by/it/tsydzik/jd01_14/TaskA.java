package by.it.tsydzik.jd01_14;

import java.io.*;
import java.util.ArrayList;

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
        ArrayList<Integer> list = new ArrayList<>();
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            dos = new DataOutputStream(bos);
            for (int i = 0; i < 20; i++) {
                int elem = (int) (Math.random() * 1000);
                list.add(elem);
                dos.writeInt(elem);
            }
            dos.flush();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println();
            e.printStackTrace();
        }

        System.out.println("The recorded number in the file:");
        int sumElem = 0;

        for (Integer elem : list) {
            sumElem += elem;
            System.out.print(elem + " ");
        }
        System.out.println("\nAverage elements = " + ((Number) (sumElem / 20)).doubleValue());
    }
}
