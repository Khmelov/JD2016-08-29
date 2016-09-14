package by.it.ilyukhin.jd01_6;


public class Vowel {
    static boolean Glasnaya(String word) {
        String oae = "ЁУЕЫАОЭЯИЮяыуаиеоюэё";
        char first = word.charAt(0);
        char last = word.charAt(word.length() - 1);
        return (oae.indexOf(first) >= 0 && oae.indexOf(last) >= 0);
    }
}
