package by.it.tsydzik.jd01_08;

import java.util.Arrays;

/**
 * Created by user on 19.09.2016.
 */
public abstract class Lamp implements ILightSource {

    private String[] producer;
    private int power;
    private int year;
    private boolean isLampOn = true;    // включена ли лампа

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Lamp{");
        sb.append("producer=").append(Arrays.toString(producer));
        sb.append(", power=").append(power);
        sb.append(", year=").append(year);
        sb.append(", isLampOn=").append(isLampOn);
        sb.append('}');
        return sb.toString();
    }

    public String[] getProducer() {
        return producer;
    }

    public void setProducer(String[] producer) {
        this.producer = producer;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isLampOn() {
        return isLampOn;
    }

    public void setLampOn(boolean lampOn) {
        isLampOn = lampOn;
    }

    public Lamp(String[] producer, int power, int year, boolean isLampOn) {

        this.producer = producer;
        this.power = power;
        this.year = year;
        this.isLampOn = isLampOn;
    }

}
