package by.it.savelyeva.jd_02_02.AutoParking;

/**
 * Created by nato on 10/17/16.
 */

public class Main {

	public static void main(String[] args) {
		int carsCount = 1;
		while (carsCount <= 10) {
			Thread thread = new Thread(new Car(carsCount));
			thread.start();
			carsCount++;
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("..................THE END....................");
	}

}
