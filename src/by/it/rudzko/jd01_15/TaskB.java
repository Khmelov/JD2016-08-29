package by.it.rudzko.jd01_15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    /**
     * @author Olga Rudzko
     * @param file is a file that should be printed
     * @return void
     * @throws IOException
     */
    public static StringBuilder readMe(File file) throws IOException{
        StringBuilder sb=new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line+"\n");
        }

        //deleting JavaDoc and comments

        Pattern p=Pattern.compile("/\\*(.|\\n)+\\*/\\n");
        Pattern p2=Pattern.compile("//(.)+\\n");
        Matcher m=p.matcher(sb);
        int pos=0;
        while (m.find(pos)){
            sb.delete(m.start(),m.end());
            pos=m.start();

        }
        Matcher m2=p2.matcher(sb);
        int pos2=0;
        while (m2.find(pos2)){
            sb.delete(m2.start(),m2.end());
            pos2=m2.start();

        }
        return sb;
    }
}


