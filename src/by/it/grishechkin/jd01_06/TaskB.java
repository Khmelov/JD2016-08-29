package by.it.grishechkin.jd01_06;

import java.util.ArrayList;

/**
 * Created by Yury on 30.09.2016.
 */
public class TaskB {

    public static void delete(String [] mas) {

        char[] vowel = {'а','у','о','ы','и','э','я','ю','ё','е','А','У','О','Ы','И','Э','Я','Ю','Ё','Е'};
        ArrayList <String> rez = new ArrayList<String>();
        for (int i = 0; i < mas.length; i++) {
            boolean flag = false;

            for (int j = 0; j < vowel.length; j++) {
                if (mas[i].charAt(0) != vowel[j] && mas[i].length() == 5) {
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                rez.add(mas[i]);
            }
        }
        for (String value : rez) {
            System.out.println(value.toString() + "\n");
        }
    }

    public static void splittingAndSort(String str) {

        Util.sort(Util.country(Util.splitting(str)));
    }
}
