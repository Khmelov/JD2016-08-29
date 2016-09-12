package by.it.savelyeva.jd_01_05.math;

/**
 * Created by nato on 9/7/16.
 */
public class Task6 {

    public static double[] createArray(double leftBoundX, double rightBoundX) {
        int count = (int) (20 + Math.floor(Math.random() * (40 - 20 + 1)));
        double[] m = new double[count];
        double x = leftBoundX;
        double deltaX = (rightBoundX - leftBoundX)/count;
        for (int i=0; i<count; i++) {
            m[i] = Math.log(Math.abs(x - 12));
            x += deltaX;
        }
        return m;
    }

    public static double[] createArrayFromArray(double[] array) {
        /**
         * This method creates a new array which consists of input array's elements with _indices_ % 3 == 0
         * (note: the task asked to form a new array which _elements_ % 3 == 0,
         * but we deal with array of doubles which contains no integer values in fact)
         */
        int count = (int) Math.floor(array.length / 3) + 1;
        double[] newArray = new double[count];
        for (int i=0, j=0; i<array.length; i += 3, j++) {
            newArray[j] = array[i];
            //System.out.println(i);
        }

        //System.out.println(end - start);
        return newArray;
    }

    public static double calculateAverageArraySlice(double[] array, int start, int end) {
        double sum = 0, avg;
        for (int i=start; i<end; i++) {
            sum += array[i];
            //System.out.println(i);
        }
        avg = sum / (end - start);
        //System.out.println(end - start);
        return avg;
    }

}
