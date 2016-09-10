package by.it.opashniuk.jd01_02;


public class TaskA {

    static public int getShortNum(int[] mas) {
        int result=Integer.MIN_VALUE;
        for (int value:mas) {
            int lenValue=String.valueOf(value).length();
            int lenResult=String.valueOf(result).length();
            if (lenResult>=lenValue) {
                result=value;
            }
        }
        return result;
        }

    static public int getLongNum(int[] mas) {
        int result=0;
        for (int value:mas) {
            int lenValue=String.valueOf(value).length();
            int lenResult=String.valueOf(result).length();
            if (lenResult<=lenValue) {
                result=value;
            }
        }
        return result;
    }

    static public double getAverageNum(int[] mas) {
        int sum=0;
        for (int i:mas) {
                sum=sum + i;
            sum=sum/mas.length;
        }
        return sum;
    }

    static boolean variousLitter(Integer value){
        char ch[]=value.toString().toCharArray();
        for (int i=0; i<ch.length; i++)
            for (int j=i+1; j<ch.length; j++)
                if (ch[i]==ch[j]) return false;
        return true;
    }
}
