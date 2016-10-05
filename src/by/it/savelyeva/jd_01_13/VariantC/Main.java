package by.it.savelyeva.jd_01_13.VariantC;

/**
 Created by nato on 9/14/16.
 */

public class Main {
	public static void main(String[] args) {
		int[] years = new int[] {-5, 2, 3, 5};
		for (int i=0; i<years.length; i++) {
			try {
				NeuroSurgeon ns = new NeuroSurgeon("Nigel", 1983, years[i]);
			} catch (DoctorExperienceException e) {
				System.out.println(e.getMessage());
			}
		}

		for (int i=0; i<years.length; i++) {
			try {
				MilitaryNeuroSurgeon mns = new MilitaryNeuroSurgeon("Nigel", 1983, years[i], "Unit 1");
			} catch (DoctorExperienceException e) {
				System.out.println(e.getMessage());
			}
		}

		for (int i=0; i<years.length; i++) {
			try {
				AbdominalSurgeon as = new AbdominalSurgeon("Albert", 1990, years[i]);
			} catch (DoctorExperienceException e) {
				System.out.println(e.getMessage());
			}
		}

		/*
		try {
			jd0108Demo();
		} catch (DoctorExperienceException e) {
			System.out.println(e.getMessage());
		}
		*/
	}

	public static void printMethodSeparator() {
		System.out.println("---------------------------");
	}

	public static void jd0108Demo() throws DoctorExperienceException {
		Patient p1 = new Patient("Patricia", 1972);
		Patient p2 = new Patient("Peter", 1951);
		Patient[] patients = {p1, p2};

		/** The class 'NeuroSurgeon' (as well as 'AbdominalSurgeon' and 'MilitaryNeuroSurgeon') has its own constructor,
		 * which finally calls a constructor of the parent class 'Surgeon' using 'super'.
		 * When constructor of the parent class is called, this requires to choose between constructors and call one.
		 * Based on the constructor's signature, the corresponding constructor will be called.
		 * This selection was made at the compilation stage and is called 'early binding'.
		 */
		NeuroSurgeon ns = new NeuroSurgeon("Nigel", 1983, 5); // static polymorphism inside NeuroSurgeon() constructor.
		AbdominalSurgeon as = new AbdominalSurgeon("Albert", 1990, 2); // static polymorphism inside AbdominalSurgeon()

		System.out.println("======== Demo that methods work =======");
		for (Patient p: patients) {
			System.out.println("\nWORK WITH PATIENT " + p.name);
			ns.registerPatient(p);	printMethodSeparator(); // call a method that overrides the method in the superclass
			ns.diagnoseDesease(p);	printMethodSeparator(); // inheritance: call a method inherited from the superclass
			ns.performTreatment(p);	printMethodSeparator(); // call a method that overrides the method in the superclass
			ns.releasePatient(p);	printMethodSeparator(); // call a method which implements an abstract method of the superclass
			ns.consultPatient(p);	printMethodSeparator(); // static polymorphism
		}
		ns.makeReport(patients); printMethodSeparator(); // call a method that overrides the corresponding method in the superclass

		patients[0] = new Patient("Paul", 1998);
		patients[1] = new Patient("Paulina", 2002);

		for (Patient p: patients) {
			System.out.println("\nWORK WITH PATIENT " + p.name);
			as.registerPatient(p);	printMethodSeparator(); // inheritance: call a method inherited from the superclass
			as.diagnoseDesease(p);	printMethodSeparator(); // inheritance: call a method inherited from the superclass
			as.performTreatment(p); printMethodSeparator(); // inheritance: call a method inherited from the superclass
			as.releasePatient(p);	printMethodSeparator(); // call a method which implements an abstract method of the superclass
			as.consultPatient("Smoking shortens life"); printMethodSeparator(); // static polymorphism
		}
		as.makeReport(patients); printMethodSeparator(); // inheritance: call a method inherited from the superclass


		System.out.println("\n======== Demo of dynamic polymorphism =======");

		NeuroSurgeon mns = new MilitaryNeuroSurgeon("Michael", 1980, 2, "a1"); // static polymorphism inside constructor.
		//Note both 'ns' and 'mns' are of type 'NeuroSurgeon'

		ns.performTreatment(p1);  // NeuroSurgeon's method will be called ('nothing to do', because p1 is healthy now)
		mns.performTreatment(p2); // MilitaryNeuroSurgeon's method will be called ('nothing to do', because p2 is also healthy now)

		System.out.println("\n======== Demo of encapsulation =======");
		//System.out.println(((MilitaryNeuroSurgeon) mns).unit); // error, unit is not recognized, it is hidden from the object
		// We can work with unit value through public methods, e.g. getters & setters
		((MilitaryNeuroSurgeon) mns).setUnit("b2"); // 'a1' will be changed to 'b2'
		System.out.println("Unit 'a1' was changed to " + ((MilitaryNeuroSurgeon) mns).getUnit());

		System.out.println("\n======== Demo of static polymorphism =======");
		// based on methods' signatures corresponding methods will be called:
		ns.consultPatient(p1);
		ns.consultPatient("info");

		mns.consultPatient(p1);
		mns.consultPatient("info");
	}
}
