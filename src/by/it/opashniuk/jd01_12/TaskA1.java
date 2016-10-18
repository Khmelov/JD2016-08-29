package by.it.opashniuk.jd01_12;

import java.util.ArrayList;
import java.util.Random;

public class TaskA1 {
    public static void main(String[] args) {
        ArrayList<Integer> allMarks = new ArrayList<>();
        Random myRandom = new Random();
        while (allMarks.size()<20){
            allMarks.add(myRandom.nextInt(10));
        }
        System.out.println("Оценки учеников:");
        for (int i = 0; i <20; i++) {
            System.out.println("Ученик "+(i+1)+" - Оценка: "+allMarks.get(i));
        }

        System.out.println("Положительные оценки учеников:");

        for (int i = 0; i < 20; i++) {
            if (allMarks.get(i)>=4) {
                System.out.println("Ученик "+(i+1)+" - Оценка: "+allMarks.get(i));
            }
        }
    }
}
