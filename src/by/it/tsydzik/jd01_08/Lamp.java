package by.it.tsydzik.jd01_08;

import java.util.Arrays;

/**
 * Created by user on 19.09.2016.
 */
public abstract class Lamp implements ILightSource {

	private boolean isLampOn = false;

	private static final int MIN_CAPACITY = 0;
	private static final int MAX_CAPACITY = 100;
	private int capacity = 30;

	public Lamp(boolean isLampOn) {
		this.isLampOn = isLampOn;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Lamp{");
		sb.append("isLampOn=").append(isLampOn);
		sb.append(", capacity=").append(capacity);
		sb.append('}');
		return sb.toString();
	}

	@Override
	public void turnOnLight() {
		isLampOn = true;
	}

	@Override
	public void turnOffLights() {
		isLampOn = false;
	}

	boolean isLampOn() {
		return isLampOn;
	}

	public void increaseCapacity() {
		if (capacity < MAX_CAPACITY) {
			capacity++;
		}
	}

	@Override
	public void increaseCapacity(int delta) {
		if (capacity + delta <= MAX_CAPACITY) {
			capacity += delta;
		}
	}

	public void reduceCapacity() {
		if (capacity > MIN_CAPACITY) {
			capacity--;
		}
	}

	@Override
	public void reduceCapacity(int delta) {
		if (capacity - delta >= MIN_CAPACITY) {
			capacity -= delta;
		}
	}
}
