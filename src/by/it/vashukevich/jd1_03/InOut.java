package by.it.vashukevich.jd1_03;

import java.util.Scanner;


/*
 * Created by Admin on 03.09.16.
 */
public class InOut {
    static String consoleReadLine() {
        /*  InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader line = new BufferedReader(inputStreamReader);
            String out = line.readLine();
            line.close();
            return out;
            }
               */
        String line;
        Scanner scanner = new Scanner(System.in);
        line = scanner.nextLine();
        return line;
    }

    static double[] stringLineToInArray(String line) {
        line = line.trim();//удаляем пробелы в начале и в конце
        String[] linString = line.split(" ");//преобразование строки в массив
        int count = linString.length;//найдем длину массива
        double[] mas = new double[count];//создали массив для чисел
        for (int i = 0; i < count; i++) {
            mas[i] = Double.parseDouble(linString[i]);
        }
        return mas;
    }

    static void arrayPrint(double[] mas, String name, int cols) {
        int col = 0;
        for (int i = 0; i < mas.length; i++) {
            System.out.print(name);//печатаем имя массива
            System.out.printf("[% -3d]=%-4.1f", i, mas[i]);//печатаем знчения
            col++;
            if ((0 == col % cols)             //если конец колонки
                    || (mas.length - 1 == i)) {  //или конец массива
                System.out.println();//тогда напечатаем перевод строки
            }

        }
    }

    static void arrayPrint2D(double[][] mas, String name) {
        for (int i = 0; i < mas.length; i++) {      //перебираем строки массива
            for (int j = 0; j < mas[0].length; j++) {  //перебираем столбцы мссива
                System.out.printf(name + "[%1d,%1d]=%-6.1f", i, j, mas[i][j]);//печатаем имя массива
                System.out.println();
                }
            System.out.println();
            }
        }

    static double[][] inArrayPrint2D() {
        double [][]mass={
                {1,2,3,4,},
                {5,6,7,8,},
                {9,10,11,12}
        };
        return mass;
    }

    static void arrayPrint2D(double[][] mass) {
        for (int i = 0; i < mass.length; i++) {      //перебираем строки массива
            for (int j = 0; j < mass[0].length; j++) {  //перебираем столбцы мссива
                System.out.printf("%6.1f",mass[i][j]);//печатаем имя массива
                System.out.println();
            }
            System.out.println();
        }
    }
}

