package by.it.tsydzik.jd01_01;

/**
 * Created by User on 31.08.2016.
 */
public class TaskA2 {

    public static void getAverage(int[] array) {
        int sum = 0;
        for (int elem : array) {
            sum += elem;
        }
        int average = sum/array.length;

        System.out.println("Average = " + average);
        System.out.println("Числа меньше " + average + ":");

        for (int elem : array) {
            if (average > Integer.toString(elem).length()){
                System.out.println(elem);
            }
        }
    }
}
