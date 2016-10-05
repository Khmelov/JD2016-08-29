package by.it.savelyeva.jd_01_14;
/**
 * Created by nato on 9/30/16.
 */
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TaskB {
	private String dir;
	private String filename;

	public TaskB() {
		this.dir = "";
		this.filename = "randoms.bin";
	}
	
	public TaskB(String subdir, String filename) {
		this.dir = System.getProperty("user.dir") + "/src/by/it/savelyeva/" + subdir;
		this.filename = filename;
	}
	
	public void printStatistics() {
		File f = new File(this.dir + this.filename);
		int ch = 0;
		int pCount = 0; // number of punctuation signs
		int wCount = 0; // number of words
		String puncts = ".!?,;:-";
		FileReader fr = null; 
		try {
			fr = new FileReader(f);
			do {
				//System.out.print((char) ch);
				while ((char)(ch) == ' ' && ch != -1) {
					ch = fr.read();					
				}
				if (puncts.indexOf(ch) != -1) {
					ch = fr.read();
					pCount++;
				} else {
					while ((char)(ch) != ' ' && puncts.indexOf(ch) == -1 && ch != -1) ch = fr.read();
					wCount++;
				}
			} while (ch != -1);
		} catch (IOException e) {
			System.out.println("File error: " + e);
		} finally {
			try {
				if (fr != null) fr.close();
			} catch (IOException e) {
				System.out.println("Error closing file " + this.filename);
			}
		}
		System.out.println("Punctuations count: " + pCount);
		System.out.println("Words count: " + wCount);
	}
}
