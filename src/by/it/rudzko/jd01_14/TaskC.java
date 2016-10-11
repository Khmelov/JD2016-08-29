package by.it.rudzko.jd01_14;


import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class TaskC {
    public static void printDir(String address){
        File f=new File(address);
        String []a=f.list();
        List<String> files=new ArrayList<String>();
        List<String> folders=new ArrayList<String>();
        for(int i=0; i<a.length; i++) {
            
            if(new File(address+"\\"+a[i]).isFile())
                files.add(a[i]);
            else folders.add(a[i]);
            }
        System.out.println(address+" contains:\nfolders "+folders+"\nfiles "+files);
        }

}

