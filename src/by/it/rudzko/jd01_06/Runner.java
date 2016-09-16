package by.it.rudzko.jd01_06;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {




        System.out.println("Task 1:\n\n"+TaskA.changeSym(Data.POEM)+"\n\nTask 2:\n\n");
        System.out.printf("%-10s", "Word");
        System.out.printf("%-10s", "Repeats\n");
        System.out.println("**********");
        InOut.printAr(TaskA.countWords(Data.POEM));
        System.out.println("\n\nTask 3:\n\nThere are "+TaskA.findVoc(Data.POEM)+
                           " words which have a vocal in the beginning or in the end.");
        System.out.println("\n\nTask 4:\n\n"+TaskB.delCons(Data.POEM));
        System.out.println("\n\nTask 5:\n\n");
        InOut.printPoem(TaskB.compSent(Data.POEM));
        System.out.println("\n\nTask 6:\n\nPlease enter a cyrillic letter:");
        String str=new Scanner(System.in).nextLine();
        InOut.printPoem(TaskB.sortWords(Data.POEM, str));
        System.out.println("\n\nTask 7:\n\n");
        InOut.printPoem(TaskC.format(Data.POEM));

        System.out.println("\n\nTask 8:\n\n");
        long t=TaskC.conc(Data.POEM)-TaskC.strMilsb(Data.POEM);
        System.out.println("The gain of StringBuilder use is "+t+" milliseconds.");
        System.out.println("\n\nTask 9:\n");
        InOut.printAr(TaskC.sortCountWords(Data.POEM));

    }
}
