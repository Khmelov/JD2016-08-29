package by.it.senchenko.jd01_14;


import java.io.*;
import java.util.Random;

public class TaskA {
    public static void main(String[] args) throws IOException {
        String fileName = "D:\\JD2016-08-29\\src\\by\\it\\senchenko\\jd01_14\\bin";
        File file = new File(fileName);
        Random random = new Random();
        DataOutputStream dataOutputStream = null;
        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            for (int i = 0; i < 20; i++) {
                dataOutputStream.writeInt(random.nextInt(10));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файла нет: " + fileName);
        }finally {
            if (dataOutputStream != null)
                dataOutputStream.close();
        }

        try (DataInputStream dataInputStream=new DataInputStream
                (new BufferedInputStream
                        (new FileInputStream(fileName))
                )
        )
        {
            double sum=0;
            double count=0;
            while (dataInputStream.available()>0) {
                int i=dataInputStream.readInt();
                sum=sum+i;
                count++;
            }
            System.out.println("Среднее арифметическое равно: " + sum / count);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
