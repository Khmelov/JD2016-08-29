package by.it.rudzko.jd01_15C;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author Olga Rudzko
 */
public class Helper {

    static void printDir(File[]ar){
        String dir;
        long l;

        for (File name: ar){
            StringBuilder sb=new StringBuilder();
            Path p=name.toPath();
            try {
                BasicFileAttributes at = Files.readAttributes(p, BasicFileAttributes.class);
                sb.append(at.creationTime().toString());
                sb.insert(10, ' ').deleteCharAt(11).delete(16, sb.length());
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (name.isDirectory()){
                dir="<DIR>";

                System.out.printf("%-20s%-17s%-20s", sb, dir, ("  "+name.getName()));
                System.out.println();
            }
            if (name.isFile()){
                l=name.length();
                System.out.printf("%-27s%10d%-20s", sb, l, ("  "+name.getName()));
                System.out.println();
            }

        }
    }

}
