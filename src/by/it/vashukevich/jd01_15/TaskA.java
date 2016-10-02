package by.it.vashukevich.jd01_15;

import java.io.*;

/**
 * Created by Admin on 30.09.16.
 */
public class TaskA {
    public static void matrix() {
        int a = 4;
        for (int i = 1; i <= 16; i++) {
            int b = (int) ((-15) + Math.random() * (15 - (-15) + 1));
            System.out.print(b + "\t");
            if (i % a == 0)
                System.out.println();
        }

        String fn = "D:\\Java\\JD2016-08-29\\JD2016-08-29\\src\\by\\it\\vashukevich\\jd01_15\\matrix.txt";

        try (PrintWriter f = new PrintWriter(new FileWriter(fn))) {
            for(int i=1;i<=16;i++){
                int b=(int)((-15)+Math.random()*(15-(-15)+1));
                f.printf("%3s",b);
                if(i%4==0)
                    f.println();
            }
        } catch (IOException e) {
            System.out.println("Ошибка файла: "+e);
            e.printStackTrace();
        }
    }
}


