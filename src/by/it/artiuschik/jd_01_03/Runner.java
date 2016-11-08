package by.it.artiuschik.jd_01_03;

public class Runner {
    public static void main(String[]args)
    {
        String line= InOut.consoleReadLine();
        double mas[]= InOut.arrayFromString(line);
        mas= Util.bubbleSort(mas);
        InOut.arrayPrint(mas,"m",4);
        mas= Util.uniSort(mas,true);
        InOut.arrayPrint(mas,"m",4);
    }
}
