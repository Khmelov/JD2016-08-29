package by.it.vashukevich.jd01_02;

/*
 * Created by Admin on 31.08.16.
 */
public class TaskA {
    static public int getShotNum(int[] mas) {
        int result = Integer.MAX_VALUE;
        for (int value : mas) {
            int lenValue = String.valueOf(value).length();
            int lenResult = String.valueOf(result).length();
            if (lenResult > lenValue) {
                result = value;
            }
        }
        return result;
    }

    static public int getLongNum(int[] mas) {
        int result = 0;
        for (int value : mas) {
            int lenValue = String.valueOf(value).length();
            int lenResult = String.valueOf(result).length();
            if (lenResult < lenValue) {
                result = value;
            }
        }
        return result;
    }

    // метод вычисления среднего арифметического
    public static int getSmallerNum(int[] mas) {
        int result = 0;
        for(int value:mas)          //все
            result=result+value;    //слаживаем
        result=result/mas.length;
        return result;
    }

    //метод поиска числа, состоящего из различных цифр
    public static boolean getDifNum(Integer value) {// boulean т.к. найдет или не найдет (логика)
        //String strin=Integer.toString(value);//получаем из value строку          можно
       // char mas[]=value.toCharArray();                                            так
        char mas[]=value.toString().toCharArray();                             // а можно
        for(int i=0;i<mas.length;i++)                                          // и так
            for (int j = i + 1; j < mas.length; j++)
                if (mas[i] == mas[j])
                    return false;

               return true;
    }
}



