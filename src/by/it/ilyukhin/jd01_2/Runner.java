package by.it.ilyukhin.jd01_2;


public class Runner {
    public static void main(String[] args) {
        //TaskA
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

        //TaskB
        int interval = TaskB.accessoryInterval(5,13,78);//Принадлежность интервалу
        double matrix=TaskB.massiveOut(3,81);//Вывод массива
        double equation = TaskB.quadraticEquation(1, 2, 1);//Решение квадратного уравнения
        int months=TaskB.Months(15);


    }
}


