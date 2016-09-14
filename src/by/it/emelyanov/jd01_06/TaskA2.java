package by.it.emelyanov.jd01_06;

public class TaskA2 {
    public static void WordRep() {
        String text = Data.getString().toUpperCase(); //words Up
        String[] mastext = text.split("[^А-ЯЁ]+");

        for (int i = 0; i < mastext.length; i++) {
            if (mastext[i].length() > 0) {
                int count = 1;
                for (int j = i + 1; j < mastext.length; j++) {
                    if (mastext[i].equals(mastext[j])) {
                        count++;
                        mastext[j] = "";
                    }
                }
                System.out.println("Число повторов слова \""+mastext[i]+"\" составляет "+count);
            }
        }
    }
}
