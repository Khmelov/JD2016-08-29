package by.it.rudzko.jd01_14;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        String src=System.getProperty("user.dir")+"/src/by/it/rudzko/";
        String fname=src+"jd01_14/Attempt.txt";
        File f=new File(fname);
        DataOutputStream n=null;
        try{
            n=new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
            for (int i=0; i<20; i++){
                n.writeInt((int)(Math.random()*1000));
            }
            n.flush();
           }catch (FileNotFoundException e){
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println();
            e.printStackTrace();
        }

        String fn=src+"jd01_14/Text.txt";
        File f2=new File(fn);
        FileReader t=null;
        try {
            t=new FileReader(f2);
            int r=0;
            int sp=0;
            int s=0;
            while((r=t.read())!=-1){
                if((char)r==' ') sp++;
                if((char)r=='.' || (char)r==',' || (char)r=='!' ||  (char)r=='?' || (char)r==':' || (char)r==';' || (char)r=='-' ) s++;

            }
        System.out.println("Number of words in file: "+(sp+1));
        System.out.println("Number of punctuation characters in file: "+s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (n!=null){
                try {
                    n.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (t!=null){
                try {
                    t.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        String str=System.getProperty("user.dir");
        TaskC.printDir(str);
    }
}
