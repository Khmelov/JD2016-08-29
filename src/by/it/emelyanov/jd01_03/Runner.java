package by.it.emelyanov.jd01_03;

public class Runner {
    public static void main(String[] args) {
        //String line=IntOut.consoleReadLine();
        String line = "1 2.3 123 24 53 34 23";
        System.out.println(line);
        double mas[] = IntOut.arrayFromString(line);
        IntOut.arrayprint(mas, "m", 3);
        //mas=Util.bubbleSort(mas);
        mas = Util.unisort(mas, true);
        System.out.println("\nОтсортирован по возрастанию:");
        IntOut.arrayprint(mas, "m", 3);
        mas = Util.unisort(mas, false);
        System.out.println("\nОтсортирован по убыванию:");
        IntOut.arrayprint(mas, "m", 3);

    }
}
