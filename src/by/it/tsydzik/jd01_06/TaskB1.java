package by.it.tsydzik.jd01_06;

/**
 * @author Eugene Tsydzik
 * @since 9/14/16.
 */
public class TaskB1 {
    public static void taskB1() {
        System.out.println(Data.POEM.replaceAll("(?<![а-яА-ЯёЁ])[бБвВгГдДжЖзЗкКлЛмМнНпПрРсСтТфФхЧцЦчЧшШщЩ]{1}[а-яА-ЯЁё]{4}(?![а-яА-ЯёЁ])\\s", ""));
    }
}
