package by.it.grishechkin.jd02_04;

import java.util.Scanner;

/**
 * Created by Yury on 07.11.2016.
 */
public class Util {

    public static String read () {
        System.out.println("Введите выражение");
        String line = new Scanner(System.in).next();
        return line;
    }
}
