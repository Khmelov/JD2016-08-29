package by.it.savelyeva.jd_01_workbook;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Task myTask = new Task();
        myTask.convertSeconds(1305512);


        int num = new Random().nextInt(100);
        int digit = 7;
        System.out.printf("Statement \"last digit of %d is %d\" is ", num, digit);
        System.out.println(myTask.checkLastDigitIsGivenValue(num, digit));


        int a = 1 + new Random().nextInt(10);
        int b = 1 + new Random().nextInt(10);
        int r = 1 + new Random().nextInt(6);
        System.out.printf("Statement \"rectangle %dx%d can be covered by a circle with r=%d\" is ", a, b, r);
        System.out.println(myTask.checkRectangleIsCoveredByCircle(a, b, r));


        System.out.println(myTask.addRoublesToAmount(num));


        System.out.println(myTask.printNextDate(31, 11, 2016));


        int n = new Random().nextInt(10);
        System.out.printf("%d! = ",n);
        System.out.println(myTask.countFactorial(n));


        int[] mas = new int[n];
        for (int i=0; i<n; i++) {
            mas[i] = new Random().nextInt(100);
            System.out.printf("%d ", mas[i]);
        }
        System.out.printf(" Max value is: %d; ", myTask.maxElementInArray(mas));
        System.out.printf(" Index of Max element is: %d.", myTask.maxElementIndexInArray(mas));
        System.out.println();


        System.out.printf("\"Statement %d is a simple number\" is ",n);
        System.out.println(myTask.numberIsSimple(n));


        System.out.printf("\"Statement %d is a simple number (using break)\" is ",n);
        System.out.println(myTask.numberIsSimpleUsingBreak(n));

        System.out.print("Reverted array: ");
        myTask.revertArray(mas);

    }

}

