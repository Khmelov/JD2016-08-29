package by.it.emelyanov.jd01_14;

import java.io.File;

public class TaskC {
    static String src = System.getProperty("user.dir");
    static File file = new File(src);

    static void printCatalogAndFileList() {
        File[] fileList = file.listFiles();
        System.out.println("Список каталогов ");
        for (File element : fileList) {
            if (element.isDirectory()) {
                System.out.println(element.getName());
            }
        }
        System.out.println("Список файлов");
        for (File element : fileList) {
            if (element.isFile()) {
                System.out.println(element.getName());
            }
        }
    }
}
