package by.it.sukora.JD1_06.classwork.A.B;


/**
 * Created by stasi on 12.09.2016.
 */
public class Task1 {
    public static void main(String[] args) {
        // Иициализация текста
        String text = Data.POEM;
        // Вывод текста
        System.out.println(text);

        String[] strArr = text.split(" ");//разбиваем текст на массив слов
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<strArr.length;i++){

            char first = strArr[i].charAt(0); // первая буква каждого слова

            if(!((strArr[i].length()%5==0)  &&  ((first != 'б')&&(first != 'в')&&(first != 'г')&&(first != 'д')&&(first != 'ж')&&(first != 'з')&&(first != 'к')&&(first != 'л')&&(first != 'м')&&(first != 'н')&&(first != 'р')&&(first != 'с')&&(first != 'т')&&(first != 'ж')&&(first != 'з')&&(first != 'п')&&(first != 'я')&&(first != 'Я')))){

                sb.append(strArr[i]).append(" ");
            }

        }
        String outText = sb.toString().trim();

        // вывод результата
        System.out.print(outText+" "+"\n\n");


    }


}
