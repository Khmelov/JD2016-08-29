package by.it.tsiamruk.jd01_05;


import by.it.tsiamruk.jd01_05.math.*;

public class Main {
    public static void main(String[] args){
        //Task 1
        System.out.println(Task1.firstTaskPartByPart());
        System.out.println(Task1.firstTaskWholeExpression());
        System.out.println();
        //Task 2
        System.out.println(Task2.calculateFunction(0.21e2));
        System.out.println();
        //Task 3
        Task3.functionTabulation();
        System.out.println();
        //Task 4
        Task4.additionMulti();
        System.out.println();
        //Task 5
        Task5.functionCalculalation();
        System.out.println();
        //Task 6
        double[] a = Task6.newArray();
        Task6.showArray(a);
        System.out.println();
        Task6.evenIndexArray(a);
        System.out.println();
        Task6.newArray(a);

    }//end of main method
}//end of main class
