package by.it.sukora.JD1_05;

import by.it.sukora.JD1_05.Math.*;

/**
 * Created by stasi on 05.09.2016.
 */
public class Main {

    public static void main(String[] args) {
        //задача 1
        System.out.println("----------------------------------------------------");
        System.out.println("Task 1");
        System.out.println("----------------------------------------------------");
        Task1.T1_1();
        System.out.println("----------------------------------------------------");
        System.out.println("Task 1_2");
        Task1.T1_2();
        //задача 2
        double x= 2.57*Math.pow(10,3);
        double f = 0.873;
        System.out.println("----------------------------------------------------");
        System.out.println("Task 2");
        System.out.println("----------------------------------------------------");
       System.out.println(Task2.Yravnenie(x,f));
        System.out.println("----------------------------------------------------");
        //задача 3
        System.out.println("----------------------------------------------------");
        System.out.println("Task 3");
        System.out.println("----------------------------------------------------");
        Task3.printTable();
        //задача 4
        System.out.println("----------------------------------------------------");
        System.out.println("Task 4");
        System.out.println("----------------------------------------------------");
        System.out.println(Task4.yravnenie(2.408));
        //задача 5
        System.out.println("----------------------------------------------------");
        System.out.println("Task 5");
        System.out.println("----------------------------------------------------");
        Task5.yravnenie(0.491*Math.pow(10,4));
        System.out.println("----------------------------------------------------");
        //задача 6
        System.out.println("----------------------------------------------------");
        System.out.println("Task 6");
        System.out.println("----------------------------------------------------");
        double a[] = Task6.getArray();
        Task6 task6 = new Task6();
        task6.printArray(a, "testname", true);
        double b[] = task6.getEveryThirdElement(a);
        task6.printArray(b, "array", true);
        System.out.println("----------------------------------------------------");
        //number 7
        System.out.println("----------------------------------------------------");
        System.out.println("Task 7");
        System.out.println("----------------------------------------------------");
        double[] K= Task7.function()[0];
        double[] T= Task7.function()[1];
        int colsK=Task7.sizeOfTable(K)[1];
        int colsT=Task7.sizeOfTable(T)[1];
        System.out.println("Матрица по строкам");
        Task7.printMatrixCols(colsK,"M", K,false);
        System.out.println("Матрица по столбцам");
        Task7.printMatrixCols(colsT,"K",T,true);
        System.out.println("----------------------------------------------------");
    }

}
