package by.it.rudzko.jd01_15;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class InOutCode {

    public static void codeToCons(StringBuilder a){
        a.insert(0, "01 ");
        int l = 2;
        Pattern p = Pattern.compile("\n(.)*\n");
        Matcher m = p.matcher(a);
        while (m.find()) {
            if(l>=10)
                a.insert(m.start()+1, Integer.toString(l)+" ");
            else{
               a.insert(m.start()+1, "0"+Integer.toString(l)+" ");
            }
            l++;
            m.reset();
        }

        System.out.println(a);

    }

    public static void codeToFile (StringBuilder a){
        String src=System.getProperty("user.dir")+"/src/by/it/rudzko/";
        String fname=src+"jd01_15/TaskB.txt";
        File f=new File(fname);
        PrintWriter n=null;
        try{
            n=new PrintWriter(new FileWriter(f, true));
            n.println(a);
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
