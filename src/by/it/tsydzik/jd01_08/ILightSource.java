package by.it.tsydzik.jd01_08;

/**
 * Created by user on 19.09.2016.
 */
public interface ILightSource {

	void turnOnLight();                 // включить

	void turnOffLights();               // выключить

	void increaseCapacity(int delta);	// увеличить мощность

	void reduceCapacity(int delta);		// уменьшить мощность
}
