package by.it.artiuschik.jd_01_09;

import by.it.artiuschik.jd_01_09.mathlab.operations.Calculator;
import by.it.artiuschik.jd_01_09.mathlab.utils.PrintOperations;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        boolean working = true;
        while (working) {
            System.out.println("Введите выражение или end");
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            switch (str) {
                case "printvar": {
                    PrintOperations.printvar();
                    break;
                }
                case "sortvar": {
                    PrintOperations.sortvar();
                    break;
                }
                case "end": {
                    working = false;
                    break;
                }
                default: {
                    if (Calculator.calculate(str) != null) {
                        System.out.println(Calculator.calculate(str));
                    }

                    break;

                }

            }

        }
    }
}
