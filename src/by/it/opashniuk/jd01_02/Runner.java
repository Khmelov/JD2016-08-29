package by.it.opashniuk.jd01_02;

public class Runner {

    public static void main(String[] args) {
        String str = Util.readFromConsole();
        int mas[] = Util.getArrayInt(str);
        Util.printArray(mas);

        int shortNum = TaskA.getShortNum(mas);
        System.out.print("Short num=" + shortNum + " ");
        System.out.print("Short len=" + String.valueOf(shortNum).length() + " ");

        int longNum = TaskA.getLongNum(mas);
        System.out.print("Long num=" + longNum + " ");
        System.out.print("Long len=" + String.valueOf(longNum).length() + " ");

        double mean = TaskA.mean(mas);
        System.out.print("Числа меньше " + mean + " таковы ");
        for (int i : mas) {
            if (i < mean) {
                System.out.print(i + " ");
            }
        }
        System.out.println();


    for (int i:mas) {
        if(TaskA.variousLitter(i)) {
            System.out.print("Найдено число из разных цифр: "+i);
            break;
        }
    }

    }
}