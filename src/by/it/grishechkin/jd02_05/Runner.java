package by.it.grishechkin.jd02_05;

import java.util.Scanner;

/**
 * Created by Yury on 07.11.2016.
 */
public class Runner {
    public static void main(String[] args) {
        System.out.println("Введите для приветствия: \nна английском - en \nна русском - ru \nна белорусском - be ");
        String scanner = new Scanner(System.in).next();
        switch (scanner) {
            case "en" : {SwichRegions.swichRegion(); break;}
            case "ru" : {SwichRegions.swichRegion("ru", "RU"); break;}
            case "be" : {SwichRegions.swichRegion("be", "BY"); break;}
        }
    }
}
