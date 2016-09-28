package by.it.senchenko.jd01_12;


import java.util.*;

public class Task1 {

    HashMap<String,String> list = new HashMap();
    void uniqueMap(HashMap<String,String> map){
        swap(map);
        swap(map);
    }

    void swap(HashMap<String,String> map){
        HashMap<String,String> res=new HashMap<String,String>();
        Set<Map.Entry<String,String>> set=map.entrySet();
        Iterator<Map.Entry<String,String>> it=set.iterator();
        while (it.hasNext()){
            Map.Entry<String,String> oneset=it.next();
            String key=oneset.getKey();
            String value=oneset.getValue();
            res.put(value,key);
        }
        map=res;
    }

}


