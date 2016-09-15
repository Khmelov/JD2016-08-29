package by.it.tsiamruk.jd01_06;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA {
    static void task1(){
        StringBuilder sb = new StringBuilder(Data.POEM);
        Pattern p = Pattern.compile("[а-яА-яёЁ]{5,}");
        Matcher m = p.matcher(sb);

        while (m.find()){
            int pos = m.start();
            sb.setCharAt(pos + 4,'#');
            if (m.group().length() >= 7)
                sb.setCharAt(pos + 6, '#');
        }

        System.out.println(sb.toString());
    }

    static void task2(){
        String[] words=Data.POEM.split("[^а-яА-яёЁ]+");


        for (int i = 0; i < words.length; i++){
            if (words[i] != ""){
                int counter = 1;
                for (int j = i + 1; j < words.length; j++) {
                    if (words[i].equalsIgnoreCase(words[j])) {
                        counter++;
                        words[j] = "";
                    }
                }
                System.out.println(words[i]+":"+counter);
            }
        }
    }
    //task 3
    //метод для поиска гласных
    static boolean Glasnaya(String word){
        //паттерн для гласных букв
        String oae="яЯыЫуУаАиИеУоОюЮэЭёЁ";
        char first=word.charAt(0);
        char last=word.charAt(word.length()-1);
        //вернем true если гласная в начале и в конце
        return (oae.indexOf(first)>=0 && oae.indexOf(last)>=0);
    }

    static void task3() {
        //Получим строку в которой можно проводить замену символов.
        StringBuilder text=new StringBuilder(Data.POEM);
        //сначала переберем все слова.
        //Нас интересуют слова из 1 и более русских букв
        //Паттерн для таких слов [а-яА-ЯёЁ]+
        Pattern p=Pattern.compile("[а-яА-ЯёЁ]+");
        //Теперь получим matcher - эта структура умеет находит слова по паттерну
        Matcher m=p.matcher(text);
        int counter=0;
        while (m.find()) //пока находятся слова, мы подсчитываем число подходящих под проверку
            if (Glasnaya(m.group())) //если проверка показали гласные в начале и конце
            {
                counter++;                     //то увеличим общий счетчик
                //System.out.println(m.group()); //для вывода слова, не нужно по условию
            }

        System.out.print("всего слов начинается с гласной - "+counter);

        }
    }






