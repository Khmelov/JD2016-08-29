package by.it.tsydzik.jd01_14;

import java.io.*;

/**
 * @author Eugene Tsydzik
 * @since 12.10.16.
 */
public class TaskA {
    public static void taskA() {
        String src = System.getProperty("user.dir") + "/src/by/it/tsydzik/";
        String fileName = src + "jd01_14/Result.txt";
        File file = new File(fileName);
        DataOutputStream dos = null;
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            dos = new DataOutputStream(bos);
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 1000));
            }
            dos.flush();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println();
            e.printStackTrace();
        }


    }
}
