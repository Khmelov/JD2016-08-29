package by.it.tsiamruk.jd01_14.TaskC;

import java.io.File;

/**
 * Created by waldemar on 03/10/2016.
 */
public class LScommand {
    //comment
    static void lsCommand(String s) {
        if (s.equals("ls")) {
            File file = new File("/Users/waldemartsiamruk/IdeaProjects/Students/JD2016-08-29v2");
            for (File dir : file.listFiles()) {
                if (!dir.getName().startsWith(".")) {
                    if (dir.isDirectory()) {
                        System.out.printf("Catalog: %s\n", dir.getName());
                        ;
                    }
                    if (dir.isFile()) {
                        System.out.printf("File: %s\n", dir.getName());
                    }
                }
            }
        }
    }
}
