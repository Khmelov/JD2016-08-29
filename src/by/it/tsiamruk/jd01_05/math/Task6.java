package by.it.tsiamruk.jd01_05.math;



public class Task6 {

    public static double[] newArray(){
        //calculate quantity of c argument.

        double a = -1.5;
        double b = 6;
        double step = 0.3;
        double rangeSize = (b - a) / step;
        int count = (int) Math.floor(rangeSize);

        double[] array = new double[count];
        double c = a;

        //assign function to array.

        for (int i = 0; i < array.length; i++) {
            double y = 7.28/(c+4);
            array[(int)i] = y;
            c += step;
        }

        return array;
    }

    public static void showArray(double[] mas){
          int col = 0;

        for (double value:mas) {
            System.out.printf("array value is: "+value +" index[%d]\n", col);
            col++;
        }

    }


}
