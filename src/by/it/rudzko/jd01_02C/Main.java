package by.it.rudzko.jd01_02C;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println(IMessages.HELLO);
        String s = new Scanner(System.in).nextLine();
        int[][] matrix = new int[Integer.parseInt(s)][Integer.parseInt(s)];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = (int) (Math.random() * (Integer.parseInt(s) * 2) - Integer.parseInt(s));
            }
        }
        System.out.println(IMessages.MATRIX);
        InOut.printAr(matrix);
        System.out.println(IMessages.T1);
        Helper.task1(matrix);
        System.out.println(IMessages.T2);
        int[][] next = Helper.task2(matrix);
        InOut.printAr(next);
        System.out.println(IMessages.T3);
        InOut.printAr(Helper.task3(next));
        System.out.println(IMessages.T4);
        InOut.printAr(Helper.task4(matrix));
        System.out.println(IMessages.T5);
        InOut.printAr(Helper.task5(matrix));
        System.out.println(IMessages.T6);
        InOut.printAr(Helper.task6(matrix));
        System.out.println(IMessages.T7);
        InOut.printAr(Helper.task7(matrix));
    }
}
