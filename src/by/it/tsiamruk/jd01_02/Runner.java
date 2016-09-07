package by.it.tsiamruk.jd01_02;


public class Runner {

    public static void main(String[] args){
        //String str = Util.readFromConsole();
        String str="111 123 33";
        int mas[]=Util.getArrayInt(str);
        Util.printArray(mas);

        int shortNum=TaskA.getShortNum(mas);
        System.out.println("Short num="+shortNum);
        System.out.println("Short len="+String.valueOf(TaskA.getShortNum(mas)).length());

        int longNum=TaskA.getLongNum(mas);
        System.out.println("Long num="+longNum);
        System.out.println("Long len="+String.valueOf(TaskA.getLongNum(mas)).length());
        //2.
        double mean=TaskA.mean(mas);
        System.out.print("Числа меньше "+mean+" таковы ");
        for(int i:mas) {
            if (i<mean){
                System.out.print(i+" ");
            }
        }
        System.out.println();
        //3
        for (int i:mas) {
            if(TaskA.uniqueDigits(i)) {
                System.out.print("Найдено число из разных цифр: "+i);
                break;//больше не ищем
            }
        }
        System.out.println("");
        //задания части B
        int intervalGetting=TaskB.intervalGetting();
        //2
        System.out.println();
        int masMas=TaskB.matrixOutput();
        System.out.println();
        //часть 3
        double uravnenieKvadratnoe=TaskB.uravnenie();
        //part 4
        System.out.println();
        String monthesOfYear=TaskB.monthesOfYear();

        }
    }

