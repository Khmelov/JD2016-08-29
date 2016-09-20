package by.it.tsydzik.jd01_08;

/**
 * Created by user on 19.09.2016.
 */
public class TableLamp extends Lamp {

	public TableLamp(boolean isLampOn) {
		super(isLampOn);
	}

	@Override
	public void turnOnLight() {
		super.turnOnLight();
		System.out.println("Turning on table lamp");
	}

	@Override
	public void turnOffLights() {
		super.turnOffLights();
		System.out.println("Turning off table lamp");
	}

	@Override
	public void increaseCapacity() {
		super.increaseCapacity();
		System.out.println("IncreaseCapacity of table lamp");
	}

	@Override
	public void reduceCapacity() {
		super.reduceCapacity();
		System.out.println("Reduce of table lamp");
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("TableLamp{");
		sb.append(", isLampOn=").append(isLampOn());
		sb.append('}');
		return sb.toString();
	}

}
