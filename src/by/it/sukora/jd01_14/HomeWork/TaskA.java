package by.it.sukora.jd01_14.HomeWork;


import java.io.*;
import java.util.ArrayList;

public class TaskA {
    private String dir;
    private String filename;

    public TaskA() {
        this.dir = System.getProperty("user.dir") + "/";
        this.filename = "randoms.bin";
    }

    public TaskA(String filename) {
        this.dir = System.getProperty("user.dir") + "/";
        this.filename = filename;
    }

    public TaskA(String dir, String filename) {
        this.dir = dir;
        this.filename = filename;
    }

    public ArrayList<Integer> generateArrayList(int count) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add((int) (count * Math.random()));
        }
        return list;
    }


    public double calculateAverage(ArrayList<Integer> list) {
        double res, sum = 0;
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            System.out.print(num + " ");
            sum += num;
        }
        res = sum / list.size();
        return res;
    }

    public File writeArrayListToBinaryFile(ArrayList<Integer> list) {
        File f = new File(this.dir + this.filename);
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream(f));
            for (int i = 0; i < list.size(); i++) {
                try {
                    dos.writeInt(list.get(i));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + this.dir + this.filename);
        } finally {
            if (dos != null)
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return f;
    }

    public ArrayList<Integer> readNumsFromBinaryFileToArrayList(File f) {
        ArrayList list = new ArrayList();
        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(f.getName())
                )
        )
        ) {
            while (dis.available() > 0) {
                int num = dis.readInt();
                list.add(num);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
