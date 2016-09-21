package by.it.savelyeva.jd_01_08;
import java.util.Calendar;

/**
 Created by nato on 9/14/16.
 */

public class NeuroSurgeon extends Surgeon {

	protected int years; //years of experience
	
	public NeuroSurgeon(String name, int age, int years) {
		/**
		 * For NeuroSurgeons NEURO_DESEASES and NEURO_TREATMENTS are initialized (passed as arguments to the constructor of the superclass).
		 */
		super(name, age, Data.NEURO_DESEASES, Data.NEURO_TREATMENTS);
		this.years = years;
	}

	@Override
	public void registerPatient(Patient patient) {
		/**
		 * This method implements additional functionality after super.makeReport is called.
		 */
		super.registerPatient(patient);
		System.out.println("'NeuroSurgeon.registerPatient': additionally fills in specific fields in the patient card.");
	}
	
	@Override
	public StringBuilder makeReport(Patient[] patients) {
		/**
		 * Same as above, this method implements additional functionality after super.makeReport is called,
		 * in particular, we add a sign string to the end of report.
		 */
		super.makeReport(patients);
		int year = Calendar.getInstance().get(Calendar.YEAR);
		StringBuilder sb = new StringBuilder("'NeuroSurgeon.makeReport': signed by neurosurgeon " + 
					this.name + " of " + (year - this.age) + " years old and " + this.years + " years of experience.");
		System.out.println(sb.toString());
		return sb;
	}
	
	@Override
	public void performTreatment(Patient patient) {
		/**
		 * Let's completely override this method (without calling super.performTreatment()).
		 */
		System.out.print("'NeuroSurgeon.performTreatment':");
		if (isPatientIll(patient) && !patient.operated) {
			System.out.println("Switch on translation for TV program 'NeuroHeroes'; Perform surgeon operation; Switch off translation");
			patient.operated = true;
		} else System.out.println("Nothing to do, just make some notes in the personal blog for neurosurgeons.");
	}
	
	@Override
	public boolean releasePatient(Patient patient) {
		/**
		 * In the superclass this method is left abstract, so here we need to implement it.
		 */
		System.out.println("'NeuroSurgeon.releasePatient': release the patient if ready.");
		if (patient.operated) System.out.println("Patient was operated, need to stay in hospital next 2 weeks.");
		if (!isPatientIll(patient)) return true; 
		return false;
	}
	
	/**
	 *  Methods consultPatient(Patient), consultPatient(String), isPatientIll(), diagnoseDesease() are not overridden,
	 *  they are inherited and can be called on the object of this class.
	 */
	
}