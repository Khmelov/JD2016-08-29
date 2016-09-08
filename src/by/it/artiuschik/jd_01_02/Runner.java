package by.it.artiuschik.jd_01_02;
public class Runner {
    public static void main(String[] args) {
        String str = Util.readFromConsole();
        int mas[] = Util.getArrayInt(str);
        Util.printArray(mas);
        int shortNum = TaskA.getShortNum(mas);
        System.out.println("Short num=" + shortNum);
        System.out.println("Short len=" + String.valueOf(shortNum).length());
        int longNum = TaskA.getLongNum(mas);
        System.out.println("Long num=" + longNum);
        System.out.println("Short len=" + String.valueOf(longNum).length());
        double mean = TaskA.mean(mas);
        System.out.print("Чиcла, длина которых меньше " + mean + " таковы: ");
        for (int i : mas) {
            if (new Integer(i).toString().length() < mean) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        for (int i : mas) {
            if (TaskA.uniqueDigits(i)) {
                System.out.print("Найдено число из различных цифр: " + i);
                break;
            }
        }
        //Task B
        //1.
        System.out.print("Введите число k: ");
        int k = Integer.parseInt(Util.readFromConsole());
        System.out.print("Введите левую границу итервала: ");
        int n = Integer.parseInt(Util.readFromConsole());
        System.out.print("Введите правую границу итервала: ");
        int m = Integer.parseInt(Util.readFromConsole());
        if (TaskB.inInterval(k, n, m)) {
            System.out.println(k + " принадлежит [" + n + "," + m + "]");
        } else {
            System.out.println(k + " не принадлежит [" + n + "," + m + "]");
        }
        //2. Вывод матрицы
        System.out.print("Введите число k: ");
        k = Integer.parseInt(Util.readFromConsole());
        TaskB.printMatrix(Math.sqrt(k), k);
        //3.Найти корни квадраного уравнения
        double answers[] = TaskB.kvadrUravn(Double.parseDouble(args[0]), Double.parseDouble(args[1]), Double.parseDouble(args[2]));
        if (answers == null) {
            System.out.println("Корней нет");
        } else {
            System.out.println("Корни: ");
            for (int i = 0; i < answers.length; i++) {
                System.out.print(answers[i] + " ");
            }
        }
        //4. Вывести на консоль название мсяца соответствующего данному числу
        System.out.print("Введите число : ");
        k = Integer.parseInt(Util.readFromConsole());
        System.out.println(TaskB.whatMounth(k));
        //TaskC
        System.out.print("Введите число n-размерность матрицы: ");
        n = Integer.parseInt(Util.readFromConsole());//Ввод с консоли размерности матрицы
        int[][] matrix=TaskC.createMatrix(n);
        System.out.println("Исходная матрица");
        TaskC.printMatrix(matrix.length,matrix);
        /*1. Найти сумму элементов матрицы, расположенных между первым и вторым
         положительными элементами каждой строки
          */
        int sumOfElements=TaskC.sumOfElements(matrix,n);
        System.out.println("Cумма элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки: "+sumOfElements);
        /* 2. Транспонировать матрицу*/
        int[][] transpMatrix=TaskC.transponMatrix(matrix,matrix.length);
        System.out.println("Транспонированная матрица:");
        TaskC.printMatrix(transpMatrix.length,transpMatrix);
        /*3. Повернуть матрицу на 90 градусов против часовой стрелки*/
        int[][] rotatedMatrix=TaskC.rotate90(matrix,matrix.length);
        System.out.println("Матрица повернутая на 90 градусов против часовой стрелки:");
        TaskC.printMatrix(rotatedMatrix.length,rotatedMatrix);
        /*4. Построить матрицу вычитая из элементов строки ее среднее арифметическое*/
        double[][] newMatrix=TaskC.changeMatrix(matrix);
        System.out.println("Новая матрица:");
        TaskC.printMatrix(newMatrix.length,newMatrix);
        /*5. Удалить из матрицы сроки и столбцы содежащие минимальный элемент*/
        TaskC.printMatrix(matrix.length,matrix);
        System.out.println("Матрица после удаления элементов:");
        TaskC.printMatrix(TaskC.deleteRowsAndCols(matrix).length,TaskC.deleteRowsAndCols(matrix));
        /*6. Найти минимальный элемент и переместить его в позицию [1,1]
        путем перестановки строк и столбцов*/
        int [][] minMatrix=TaskC.moveMinElement(matrix,matrix.length);
        System.out.println("Матрица после перестановки минимального элемента:");
        TaskC.printMatrix(minMatrix.length,minMatrix);
        /*7. Преобразовать строки так, чтобы элементы равные 0
        располагались после всех остальных
         */
        int[][] changedMatrix=TaskC.moveZero(matrix,matrix.length);
        System.out.println("Матрица с нулями после всех остальных элементов:");
        TaskC.printMatrix(changedMatrix.length,changedMatrix);

    }
}
