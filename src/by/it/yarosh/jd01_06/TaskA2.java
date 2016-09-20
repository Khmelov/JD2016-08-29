package by.it.yarosh.jd01_06;


public class TaskA2 {
    public static void main(String[ ] args) {

        String text=Data.POEM;

        String[] mastext= text.split("[^а-яА-ЯёЁ]+");

        for (int i = 0; i < mastext.length; i++) {
            if (mastext[i].length()>0)
            {
                int count=1;
                for (int j = i+1; j < mastext.length; j++) {
                    if (mastext[i].equals(mastext[j]))
                    {
                        count++;
                        mastext[j]="";
                    }
                }
                System.out.println("повтор слова \""+mastext[i]+"\" равны "+count);
            }
        }

    }
}
