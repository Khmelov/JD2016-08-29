package by.it.rudzko.jd01_12;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Leta on 26.09.2016.
 */
public class TaskB{

    public static HashMap<String, Integer> getWords(String str) {
        HashMap <String, Integer> list = new HashMap<String, Integer>();
        String[]arr=str.split("[^A-Za-z]+");
        for (int i=0; i<arr.length; i++){
            int am=0;
            if (list.containsKey(arr[i])){
                am=list.get(arr[i]);
            }
            list.put(arr[i], am+1);
        }

        return list;
    }

    public static <T extends Object> List<T> processArray (List<T> list){
        int c = 1;
        while (list.size()>1) {
            Iterator <T> i = list.iterator ();
            while (i.hasNext()) {
                i.next();
                if (c % 2 == 0)
                    i.remove();
                c++;
            }
        }
       return list;
    }


}
