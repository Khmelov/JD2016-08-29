package by.it.laurynovich.jd01_02;

/*
1. Найти самое короткое и самое длинное число. Вывести найденные числа и
их длину.
 */

import by.it.laurynovich.jd01_03.InOut;

public class Runner02 {

    public static void main(String[] args) {
//        System.out.println("введите числа через пробел.");
//
//        String str = Utill.readFromConsole();
//        int[] mas = Utill.getArrayInt( str );
//
//        Utill.printArray(mas);
//
//
//        int shortNum = TaskA.getShortNum(mas);
//        System.out.println("Short num = " +shortNum);
//        System.out.println("Len num = " + String.valueOf(shortNum).length());
//
//        int longNum = TaskA.getLongNum(mas);
//        System.out.println("Long num = " + longNum);
//        System.out.println("Len num = " + String.valueOf(longNum).length());
//
//        int aver = TaskA.averageNum( mas );
//        System.out.print("average = ");
//        //System.out.printf( "%-6.2f ", aver );
//        System.out.println(aver);
//
//        System.out.println("числа меньшие среднего арифметичского: ");
//        Utill.printAverage( mas, aver );
//
//        for(int i : mas) {
//            if (TaskA.diffChar( i )) {
//                System.out.println( "Найдено число из разных цифр: " + i );
//            }
//        }
//
//        // 1. Определить принадлежность некоторого значения k интервалу [n, m].
//        System.out.println();
//        System.out.println("введите 3 числа через пробел. (n m k)");
//        String a1 = Utill.readFromConsole();
//        int[] a = Utill.getArrayInt( a1 );
//        int n = a[0];
//        int m = a[1];
//        int k = a[2];
//        System.out.print("n = "+n);
//        System.out.print("  m = "+m);
//        System.out.println("  k = "+k);
//        boolean belong = TaskB.belongToInretval(n, m, k);
//        if (belong) {
//            System.out.print("k = " + k);
//            System.out.print(" принадлежит интервалу [" + n);
//            System.out.print("," + m);
//            System.out.println("].");
//        }
//        else {
//            System.out.print("k = " + k);
//            System.out.print(" не принадлежит интервалу [" + n);
//            System.out.print( "," + m);
//            System.out.println( "].");
//        }
//
//        //2. Вывести числа от 1 до k в виде матрицы N x N слева направо и сверху вниз
//        //(k выберите квадратом целого числа).
//        System.out.println("Введите натуральное число, являющееся квадратом целого числа");
//        String tempString = Utill.readFromConsole();
//        int  numMatrix = Integer.parseInt(tempString);
//        TaskB.printMatrixForm(numMatrix);
//
//        // 3. Найти корни квадратного уравнения. Параметры уравнения передавать с
//        // командной строкой.
//        System.out.println("Введите коэффициенты квадратного уравнения ax^2+bx+c=0 (a b c)");
//        String tempCoeff = Utill.readFromConsole();
//        System.out.println(tempCoeff);
//        double[] mas2 = Utill.getArrayDouble(tempCoeff);
//        //Utill.printArrayD(mas2);
//        double [] root = TaskB.findRoots(mas2);
//        System.out.println("Roots");
//        Utill.printArrayD(root);

//        System.out.println("Введите номер месяца");
//
//        String monStr = Utill.readFromConsole();
//        int month = Integer.parseInt(monStr);
//        TaskB.getMonth(month);
//        //System.out.println(monStr);

        System.out.println("Введите размерность матрицы n = ");
        String newString = Utill.readFromConsole();
        int r = Integer.parseInt(newString);
        double mTaskC[][] = TaskC.makeMatrix(r);
        by.it.laurynovich.jd01_04.InOut.printArr(mTaskC);

//        1. Найти сумму элементов матрицы, расположенных между первым и
//        вторым положительными элементами каждой строки.
        double [] masSum = TaskC.getSum(mTaskC);
        Utill.printArrayD(masSum);





    }
}
