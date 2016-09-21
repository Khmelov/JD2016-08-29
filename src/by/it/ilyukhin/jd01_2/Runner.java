package by.it.ilyukhin.jd01_2;


public class Runner {
    public static void main(String[] args) {
        String line = Util.getConsoleLine();
        int arr[] = Util.lineToIntArray(line);
        String max = TaskA.getMax(arr);
        System.out.println(max);
        String min = TaskA.getMin(arr);
        System.out.println(min);
        double mean = TaskA.mean(arr);
        System.out.println("Числа меньше " + mean + " таковы: ");
        for (int i : arr) {
            if (i < mean) {
                System.out.println(i + " ");

            }
        }
        System.out.println();
        for (int i : arr) {
            if (TaskA.uniqueDigits(i)) {
                System.out.println("Найдено число из разных цифр " + i);
                break;
            }
        }
        //TaskB1
        /*int interval = TaskB1.accessoryInterval();
        double matrix=TaskB1.massiveOut();*/
    }
}

