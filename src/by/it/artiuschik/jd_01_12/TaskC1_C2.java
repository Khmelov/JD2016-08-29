package by.it.artiuschik.jd_01_12;

import java.util.*;

class TaskC1_C2 {
    static List<MyObject> buildList(String str){
        String[] objectNames = by.it.artiuschik.jd_01_12.Util.words(str);
        List<MyObject> objectLinkedList=new LinkedList<>();
        for(String name:objectNames)
        {
            objectLinkedList.add(new MyObject(name,(int)(Math.random()*1000)));
        }
        Collections.sort(objectLinkedList);
        return objectLinkedList;
    }
    static List<MyObject> deleteEqual(List<MyObject> list)
    {
        HashMap<String,MyObject> map=new HashMap<>();
        for (MyObject ob : list) {
            map.put(ob.getObjectName(), ob);
        }
        list=new LinkedList<>(map.values());
        return list;
    }
}
