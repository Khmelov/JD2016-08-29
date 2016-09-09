package by.it.laurynovich.jd01_03;

/**
 * Created by vseotdala on 02.09.2016.
 */
public class Runner {
    public static void main(String[] args) {
       // String line=InOut.arrayFromString( line )
        String line="88 1 2 33 21 15 45 95" ;
        System.out.println(line);
        double[] mas = InOut.arrayFromString( line );
        InOut.arrayPrint( mas,"m",3 );

       // mas=Utill.bubbleSort( mas );
        mas = Utill.uniSort( mas );
        System.out.println("\n  Sort mas");
        InOut.arrayPrint( mas,"m",3 );

    }
}
