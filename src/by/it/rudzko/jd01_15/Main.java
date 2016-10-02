package by.it.rudzko.jd01_15;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        int [][] x=new int[4][4];
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                x[i][j]=(int)(Math.random()*30-15);
            }
        }
        ToCons.printAr(x);
        ToFile.printAr(x);

        String src = System.getProperty("user.dir");
        src = src.concat("/src/by/it/rudzko/");
        File f = new File(src + "jd01_15/TaskB.java");
        StringBuilder sb=new StringBuilder();
        try{ sb=TaskB.readMe(f);
                  } catch (IOException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        InOutCode.codeToCons(sb);
        InOutCode.codeToFile(sb);
    }
}
