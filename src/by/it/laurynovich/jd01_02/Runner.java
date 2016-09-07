package by.it.laurynovich.jd01_02;

/*
1. Найти самое короткое и самое длинное число. Вывести найденные числа и
их длину.
 */

public class Runner {

    public static void main(String[] args) {
        System.out.println("введите числа через пробел.");

        String str= Utill.readFromConsole();
        int[] mas = Utill.getArrayInt( str );

        //till.printArray(mas);

        int shortNum = TaskA.getShortNum(mas);
        System.out.println("Short num = " +shortNum);
        System.out.println("Len num = " + String.valueOf(shortNum).length());

        int longNum = TaskA.getLongNum(mas);
        System.out.println("Long num = " + longNum);
        System.out.println("Len num = " + String.valueOf(longNum).length());

        int aver = TaskA.averageNum( mas );
        System.out.print("average = ");
        //System.out.printf( "%-6.2f ", aver );
        System.out.println(aver);

        System.out.println("числа меньшие среднего арифметичского: ");
        Utill.printAverage( mas, aver );

        for(int i : mas) {
            if (TaskA.diffChar( i )) {
                System.out.println( "Найдено число из разных цифр: " + i );
            }
        }

    }
}
