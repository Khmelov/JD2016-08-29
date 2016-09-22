package by.it.savelyeva.jd_01_08;
import java.util.Random;

/**
 Created by nato on 9/14/16.
 */

public abstract class Surgeon implements IDoctor {
	/**
	 * All methods from interface IDoctor are implemented, except 'releasePatient' which is still left abstract,
	 * descendant classes will need to implement it.
	 * Class contains two constructors - one will load default knowledge base, another one will take it as arguments.
	 */
	protected String name;
	protected int age;
	protected String[] deseases;
	protected String[] treatments;

	/** Below two methods are constructors - same name but different parameters.
	 * No static polymorphism here (i.e. at the time of class declaration), just method overloading.
	 * Static polymorphism will occur at the time of object creation.
	 */
	public Surgeon(String name, int age) { //one constructor
		this.name = name;
		this.age = age;
		this.deseases = Data.COMMON_DESEASES;
		this.treatments = Data.COMMON_TREATMENTS;
	}

	public Surgeon(String name, int age, String[] deseases, String[] treatments) { //another constructor
		this.name = name;
		this.age = age;
		this.deseases = deseases;
		this.treatments = treatments;
	}

	@Override
	public void registerPatient(Patient patient) {
		System.out.printf("'Surgeon.registerPatient': %s fills in a common patient card for patient %s\n",
							this.name, patient.name);
	}

	@Override
	public String diagnoseDesease(Patient patient) {
		String diagnosis = patient.diagnosis;
		System.out.print("'Surgeon.diagnoseDesease': ");
		if (diagnosis.compareTo("") == 0) {
			System.out.println("no diagnosis detected, observing patient and analyze blood & urine samples...");
			Random rnd = new Random();
			int index = rnd.nextInt(2); 
			diagnosis = deseases[index];
			patient.diagnosis = diagnosis;
			patient.treatment = treatments[index];
			System.out.printf("Diagnosed: %s\n", diagnosis);
		}
		else System.out.printf("Diagnosed (previously): %s\n", patient.diagnosis);
		return diagnosis;
	}

	@Override
	public boolean isPatientIll(Patient patient) {
		//System.out.println("'Surgeon.isPatientIll': check patient's diagnosis.");
		switch (patient.diagnosis) {
			case "": patient.diagnosis = diagnoseDesease(patient); // bad, should be done via setter,
																   // but for now field 'Patient.diagnosis' is left public.
			case "healthy": return false;
		}
		return true;
	}
	
	@Override
	public void performTreatment(Patient patient) {
		System.out.print("'Surgeon.performTreatment': ");
		if (isPatientIll(patient) && !patient.operated) {
			System.out.println("perform surgeon operation.");
			patient.operated = true;
		} else System.out.println("Nothing to do.");
	}

	@Override
	/**
	 * Method is left abstract, descendant classes will need to implement it.
	 */
	public abstract boolean releasePatient(Patient patient);

	@Override
	public StringBuilder consultPatient(Patient patient) {
		System.out.println("'Surgeon.consultPatient(patient)': counsult patient based on patient data.");
		StringBuilder sb = new StringBuilder("Consultation content");
		return sb;
	}

	/**
	 * Above method implements this method from interface IDoctor, and below method overloads it.
	 * Static polymorphism will occur when we call methods 'consultPatient' on an object.
	 */
	public StringBuilder consultPatient(String info) {
		System.out.println("'Surgeon.consultPatient(info)': create informative consultation.");
		StringBuilder sb = new StringBuilder("Consultation info");
		return sb;
	}

	@Override
	public StringBuilder makeReport(Patient[] patients) {
		System.out.println("'Surgeon.makeReport': create report for patients.");
		StringBuilder sb = new StringBuilder("REPORT:\n");
		for (Patient p: patients) {
			String operated = p.operated ? "done" : "not needed";
			String diagnosed = (p.diagnosis.compareTo("healthy") == 0) ? "no desease\n" : p.diagnosis + " diagnosed\n";
			String treatment = (p.diagnosis.compareTo("healthy") == 0) ? "" : p.treatment;
			sb.append("Treatment: " + p.treatment+ ", operation was " + operated + " for patient " + p.name + " who had " + diagnosed);
		}
		//System.out.println(sb.toString());
		return sb;
	}

}
