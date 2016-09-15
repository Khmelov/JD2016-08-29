package by.it.savelyeva.jd_01_06;

/**
 * Created by nato on 9/12/16.
 */
public class Util {
    public static final String VOWELS = "аеёиоуыэюяАЕЁИОУЫЭЮЯ";
    public static final String CONSONANTS = "бвгджзйклмнпрстфхцчшщъьБВГДЖЗЙКЛМНПРСТФХЦЧШЩЪЬ";

    public static String[] splitToWords(String data, boolean toLowerCase) {
        String[] words = data.split("[^а-яА-ЯЁё]+");
        if (toLowerCase) {
            for (int i=0; i<words.length; i++) {
                words[i] = words[i].toLowerCase();
            }
        }
        return words;
    }

    public static String[] splitToStatements(String data) {
        String[] statements = data.split("[!|.]+");
        for (int i=0; i<statements.length; i++) {
            statements[i] = statements[i].trim();
        }
        return statements;
    }

    public static void printArray(String[] strArray) {
        for (String s: strArray) {
            System.out.println(s);
        }
    }

    public static String[] splitToLines(String data) {
        String[] lines = data.split("\n");
        for (int i=0; i<lines.length; i++) {
            lines[i] = lines[i].trim();
        }
        return lines;
    }

}
