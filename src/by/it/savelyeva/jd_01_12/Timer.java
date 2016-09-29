package by.it.savelyeva.jd_01_12;
/**
 * Created by nato on 9/28/16.
 */
public class Timer {
	private long iniTime;
	private Double delta;
	
	public Timer() { this.iniTime = System.nanoTime(); }
	
	public String toString() {
		this.delta = (double) (System.nanoTime() - this.iniTime)/1000;
		iniTime = System.nanoTime(); 
		return "Elapsed time: " + this.delta.toString() + " microseconds";
	}
}
