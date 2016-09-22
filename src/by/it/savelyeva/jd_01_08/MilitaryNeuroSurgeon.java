package by.it.savelyeva.jd_01_08;

/**
 * Created by nato on 9/21/16.
 */
public class MilitaryNeuroSurgeon extends NeuroSurgeon {

    private String unit; // Military Unit; private field, hidden from objects and class descendants.

    public void setUnit(String unit) { // setter for unit
        // TODO: check input before assign the value to the class field
        this.unit = unit;
    }

    public String getUnit() { // getter for unit
        return unit;
    }

    public MilitaryNeuroSurgeon(String name, int age, int years, String unit) {
        super(name, age, years);
        setUnit(unit);
    }

    @Override
    public void performTreatment(Patient patient) {
        /**
         * Let's completely override this method (without calling super.performTreatment()).
         */
        System.out.print("'MilitaryNeuroSurgeon.performTreatment': ");
        if (isPatientIll(patient) && !patient.operated) {
			System.out.println("Perform surgeon operation; register case in military documents.");
			patient.operated = true;
		} else System.out.println("Nothing to do.");
    }
    // Suppose, other methods we are not going to override because they meet our requirements to the implementation.
}
