package by.it.artiuschik.jd_01_05;
import static java.lang.Math.*;

public class Runner {
    public static void main(String[]args)
    {
        //Task1
        System.out.println("Задание №1");
        double x=1.99;
        /*Запись полным выражением*/
        double res=(sin(pow((PI/6-1),2))+pow((3+pow(x,2)),1/4)-pow(log10(pow(x,3)-1),3))/(asin(x/2)-1.756*pow(10,-2));
        System.out.print("Task1 result=");
        System.out.printf("%-8.4f%n",res);
        /*Запись с разбивкой выражения на части*/
        double sinus=sin(pow((PI/6-1),2));
        double radical=pow((3+pow(x,2)),1/4);
        double logarifm=pow(log10(pow(x,3)-1),3);
        double znamenatel=asin(x/2)-1.756*pow(10,-2);
        System.out.print("Task1 result=");
        System.out.printf("%-8.4f%n",(sinus+radical-logarifm)/znamenatel);
        //Task2
        System.out.println("Задание №2");
        double a=0.3,b=-21.17;
        System.out.println("a="+a+" "+"b="+b);
        System.out.print("Task2 result=");
        System.out.printf("%-8.4f%n",Task2.calculateFunction(a,b));
        //Task3
        System.out.println("Задание №3");
        Task3.functionTabulation(3.67,0.2,0,2);
        //Task4
        System.out.println("Задание №4");
        System.out.print("Task 4 result=");
        System.out.printf("%-8.5f%n",Task4.calculateFunction(-5,12,3.75));
        //Task5
        System.out.println("Задание №5");
        double[][] mas=Task5.calculateFunction(-2,15,1.5,0.491*pow(10,4));
        System.out.print("Значения параметра p: ");
        Util.printArray(mas[1]);
        System.out.print("Значения функции y:   ");
        Util.printArray(mas[0]);
        //Task6
        System.out.println("Задание №6");
        double [] function=Task6.functionValues(-1.2,2.0);
        Util.printArray(function,"arcsinArr",4);
        System.out.println("Нечетные элементы массива:");
        Task6.printOddElements(function,"arcsinArr");
        System.out.println("Среднее геометрическое нечетных элементов: "+Task6.srednGeom(function));
        //Task7
        System.out.println("Задание №7");
        double[] K= Task7.function()[0];
        double[] T= Task7.function()[1];
        int colsK=Util.sizeOfTable(K)[1];
        int colsT=Util.sizeOfTable(T)[1];
        System.out.println("<Matrix K index to rows>");
        Util.printMatrixCols(colsK,"K", K,false);
        System.out.println("<Matrix T index to cols>");
        Util.printMatrixCols(colsT,"T",T,true);

    }
}
