package by.it.sukora.JD1_02;

/**
 * Created by stasi on 04.09.2016.
 */
public class Runner {
    public static void main(String[] args) {
       // String line= JD1_02.Util.getOneLine();
        String line="110 22 343 123 67 456 333 22 853";
        int arr[]= Util.LineToIntArray(line);
//1
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
        System.out.println("Task A");
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
       String max = TaskA.getMax(arr);
        System.out.println(max);
        System.out.println("-----------------------------------------");

        String min = TaskA.getMin(arr);
        System.out.println(min);
        System.out.println("-----------------------------------------");
        //2
        double mean=TaskA.mean(arr);
        System.out.println("Среднее арифметическое массива = "+mean);
        for(int i:arr)
        {
            if (i<mean)
                System.out.print(i+" ");
        }
        System.out.print(" ");

//3
        for(int i:arr)
        {
            if(TaskA.uniqueDigits(i))
            {
                System.out.println("Найдено число из разных чисел: "+i);
                System.out.println("-----------------------------------------");
                break;
            }
        }

        //Task B
        System.out.println("-----------------------------------------");
        System.out.println("Task B");
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
        int intervalGetting=TaskB.intervalGetting();
        System.out.println("-----------------------------------------");

        int masMas=TaskB.matrixOutput();
        System.out.println("-----------------------------------------");

        double uravnenieKvadratnoe=TaskB.uravnenie();
        System.out.println("-----------------------------------------");

        String monthesOfYear=TaskB.monthesOfYear();
        System.out.println("-----------------------------------------");



    }

}
