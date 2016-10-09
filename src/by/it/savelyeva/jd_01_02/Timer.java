package by.it.savelyeva.jd_01_02;

/**
 * Created by nato on 10/9/16.
 */
public class Timer {
    private long iniTime;
    private Double delta;

    public Timer() { this.iniTime = System.nanoTime(); }

    public String toString() {
        this.delta = (double) (System.nanoTime() - this.iniTime)/1000;
        this.iniTime = System.nanoTime();
        return "Elapsed time: " + this.delta.toString() + " microseconds";
    }

}
