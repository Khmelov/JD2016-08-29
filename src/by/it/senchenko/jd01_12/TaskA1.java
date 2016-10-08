package by.it.senchenko.jd01_12;


        import java.util.ArrayList;
        import java.util.Iterator;
        import java.util.Random;

public class TaskA1 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        Random myRandom = new Random();
        while (arrayList.size()<10){
            arrayList.add(myRandom.nextInt(10));
        }
        System.out.println(arrayList);
        System.out.println(arrayList.size());

        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Integer i=iterator.next();
            if (i < 4) {
                arrayList2.add(i);
                iterator.remove();
            }
        }
        System.out.println(arrayList);
        System.out.println(arrayList.size());
        System.out.println(arrayList2);
    }
}
