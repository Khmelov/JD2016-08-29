package by.it.senchenko.jd01_05;

import static java.lang.Math.sqrt;

public class Main6 {
    public static void main(String[] args){
        int arrLength = 25;
        double[] array = new double[arrLength];
        for (double x = 12, j = 0; x < 77; x += 2.6, j += 1){
            array[(int)j] = sqrt(x/3+1);
            if (j == arrLength - 1) break;
        }

        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("Полученный массив: ");
        for (int i = 0; i < array.length; i++) {
                System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
                System.out.println(String.format("%-1s%-1s%-1s%2s%20s", "[", i, "]", "=", array[i]));
        }

        int count = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i]>=4 && array[i]<=5){
                count++;
            }
        }
        double[] newArray = new double[count];
        int index = 0;
        int zIndex =0;
        for (int i = 0; i < array.length; i++){
            if (array[i]>=4 && array[i]<=5){
                newArray[index] = array[i];
                index++;
                if (index%2==0){
                    zIndex++;
                }
            }
        }

        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("Массив от 4 до 5: ");
        for (int i = 0; i < newArray.length; i++) {
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println(String.format("%-1s%-1s%-1s%2s%20s", "[", i, "]", "=", newArray[i]));
        }
        System.out.println("Число четных индексов нового массива = "+zIndex);
    }
}
