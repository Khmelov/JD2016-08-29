package by.it.savelyeva.jd_01_14;
/**
 * Created by nato on 9/30/16.
 */
import java.io.File;
import java.io.StringWriter;

public class TaskC {
	private String dir;

	public TaskC() {
		this.dir = System.getProperty("user.dir");
	}
		
	public TaskC(String subdir) {
		this.dir = System.getProperty("user.dir") + subdir;
	}
	
	public void printFilesDirsSeparately() {
		File f = new File(this.dir);
		StringWriter dirs = new StringWriter();
		StringWriter files = new StringWriter();
		for (String name: f.list()) {
			if ((new File(this.dir + "/" + name)).isDirectory()) dirs.write(name + "\n");
			else if ((new File(this.dir + "/" + name)).isFile()) files.write(name + "\n");
		}
		System.out.printf("Directories of %s:\n", f.getAbsolutePath());
		System.out.println(dirs.toString());
		
		System.out.printf("Files of %s:\n", f.getAbsolutePath());
		System.out.println(files.toString());
	}
}
