package by.it.rudzko.jd01_15C;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String str=System.getProperty("user.dir");
        File f=new File(str);
        System.out.println(f);
        String s;
        while (!((s=new Scanner(System.in).nextLine()).trim().toLowerCase().equals("exit"))){
            StringBuilder sb=new StringBuilder();
            char[] c=s.toCharArray(); for (char value: c){if (value!=' ') sb.append(value);}
            switch (sb.toString()) {
                case "cd\\":
                    File ex=new File(f.getPath());
                    while (ex!=null){
                        f=ex;
                        ex=ex.getParentFile();
                    }
                    System.out.println(f);
                    break;
                case "cd..":
                    f=f.getParentFile();
                    System.out.println(f);
                    break;
                case "dir" :
                    Helper.printDir(f.listFiles());
                    break;
                default: if (sb.charAt(0)=='c'&&sb.charAt(1)=='d'){
                    String name=f.getPath()+"\\"+sb.delete(0,2).toString();
                    if (new File(name).exists()) {
                        f=new File(name);
                        System.out.println(f);
                    } else System.out.println(IMessage.NOPATH);
                }else System.out.println(IMessage.ERROR);
            }
        }

    }
}
