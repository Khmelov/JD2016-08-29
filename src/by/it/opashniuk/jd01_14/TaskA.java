package by.it.opashniuk.jd01_14;


import java.io.*;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) throws IOException {


        String filename="20 чисел";
        File f=new File(filename);

        DataOutputStream dos=null;
        try {
            dos = new DataOutputStream(new FileOutputStream(f));
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random()*2+3));
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("файла нет "+filename);
        }
        finally {
            if (dos!=null) {dos.close();}
        }




        try(DataInputStream inp=new DataInputStream(new BufferedInputStream(new FileInputStream("20 чисел"))))
        {
            double sum=0;
            double count=0;
            int i=0;
            while (inp.available()>0){
                i=inp.readInt();
                sum=sum+i;
                count++;
                System.out.println(i);
            }
            System.out.println("Среднее арифметическое = "+sum/count);

        }
        catch (IOException e)
        {
        e.printStackTrace();
        }
    }
}