package by.it.morozov.jd01_02;

/**
 * Created by BukTpbI4 on 13.09.2016.
 */
public class Runner {
    public static void main(String[] args) {
        String str="111 123 33";
        int mas[]=Util.getArrayInt(str);
        Util.printArray(mas);
        int shortNum=PartA.getShortNum(mas);
        System.out.println("Short num="+shortNum);
        System.out.println("Short len="+String.valueOf(PartA.getShortNum(mas)).length());
        int longNum=PartA.getLongNum(mas);
        System.out.println("Long num="+longNum);
        System.out.println("Long len="+String.valueOf(PartA.getLongNum(mas)).length());
        //часть2
        double mean=PartA.mean(mas);
        System.out.print("Числа меньше "+mean+" таковы ");
        for(int i:mas){
            if (i<mean){
                System.out.print(i+" ");
            }
        }
        System.out.println();
        //часть 3
        for (int i:mas){
            if(PartA.uniqueDigits(i)){
                System.out.print("Найдено число из разных цифр: "+i);
                break;
            }
        }
        System.out.println();

    }
}
