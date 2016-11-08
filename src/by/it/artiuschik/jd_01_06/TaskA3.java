package by.it.artiuschik.jd_01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA3 {
    private static boolean glasnaya(String word) {
        String oae = "яыуаиеоюэё";
        oae += oae.toUpperCase();
        char firstLetter = word.charAt(0);
        char lastLetter = word.charAt(word.length() - 1);
        return (oae.indexOf(firstLetter) >= 0 && oae.indexOf(lastLetter) >= 0);
    }

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(by.it.artiuschik.jd_01_06.Data.POEM);
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher m = p.matcher(text);
        int counter = 0;
        while (m.find())
            if (glasnaya(m.group())) {
                counter++;
                System.out.println(m.group());
            }

        System.out.print(counter);

    }


}

