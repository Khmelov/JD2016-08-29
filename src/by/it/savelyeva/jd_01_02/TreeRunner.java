package by.it.savelyeva.jd_01_02;

import java.util.Arrays;

/**
 * Created by nato on 10/9/16.
 */
public class TreeRunner {
    private static double[] sortBubble(double[] array) {
        for (int i=0; i<array.length; i++) {
            for (int j=1; j<array.length-i;j++) {
                if (array[j-1] > array[j]) {
                    double tmp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = tmp;
                }
            }
        }
        return array;
    }

    private static double[] sortBubbleBetter(double[] array) {
        boolean swap;
        do {
            swap = false;
            for (int i=0; i<array.length-1; i++) {
                if (array[i] > array[i+1]) {
                    double tmp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = tmp;
                    swap = true;
                }
            }
        } while (swap);
        return array;
    }

    private static void printArray(double[] array) {
        for (int i=0; i<array.length; i++) {
            System.out.printf("%.0f ", array[i]);
        }
        System.out.println();
    }

    public static void main(String args[]) {
        // all 4 below arrays will have same values (to meet same conditions for each sort type)
        double[] array1 = new double[100]; // for demo of tree sort
        double[] array2 = new double[100]; // for demo of bubble sort
        double[] array3 = new double[100]; // for demo of improved bubble sort
        double[] array4 = new double[100]; // for demo of Arrays.sort()

        Timer timer;
        Tree myTree;
        System.out.println("Input array:");
        for (int i=0; i<array1.length; i++) {
            int rnd = (int) Math.round(Math.random() * 100);
            array1[i] = rnd;
            array2[i] = rnd;
            array3[i] = rnd;
            array4[i] = rnd;
            System.out.printf("%.0f ", array1[i]);
        }
        System.out.println();

        System.out.println("Array sorted with the help of a binary tree (create time + traverse time):");
        timer = new Timer();
        myTree = new Tree(array1[0]);  // create a tree with a key
        for (int i=1; i<array1.length; i++) {
            myTree.insert(new Tree(array1[i]));  // subtree joins
        }
        myTree.traverseAndPrint(); // here we just go through all nodes in the tree "in a sorted way"
        System.out.println();
        System.out.println(timer);
        System.out.println("Array sorted with the help of a binary tree (only traverse time):");
        timer = new Timer();
        myTree.traverseAndPrint();
        System.out.println();
        System.out.println(timer);


        System.out.println("Array sorted with the help of bubble sort:");
        timer = new Timer();
        sortBubble(array2);
        printArray(array2); // this is included to time because traverseAndPrint() does printing
        System.out.println(timer);

        System.out.println("Array sorted with the help of IMPROVED bubble sort:");
        timer = new Timer();
        sortBubbleBetter(array3);
        printArray(array3); // this is included to time because traverseAndPrint() does printing
        System.out.println(timer);

        System.out.println("Array sorted with the help of Arrays.sort() method:");
        timer = new Timer();
        Arrays.sort(array4);
        printArray(array4);
        System.out.println(timer);
    }
}
