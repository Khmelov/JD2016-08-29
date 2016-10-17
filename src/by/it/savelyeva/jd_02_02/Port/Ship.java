package by.it.savelyeva.jd_02_02.Port;

/**
 * Created by nato on 10/17/16.
 */

public class Ship extends Thread {
	private int number;
	private int contLimit;
	private int contNow;
	private int contToLoad;
	private int contToUnload;
	
	public Ship(int number) {
		this.number = number;
		this.contLimit = 1 + Helper.rnd(10);
		this.contNow = Helper.rnd(this.contLimit);
		this.contToUnload = Helper.rnd(this.contNow);
		this.contToLoad = Helper.rnd(this.contLimit - this.contNow);
		System.out.println("INFO of " + this 
				+ ": limit = " + this.contLimit 
				+ "; count = " + this.contNow 
				+ "; unload: " + this.contToUnload 
				+ "; load = " + this.contToLoad);
	}

	@Override
	public String toString() {
		return "Ship # " + this.number;
	}
	public void shipWait() {
	    synchronized (this) {
	       try {
	            this.wait();
	       } catch (InterruptedException e) {
	           e.printStackTrace();
	       }
	   }
	}
	public void arrive() { // go to Queue
		System.out.println(this + " arrived.");
	    synchronized (QueueShips.monitorQueueShips) {
	        QueueShips.add(this);
	        System.out.println(this + " added to QueueShips");
	    }
	    //shipWait();
    }
	
	public void unload() {
		System.out.println("Start Unloading of " + this);
		while (this.contToUnload > 0) {
			
				synchronized(Port.monitorContainers) {if (Port.containersCount < Port.containersLimit) {
					Helper.sleep(200);
					Port.containersCount++;
					this.contNow--;
					this.contToUnload--;
					
					System.out.println("Unloading of " + this + ": remaining " + this.contToUnload + " to unload.");
					printPort();
					
				} else shipWait();
			}
		}
		System.out.println("Completed Unloading of " + this);
	}
	
	public void load() {
		System.out.println("Loading " + this);
		while (this.contToLoad > 0) {

				synchronized(Port.monitorContainers) {			if (Port.containersCount > 1) {
					Helper.sleep(200);
					Port.containersCount--;
					this.contNow++;
					this.contToLoad--;
					System.out.println("Loading of " + this + ": remaining " + this.contToLoad + " to load.");
					printPort();
					
				} else shipWait();
			}
		}
		System.out.println("Completed Loading of " + this);
	}
	
	public void depart() {
		System.out.println(this + " departured.");
	}
	
	@Override
	public void run() {
		arrive();
		unload();
		load();
		depart();
	}
	public void printPort() {
		System.out.println("Port: available places = " + (Port.containersLimit - Port.containersCount) + "; currently: " + Port.containersCount + " containers.");
	}
}
