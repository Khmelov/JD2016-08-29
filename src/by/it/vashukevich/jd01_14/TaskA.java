package by.it.vashukevich.jd01_14;

import java.io.*;

/**
 * Created by Admin on 02.10.16.
 */
public class TaskA {
    public static void main(String[] args) throws IOException {
        int sum = 0;
        int r;
        DataOutputStream random = null;
        try {
            random = new DataOutputStream(
                    new BufferedOutputStream(new FileOutputStream("random.dat")));
        } catch (FileNotFoundException e) {
            System.out.println("Файла нет");

        }
        for (int i = 0; i < 10; i++) {
            r = (int) (Math.random() *10);
            random.writeInt(r);
        }
        random.close();

        try {
            DataInputStream readRandom = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream("random.dat")));
            int count=0;
            int res=0;
            while (readRandom.available()>0) {
                res = readRandom.readInt();
                count++;
                sum=sum+res;
                System.out.printf("%3d",res);
            }
            System.out.println();
            System.out.println("Sum/2= "+sum/count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

