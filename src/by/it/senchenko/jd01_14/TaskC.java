package by.it.senchenko.jd01_14;

import java.io.File;


public class TaskC {
    public static void main(String[] args) throws NullPointerException {
        File file = new File(System.getProperty("user.dir"));
        System.out.println("Список каталогов:");
        for (File f:file.listFiles()) {
            if (f.isDirectory()){
                System.out.println(f.getName());
            }
        }
        System.out.println("Список файлов:");
        for (File f:file.listFiles()) {
            if (f.isFile()) {
                System.out.println(f.getName());
            }
        }
    }
}
