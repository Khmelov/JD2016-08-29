package by.it.rudzko.jd01_12;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Task A"); System.out.println("--------------------------------------------------------");

        ArrayList <Integer> marks=new ArrayList<Integer>();
        for (int i=0; i<25; i++){ marks.add((int)(Math.random()*10+1)); }
                                        System.out.println("All marks: "+marks);
        Iterator iter=marks.iterator();
        while(iter.hasNext())           { if ((int)(iter.next())<4) iter.remove();}
        System.out.println("Satisfied marks: "+marks);


        HashSet <Integer> set1=new HashSet<Integer>();          set1.addAll(marks);
        HashSet<Integer> set2=new HashSet<>();
        for (int i=0; i<15; i++){ set2.add((int)(Math.random()*50-25)); }
        System.out.println("Crossings of Satisfied marks set and random set: "+MyCollect.getCross(set1, set2));


        HashSet<Integer> res=MyCollect.getUnion(set1, set2);
        System.out.println("Union of Satisfied marks set and random set: "+res);

        ArrayList <Integer> arl=new ArrayList<Integer>(res);
        Collections.sort(arl);                         Collections.reverse(arl);
        System.out.println("Result sorted in descending order: "+arl);


        System.out.println("\n\nTask B"); System.out.println("--------------------------------------------------------");

        System.out.println(TaskB.getWords(Data.TEXT));

        ArrayList<String>people =new ArrayList<String>();               LinkedList<String> men =new LinkedList<String>();
                                        int r=(int)(Math.random()*15+5);
        for (int i=1; i<r; i++){ people.add("Person"+i); }         for (int i=1; i<r; i++){men.add("Man"+i); }
        long t=System.nanoTime();           System.out.println(people+"-->Removing every second element-->"
                                            +TaskB.processArray(people)+"\nTime for ArrayList: "+(System.nanoTime()-t));
        long t2=System.nanoTime();          System.out.println(men+"-->Removing every second element-->"
                                            +TaskB.processArray(men)+"\nTime for LinkedList: "+(System.nanoTime()-t2));
        //Process in ArrayList is quicker because there're no links between its elements.


        System.out.println("\n\nTask C"); System.out.println("--------------------------------------------------------");

        String[]text={"Minsk","Gomel","Vitebsk","Mogilev","Brest","Grodno","Minsk","Gomel","Vitebsk"};
        TreeMap<Integer, String> c1=new TreeMap<Integer, String>();
        for (String value:text) {
            int a=value.hashCode();
            c1.put(a,value);
        }
        System.out.println(c1);

        GetCross <Integer> test=new GetCross<Integer>();
        HashSet<Integer> hs1=new HashSet<>();       for (int i=0; i<10; i++){ hs1.add((int)(Math.random()*20-10)); }
        HashSet<Integer> hs2=new HashSet<>();       for (int i=0; i<10; i++){ hs2.add((int)(Math.random()*20-10)); }
        System.out.println("Generated HashSets: "+hs1+" and "+hs2);
        System.out.println("Equal elements: "+test.cross(hs1, hs2));



    }

}
