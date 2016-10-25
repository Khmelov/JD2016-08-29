package by.it.grishechkin.jd01_06;

/**
 * Created by Yury on 26.09.2016.
 */
public class TaskA {

    public static String strClear (String str) {
        str = str.replaceAll("\\n", " ");
        str = str.replaceAll("\\p{Punct}", "");
        str = str.replaceAll("  ", " ");
        return str;
    }

    public static String[] replace (String[] str) {

        for (int i = 0; i < str.length; i++) {
            if(str[i].length() >= 7) {
                str[i] = str[i].substring(0, 4) + "#" + str[i].substring(5, 6) + "#" + str[i].substring(7);
            }

            if (str[i].length() == 6) {
                str[i] = str[i].substring(0, 4) + "#" + str[i].substring(6);
            }

            if (str[i].length() == 5) {
                str[i] = str[i].substring(0, 4) + "#";
            }
        }
        return str;
    }

    public static int[] repeat (String[] str) {

        int[] mas = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            int iter = 0;

            for (int j = 0; j < str.length; j++) {
                if (str[i] == str[j]) iter++;
            }
            mas[i] = iter;
        }
        return mas;
    }

    public static int wordsWithVowelLetter (String[] str) {

        char[] vowel = {'а','у','о','ы','и','э','я','ю','ё','е','А','У','О','Ы','И','Э','Я','Ю','Ё','Е'};
        int iter = 0;
        for (int i = 0; i < str.length; i++) {
                for (int j = 0; j < vowel.length; j++) {
                    if (str[i].charAt(0) == vowel[j]) {
                        for (int k = 0; k < vowel.length; k++) {
                            if (str[i].charAt(str[i].length() - 1) == vowel[k]){
                                iter++;
                            }
                        }
                    }
                }
        }
        return iter;
    }
}
