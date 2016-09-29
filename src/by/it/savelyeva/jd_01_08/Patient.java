package by.it.savelyeva.jd_01_08;

/**
 Created by nato on 9/14/16.
 */

public class Patient {
	/**
	 * We need this class to pass objects as arguments to methods of 'Surgeon'-like objects.
	 */
	public String name;
	public int year;
	public String diagnosis;
	public boolean operated;
	public String treatment;
	
	public Patient(String name, int year) {
		this.name = name;
		this.year = year;
		this.diagnosis = "";
		this.operated = false;
		this.treatment = "";
	}
}
