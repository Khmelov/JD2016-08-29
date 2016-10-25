package by.it.grishechkin.jd01_06;

import java.util.Scanner;

/**
 * Created by Yury on 26.09.2016.
 */
public class Runner {

    public static void main(String[] args) {

        String str = "У лукоморья дуб зелёный;\n" +
                "Златая цепь на дубе том:\n" +
                "И днём и ночью кот учёный\n" +
                "Всё ходит по цепи кругом;\n" +
                "Идёт направо - песнь заводит,\n" +
                "Налево - сказку говорит. Брат братан братишка.";
        String[] mas = TaskA.strClear(str).split(" ");

        for (String value : TaskA.replace(mas)) {
            System.out.println(value + "\n");
        }

        int[] masIter = TaskA.repeat(mas);
        for (int i = 0; i < mas.length; i++) {
            System.out.println(mas[i] + " -- " + masIter[i]);
        }
        System.out.println("\n After words deleting:");
        int wordsCol = TaskA.wordsWithVowelLetter(TaskA.strClear(str).split(" "));
        System.out.println("\n Col: " + wordsCol);
        TaskB.delete(TaskA.strClear(str).split(" "));
        TaskB.splittingAndSort(str);
        System.out.println("\n Enter symbol:");
        String s = new Scanner(System.in).nextLine();
        char symbol = s.charAt(0);
        Util.sortB(Util.sortBySymbols(str, symbol));
    }
}
