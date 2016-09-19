package by.it.sukora.JD1_05.Math;

import static java.lang.Math.*;


/**
 * Created by stasi on 12.09.2016.
 */
public class Task3 {

    public static void printTable(){



        System.out.println("┏━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
        System.out.println("┃     param        ┃         value              ┃");
        System.out.println("┣━━━━━━━━━━━╋━━━━━━━━━━━━━━━━┫");
        for (double t = 2; t <= 3; t += 0.1){
            double y = log(1.3+t)-pow(E,t);
            System.out.println(String.format("%-2s%-18s%-2s%-26s%-20s", "┃", t, "┃", y, "┃"));
        }
        System.out.println("┗━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┛");
    }
}
