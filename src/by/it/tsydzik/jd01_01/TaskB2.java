package by.it.tsydzik.jd01_01;

/**
 * @author Eugene Tsydzik
 * @since 9/6/16.
 */
public class TaskB2 {

    public static void printMatrix(int endInterval) {
        int startInterval = 1;
        int sqrt = (int) Math.sqrt(endInterval);
        int count = 0;

        for (int row = 0; row < sqrt * sqrt; row++) {
            System.out.printf("[% -3d ] ", startInterval++);
            count++;
            if (count % sqrt == 0) {
                System.out.println();
            }
        }
    }

}
