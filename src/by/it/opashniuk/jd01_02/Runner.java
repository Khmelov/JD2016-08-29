package by.it.opashniuk.jd01_02;

public class Runner {

    public static void main(String[] args) {
        String str=Util.readFromConsole();
        int mas[]=Util.getArrayInt(str);
        Util.printArray(mas);

        int shortNum=TaskA.getShortNum(mas);
        System.out.print("Short num=" + shortNum + " ");
        System.out.print("Short len=" + String.valueOf(shortNum).length() + " ");

        int longNum=TaskA.getLongNum(mas);
        System.out.print("Long num=" + longNum + " ");
        System.out.print("Long len=" + String.valueOf(longNum).length() +" ");

        double averageNum=TaskA.getAverageNum(mas);
        double sum=TaskA.sum;
        double sr=sum/mas.length;
        System.out.print("Числа меньше "+sr+"таковы: ");
                for (int i:mas) {
                    if (i<sr) {
                        System.out.print(i+" ");
                    }
                }
        System.out.println();

        static boolean diffChar(int value) {
        char[] mas=value.toString().toCharArray();
        for (int i=0; i<mas.length-1; i++) {
            for (int j=i+1; j<mas.length; j++)
                if (mas[i]==mas[j]) {
                    return false;
                }
        }

                return true;
    }

    }
}
