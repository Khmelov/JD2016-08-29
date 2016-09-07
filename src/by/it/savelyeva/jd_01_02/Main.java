package by.it.savelyeva.jd_01_02;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        String[] strArray = Util.readFromConsole();

        TaskA myTaskA = new TaskA();
        myTaskA.findShortestLongestNums(strArray);
        myTaskA.findNumsWithLengthLessAverage(strArray);
        myTaskA.findFirstNumDifferentDigits(strArray);


        TaskB myTaskB = new TaskB();
        Random randomGenerator = new Random();
        int k = randomGenerator.nextInt(100);
        int n = randomGenerator.nextInt(100) - 50;
        int m = 50 + randomGenerator.nextInt(100);
        myTaskB.isNumInRange(k, n, m);
        myTaskB.printNaturalNumsSquareMatrix(100);
        //String[] mas = {"1", "10", "-2"};
        //if (args.length == 3) mas = args;
        myTaskB.solveSquareEquation(Util.convertStringsToNums(args));
        myTaskB.printSelectedMonth();


        int[][] matrix = Util.buildSquareMatrix();
        TaskC myTaskC = new TaskC(matrix);
        myTaskC.getSumsBetweenTwoPositivesInRows();
        myTaskC.transposeMatrix();
        myTaskC.rotate90Matrix();
    }
}
