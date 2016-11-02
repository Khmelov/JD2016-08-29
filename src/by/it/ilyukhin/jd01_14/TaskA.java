package by.it.ilyukhin.jd01_14;


import java.io.*;

public class TaskA {
    static void writeToFile(String filePath) {
        try (DataOutputStream writer = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("numbers.dat"))))
        {
            for (int number = 0; number <= 20; number++) {
                writer.writeInt(number);
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
            return;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO error");
            return;
        }
    }

     static void readerOfFile(String filePath) {
        int sum=0;
        int count=0;
        try (DataInputStream reader = new DataInputStream(new BufferedInputStream(new FileInputStream(filePath))))
        {
            while(reader.available() > 0) {
                    int res = reader.readInt();
                    System.out.print(res+" ");
                    sum+=res;
                    count++;
                }
            System.out.print("Среднее арифметическое " + sum / count);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
            return;
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO error");
            return;
        }
    }
}

