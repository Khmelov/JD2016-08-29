package by.it.tsydzik.jd01_08;

/**
 * @author Eugene Tsydzik
 * @since 9/19/16.
 */
public class Main {
	public static void main(String[] args) {

		TableLamp tableLamp = new TableLamp(false);
		tableLamp.turnOnLight();
		tableLamp.increaseCapacity();
		tableLamp.increaseCapacity(5);
		tableLamp.reduceCapacity();
		tableLamp.reduceCapacity(7);
		tableLamp.turnOffLights();
	}
}
