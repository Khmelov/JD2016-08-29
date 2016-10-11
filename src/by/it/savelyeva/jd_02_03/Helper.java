package by.it.savelyeva.jd_02_03;

/**
 * Created by nato on 10/3/16.
 */
public class Helper {
    protected static int rnd(int leftBound, int rightBound) {
        return leftBound + (int) Math.round(Math.random() * (rightBound - leftBound));
    }

    protected static int rnd(int max) {
        return rnd(0, max);
    }

    protected static void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void printReportLine(int column, String value) {
        System.out.print("| ");
        for (int i=1; i<column; i++) System.out.printf("%s|", "        ");
        System.out.print(value);
        for (int i=column; i<=5; i++) System.out.printf("%s|", "        ");
        System.out.printf(" Q size: %d |", QueueBuyers.getSize());
        System.out.printf(" Market Total: %5.2f |\n", Market.getTotalIncome());
    }

}
