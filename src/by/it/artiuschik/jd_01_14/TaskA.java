package by.it.artiuschik.jd_01_14;

import java.io.*;

public class TaskA {
    public static void writeToFile(String filePath)
    {
        try(DataOutputStream writer=new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filePath))))
        {
            for (int i = 0; i <20; i++) {
                writer.writeInt((int)(Math.random()*21));
            }

        }
        catch(FileNotFoundException e)
        {
            System.out.print("File not found");
            return;
        } catch (IOException e) {
            System.out.println("Input-output error");
        }

    }
    public static void readFromFile(String filePath)
    {
        try(DataInputStream reader=new DataInputStream(new BufferedInputStream(new FileInputStream(filePath))))
        {
            int res;
            while(true)
            {
                try {
                    res = reader.readInt();
                    System.out.println(res+" ");
                }
                catch(EOFException e){
                    break;
                }
            }

        }
        catch(FileNotFoundException e)
        {
            System.out.print("File not found");
            return;
        } catch (IOException e) {
            System.out.println("Input-output error");
        }

    }
    public static void printArray(int[] arr)
    {

    }
}
