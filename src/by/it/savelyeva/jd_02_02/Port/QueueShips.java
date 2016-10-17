package by.it.savelyeva.jd_02_02.Port;

/**
 * Created by nato on 10/17/16.
 */

import java.util.ArrayDeque;

public class QueueShips {
	static final Integer monitorQueueShips = 0;
    private static ArrayDeque<Ship> queue = new ArrayDeque<>();

    public static void add(Ship ship) {
        queue.addLast(ship);
        if (Port.docksCount < Port.dockLimit) {
            synchronized (Port.monitorDocks) {
                new Thread(new Dock()).start();
                Port.docksCount++;
            }
        }
    }

    static Ship extract() {
        synchronized (monitorQueueShips) {
            Ship ship = queue.pollFirst();
        	return ship;
        }
    }

    static boolean needService() {
        synchronized (monitorQueueShips) {
        	return !queue.isEmpty();
        }
    }
}
