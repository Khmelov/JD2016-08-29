package by.it.laurynovich.jd01.jd01_15;

/**
 * Created by nadabratb on 11.10.2016.
 */
public class Main {
    public static void main(String[] args) {



        TaskA matr = new TaskA(4,-15,15);
        matr.matrixFile();
        matr.printMatrix();
        matr.printMatrix("src\\by\\it\\laurynovich\\jd01_15\\files\\writeMatrix.txt");


        Task15B.taskB();
    }
}
