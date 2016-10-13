package by.it.artiuschik.jd_01_06;

public class TaskB3 {
    public static int symbolAmount(String word, char symbol) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == symbol) {
                count++;
            }
        }
        return count;
    }
    public static String[] sortBySymbol(String[] mas, char symbol) {
        for (int i = 0; i < mas.length - 1; i++) {
            for (int j = i + 1; j < mas.length; j++) {
                if (symbolAmount(mas[i], symbol) < symbolAmount(mas[j], symbol)) {
                    String temp = mas[i];
                    mas[i] = mas[j];
                    mas[j] = temp;
                } else {
                    if (symbolAmount(mas[i], symbol) == symbolAmount(mas[j], symbol)) {
                        if (mas[j].compareToIgnoreCase(mas[i]) < 0) {
                            String temp = mas[i];
                            mas[i] = mas[j];
                            mas[j] = temp;
                        }
                    }
                }
            }

        }
        return mas;
    }
    public static void main(String[] args)
    {
        System.out.println("--------Исходный текст---------");
        System.out.println(by.it.artiuschik.jd_01_06.Data.POEM);
        System.out.println("--------Результат---------");
        String [] mas=sortBySymbol(by.it.artiuschik.jd_01_06.Util.words(Data.POEM),'а');
        for (int i = 0; i <mas.length ; i++) {
            System.out.println(mas[i]);
        }
    }
}
