package by.it.savelyeva.jd_01_13.VariantC;

/**
 Created by nato on 9/14/16.
 */

public class AbdominalSurgeon extends Surgeon {
	/**
	 * To create 'Surgeon'-like objects we must inherit from the abstract class 'Surgeon' and implement
	 * the abstract method releasePatient().
	 * Constructor supplements functionality of the superclass.
	 * Abstract method 'releasePatient' of the superclass is implemented. 
	 */
	protected int years; //years of experience
	
	public AbdominalSurgeon(String name, int age, int years) throws DoctorExperienceException {
		/**
		 * For AbdominalSurgeons COMMON_DESEASES and COMMON_TREATMENTS are initialized by default.
		 */
		super(name, age);
		if (years < 0) {
			throw new DoctorExperienceException("Negative value as experience");
		} else if (years < 2){
			throw new DoctorExperienceException("Low experience");
		}
		this.years = years;
	}

	@Override
	public boolean releasePatient(Patient patient) {
		/**
		 * In the superclass this method is left abstract, so here we need to implement it.
		 */
		System.out.println("'AbdominalSurgeon.releasePatient': release the patient if ready.");
		if (patient.operated || !isPatientIll(patient)) return true; 
		return false;
	}
	
	// Suppose, other methods we are not going to override because they meet our requirements to the implementation.
}
