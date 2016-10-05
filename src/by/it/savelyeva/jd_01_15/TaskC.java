package by.it.savelyeva.jd_01_15;
/**
 * Created by nato on 9/30/16.
 */
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Formatter;
import java.util.Scanner;

public class TaskC {
	private String currPath = System.getProperty("user.dir");
	private String prevPath = "";
	
	private String readLineFromConsole() {
		return new Scanner(System.in).nextLine();
	}
	
	private String getFileDescription(File f) {
		String date = new Date(f.lastModified()).toString();
		String desc = f.isDirectory() ? "<DIR>" : ((Long)f.length()).toString();
		Formatter formatter = new Formatter();
		String res = formatter.format("%25s %10s %20s \n", date, desc, f.getName()).toString();
		formatter.close();
		return res;	
	}
	
	private void showCurrentPath() {
		System.out.println("Current path = " + this.currPath);
	}
	
	private String getNormPath(String partPath) {
		return Paths.get(partPath.trim()).normalize().toString();
	}

	private void displayDir(File f, boolean chdirback) {
		String res = "";
		if (f.isDirectory()) {
			for (String item: f.list()) {
				File fc = new File(this.currPath + "/" + item); 
				res += getFileDescription(fc);	
			}
		}
		else if (f.isFile()) {
			res = getFileDescription(f);
			this.currPath = this.prevPath;
		}
		System.out.println(res);
		if (chdirback) this.currPath = this.prevPath;
		showCurrentPath();
	}
	
	private void doCd(String path, boolean verbose) {		
		this.prevPath = this.currPath;
		Path tmp = Paths.get(this.currPath).resolve(path);
		File f = new File(tmp.toString());
		if (!f.exists()) System.out.println("Wrong path: " + tmp.toString());
		else {
			if (f.isFile() && verbose) {
				System.out.println("Cannot cd into a file, but you can type 'dir' to see its description.");
			}
			this.currPath = Paths.get(tmp.toString()).normalize().toString();
		}
		if (verbose) showCurrentPath();
	}
	
	public void cmdDirCd() {
		String line = "";
		while (line.compareTo("END") != 0) {
			line = readLineFromConsole();
			String[] parts = line.split(" ");
			String newPath = (parts.length<2) ? this.currPath : getNormPath(parts[1]);
			File f = new File(newPath);
			switch (parts[0].trim()) {
				case "cd":  if (parts.length>1) doCd(newPath, true); 
							else System.out.println("Nothing to do...\nBy the way, you are here: " + this.currPath);
							break;
				case "dir": if (parts.length>1) doCd(newPath, false); 
							displayDir(new File(this.currPath), parts.length>1); 
							break;
				case "END": System.out.println("Thank you! Bye!"); 
							break;
				default: System.out.println("Wrong command! Currently supported: cd [folder|file], dir [folder|file], END");
			}

		}
	}
}
