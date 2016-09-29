package by.it.senchenko.jd01_12;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Task1 task = new Task1();

        HashMap<String,String> list = new HashMap();
        HashMap<String,String> list2 = new HashMap();
        String[] text = Text.test.split("  ");

        //list.put("1","qwe");
        //list.put("2","asd");
        //list.put("3","qwe");


        for (Integer i = 0; i < text.length; i++) {
            list.put(i.toString(), ((String) text[i]));
        }

        System.out.println(list);
        System.out.println(list.size());
        task.uniqueMap(task.list);
        System.out.println(task.list);
        System.out.println(task.list);

    
    }
}
