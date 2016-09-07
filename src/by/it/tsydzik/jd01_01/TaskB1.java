package by.it.tsydzik.jd01_01;

/**
 * @author Eugene Tsydzik
 * @since 9/6/16.
 */
public class TaskB1 {
    public static boolean isBelongs(int number, int startInterval, int endInterval) {

        if (startInterval > endInterval) {
            startInterval = startInterval + endInterval - (endInterval = startInterval);
        }
        if (number > startInterval && number < endInterval) {
            return true;
        }
        return false;
    }
}
