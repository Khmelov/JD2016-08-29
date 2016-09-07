package by.it.tsiamruk.jd01_02;


public class TaskA {

    static int getShortNum(int[] mas) {
        int result =Integer.MIN_VALUE;
        for (int value:mas) {
            int lenValue=String.valueOf(value).length();
            int lenResult=String.valueOf(result).length();
            if (lenResult>lenValue) {
                result=value;
            }

        }
        return result;
    }
    static int getLongNum(int[] mas) {
        int result =0;
        for (int value:mas) {
            int lenValue=String.valueOf(value).length();
            int lenResult=String.valueOf(result).length();
            if (lenResult<lenValue) {
                result=value;
            }

        }
        return result;
    }
    //метод для вычисления средне арифметического значения
    static double mean(int mas[]) {
        double res = 0;
        for (int i : mas) res+=i;
        res /=mas.length;
        return res;
    }
    //метод поиска числа состоящего из разных цифр
    static boolean uniqueDigits(Integer value) {
        char ch[]=value.toString().toCharArray();
        for (int i=0; i<ch.length; i++)
            for (int j=i+1;j<ch.length;j++ )
                if (ch[i]==ch[j]) return false;
        //если не попалось одинаковых цифр, то они все разные
        return true;
    }


}
