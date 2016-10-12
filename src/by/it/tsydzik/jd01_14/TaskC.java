package by.it.tsydzik.jd01_14;

import java.io.File;
import java.io.StringWriter;

/**
 * @author Eugene Tsydzik
 * @since 12.10.16.
 */
public class TaskC {
    public static void taskC() {
        String address = System.getProperty("user.dir");
        File file = new File(address);
        StringWriter dirs = new StringWriter();
        StringWriter files = new StringWriter();
        for (String name : file.list()) {
            if ((new File(address + "/" + name)).isDirectory()) {
                dirs.write(name + "\n");
            } else if ((new File(address + "/" + name)).isFile()) {
                files.write(name + "\n");
            }
        }

        System.out.println(address + " contains: ");
        System.out.println("Folders: \n" + dirs.toString());
        System.out.println("Files: \n" + files.toString());
    }
}
