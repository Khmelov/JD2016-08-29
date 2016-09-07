package by.it.sukora.JD01_02;

/**
 * Created by stasi on 04.09.2016.
 */
public class Runner {
    public static void main(String[] args) {
       // String line= JD1_02.Util.getOneLine();
        String line="11 22 343 123 67 456 333 22 853";
        int arr[]= Util.LineToIntArray(line);
//1
        String max = TaskA.getMax(arr);
        System.out.print(max);
        String min = TaskA.getMin(arr);
        System.out.print(min);
        //2
        double mean=TaskA.mean(arr);
        System.out.print(mean);
        for(int i:arr)
        {
            if (i<mean)
                System.out.print(i+" ");
        }
        System.out.print("");

//3
        for(int i:arr)
        {
            if(TaskA.uniqueDigits(i))
            {
                System.out.print("Найдено число из разных чисел: "+i);
                break;
            }
        }
    }

}
