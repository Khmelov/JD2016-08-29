package by.it.savelyeva.jd_02_02.Port;

/**
 * Created by nato on 10/17/16.
 */

public class Main {

	public static void main(String[] args) {
		int shipsCount = 1;
		while (shipsCount <= 5) {
			Ship ship = new Ship(shipsCount);
			ship.start();
			shipsCount++;
			try {
				ship.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("..................THE END....................");
	}


}
