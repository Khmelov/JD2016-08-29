package by.it.savelyeva.jd_02_02.AutoParking;

/**
 * Created by nato on 10/17/16.
 */

public class Car implements Runnable {
	private static final int timeout = 0;
	private int number = 0;
	private boolean parked;
	
	public Car(int number) {
		this.number = number;
		this.parked = false;
	}
	
	@Override
	public String toString() {
		return "Car # " + this.number;
	}
	
	public void carArrive() {
		System.out.println(this + " arrived to parking.");
		int i = 1; // number of retries
		while (i < 5) {
			if (Parking.places < Parking.limitPlaces) {
				synchronized(Parking.monitorPlaces) {
					Parking.places++;
				}
				System.out.println(this + " is now parked.");
				carStay(200);
				break;
			} else {
				System.out.println(this + " is waiting for place - try � " + i);
				sleep(100);
				i++;
				if (i == 5) System.out.println(this + " went to another parking.");
			}
			
		}
	}
	
	public void carDepart() {
		if (this.parked) {
			synchronized(Parking.monitorPlaces) {
				Parking.places--;
			}
			System.out.println(this + " has left parking");
		}
	}

	private void sleep(int timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void carStay(int timeout) {
		this.parked = true;
		sleep(timeout);
	}
	
	@Override
	public void run() {
		carArrive();
		carDepart();
	}
}
