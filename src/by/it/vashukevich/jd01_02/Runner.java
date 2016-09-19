package by.it.vashukevich.jd01_02;

public class Runner {

    public static void main(String[] args) {
        // write your code here
        String str = Util.readFromConsole();
        //System.out.println("Test"+str);
        int mas[] = Util.getArrayInt(str);
        Util.printArray(mas);

        int shortNum = TaskA.getShotNum(mas);
        System.out.println("Shot num=" + shortNum);
        System.out.println("Shot len=" + String.valueOf(shortNum).length());

        int longNum = TaskA.getLongNum(mas);
        System.out.println("Long num=" + longNum);
        System.out.println("Long len=" + String.valueOf(longNum).length());

        int smaller = TaskA.getSmallerNum(mas);
        System.out.println("Числа меньше среднего :");
        for (int value : mas) {
            if (value < smaller) {
                System.out.print(value + " ");
            }
        }
        System.out.println();


        for (int value : mas) {
            if (TaskA.getDifNum(value)) {
                System.out.print("Найдено число из разных цифр : " +value);
                break;
            }
        }
    }
}
