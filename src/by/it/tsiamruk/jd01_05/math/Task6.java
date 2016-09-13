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

    public static void showArray(double[] array){
          int col = 0;

        for (double value : array) {
            System.out.printf("array value is: " + value + " index[%d]\n", col);
            col++;
        }
    }

    public static void evenIndexArray(double[] array){
        //counter
        int count = 0;
        //multiplicator
        double mult = 1;

        for (double value : array){
            if (count % 2 == 0){
                mult*=value;
            }
            count ++;
        }
        System.out.printf("Multiplication of every even index of array is [%f]", mult);

    }

    public static double[] newArray(double[] array){

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 2){
                count ++;
            }

        }
        double[] newArray = new double[count];


        int counter = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i]> 2){
                    newArray[counter] = array[i];
                    counter++;
            }
        }

        //test
        //for (double value : newArray) {
        //    System.out.println(value);
        //}

       return newArray;
    }


    }//end class





