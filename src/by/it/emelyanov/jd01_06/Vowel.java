package by.it.emelyanov.jd01_06;

public class Vowel {
    static boolean patVow(String word) {
        String vowel = "ёЁуУеЕыЫаАоОэЭяЯиИюЮ"; //vowels
        //String vowel ="йЙцЦкКнНгГшШщЩзЗхХъЪфФвВпПрРлЛдДжЖчЧсСмМтТбБьЬ"; //consonants
        char first = word.charAt(0);
        //check word
        if (word.length()>1) {
            char last = word.charAt(word.length() - 1);
            return (vowel.indexOf(first) >= 0 & vowel.indexOf(last) >= 0);
        }
        else
            return false;
    }
}
