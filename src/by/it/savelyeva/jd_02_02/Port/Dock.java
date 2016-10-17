package by.it.savelyeva.jd_02_02.Port;

/**
 * Created by nato on 10/17/16.
 */

public class Dock implements Runnable {

	@Override
	public void run() {
        while (QueueShips.needService()) {
            Ship ship = QueueShips.extract();
            System.out.println("Start service of " + ship);
            Helper.sleep(250);
            System.out.println("Stop service of " + ship);
            synchronized (ship) {
                ship.notify();
            }
        }
        System.out.println("Dock stop");
        synchronized (Port.monitorDocks){
            Port.docksCount--;
        }
	}
}
