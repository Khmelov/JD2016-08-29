package by.it.sukora.jd01_15.HomeWork;

import java.io.*;

public class TaskA {
    public static void main(String[] args) {
        int [][] x=new int[4][4];
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                x[i][j]=(int)(Math.random()*30-15);
            }
        }
        printAr1(x);
        printAr2(x);

    }
    public static void printAr1(int[][]a){
        for (int i=0; i<a.length; i++){
            for (int j=0; j<a[0].length; j++){
                System.out.printf("%3d", a[i][j]);
                if (j!=a[0].length-1) System.out.print(" ");
                else System.out.print("\n");
            }
        }
    }
    public static void printAr2(int[][]a){
        String src=System.getProperty("user.dir")+"/src/by/it/sukora/";
        String fname=src+"jd01_15/HomeWork/mat.txt";
        File f=new File(fname);
        PrintWriter n=null;
        try{
            n=new PrintWriter(new FileWriter(f, true));
            for (int i=0; i<4; i++){
                for (int j=0; j<4; j++){
                    n.printf("%3d", a[i][j]);
                    if (j!=3) System.out.print(" ");
                    else n.print("\n");
                }
            }
            n.flush();
        }catch (FileNotFoundException e){
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println();
            e.printStackTrace();
        }

        finally {
            if (n != null)
                n.close();
        }
    }
}
