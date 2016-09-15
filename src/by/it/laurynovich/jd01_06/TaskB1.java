//package by.it.laurynovich.jd01_06;
//
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
///**
// * Created by vseotdala on 13.09.2016.
// */
//
////  1. Из текста удалить все слова длины 5, начинающиеся на согласную букву.
//public class TaskB1 {
//
//    public boolean Soglasnaja (String word){
//        String sdf = "йцкнгшщхъфвпрлджчсмтьб";
//        sdf = sdf + sdf.toUpperCase();
//        int len = word.length();
//        if (len == 5)
//        return (sdf.indexOf(word.charAt(0)) >= 0 );
//    }
//
//    public static void main(String[] args) {
//        StringBuilder text = new StringBuilder(Data.POEM);
//        Pattern p = Pattern.compile("[а-яА-ЯёЁ]+");
//        Matcher m = p.matcher(text);
//        while (m.find())
//            if ( Soglasnaja(m.group()))
//            {
//                System.out.println(m.group());
//            }
//
//    }
//
//}
