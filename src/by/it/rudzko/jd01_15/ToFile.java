package by.it.rudzko.jd01_15;

import java.io.*;

/**
 * Created by Leta on 01.10.2016.
 */
public class ToFile {
    public static void printAr(int[][]a){
        String src=System.getProperty("user.dir")+"/src/by/it/rudzko/";
        String fname=src+"jd01_15/matrix.txt";
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
