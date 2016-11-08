package by.it.artiuschik.jd_01_03;
import java.util.Scanner;

class InOut {
    static String consoleReadLine()
    {
        return new Scanner(System.in).nextLine();
    }
    static double[] arrayFromString (String str)
    {
        str=str.trim();
        String strArray[]=str.split(" ") ;
        int count=strArray.length;
        double res[]=new double[strArray.length];
        for (int i = 0; i <count ; i++) {
            res[i]=Double.parseDouble(strArray[i]);

        }
        return res;

    }
    static void arrayPrint(double mas[],String name,int cols){
        int col=0;
        for (double ignored :mas) {
            System.out.printf(name+"[% -3d]=%-6.2f ",col,mas[col]);
            col++;
            if(col%cols==0||col==mas.length)
            {
                System.out.println();
            }

        }
    }
}
