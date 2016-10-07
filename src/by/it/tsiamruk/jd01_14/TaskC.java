package by.it.tsiamruk.jd01_14;

import java.io.File;

/**
 * Created by waldemar on 07/10/2016.
 */
public class TaskC {

    static String path() {
        return System.getProperty("user.dir");
    }

    static void ourlist(String path) {
        File list = new File(path);
        for (File dir : list.listFiles()) {
                if (dir.isDirectory()) {
                    System.out.printf("Catalog: %s\n", dir.getName());
                }
                if (dir.isFile()) {
                    System.out.printf("File: %s\n", dir.getName());
                }
        }

    }
}
