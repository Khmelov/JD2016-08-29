package by.it.sukora.JD1_06.classwork.A.B;

/**
 * Created by stasi on 12.09.2016.
 */
public class Task2 {
    public static void main(String[] args)
    {
        StringBuilder str = new StringBuilder(Data.POEM);
        System.out.println("Строка на входе:");
        System.out.println(str);
        System.out.println();

        LaboratoryZeroOne Obrabotca = new LaboratoryZeroOne(str);
        Obrabotca.Processing();

        System.out.println();
        System.out.println("Строка на выходе:");
        StringBuilder out = new StringBuilder();
        out = Obrabotca.getWorktype();
        System.out.println(out.toString());
        System.out.println();
    }
}
