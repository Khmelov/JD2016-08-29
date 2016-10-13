package by.it.artiuschik.jd_01_03;

public class Runner {
    public static void main(String[]args)
    {
        String line= by.it.artiuschik.jd_01_03.InOut.consoleReadLine();
        double mas[]= by.it.artiuschik.jd_01_03.InOut.arrayFromString(line);
        mas= by.it.artiuschik.jd_01_03.Util.bubbleSort(mas);
        by.it.artiuschik.jd_01_03.InOut.arrayPrint(mas,"m",4);
        mas= by.it.artiuschik.jd_01_03.Util.uniSort(mas,true);
        InOut.arrayPrint(mas,"m",4);
    }
}
