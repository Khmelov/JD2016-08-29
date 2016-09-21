package by.it.savelyeva.jd_01_08;

/**
 Created by nato on 9/14/16.
 */

public interface IDoctor {

	void registerPatient(Patient patient);

	String diagnoseDesease(Patient patient);

	boolean isPatientIll(Patient patient);

	void performTreatment(Patient patient);

	boolean releasePatient(Patient patient);

	StringBuilder consultPatient(Patient patient);

	StringBuilder makeReport(Patient[] patients);
}
