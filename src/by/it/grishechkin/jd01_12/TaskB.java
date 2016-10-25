package by.it.grishechkin.jd01_12;

import java.util.*;

/**
 * Created by Yury on 20.10.2016.
 */
public class TaskB {

    public static String text = "Given the wide range of systems and technical requirements, it is tempting to speculate which broadband technology will be the winner. But technical differences will have minimal influence on deployment The various systems are all technically feasible. All of them, except LEO satellites for data only, have been demonstrated and are even being installed  to varying degrees. The real barrier to widespread broadband access is the cost of installation. As might be expected, economics and business structure are driving deployment decisions.\n" +
            "Industry estimates suggest that the cost to newly wire  a neighborhood for broadband, so that the cost of installation is shared across all the residences, is roughly a home. Because there are about 100 million homes in the U.S., the implication is that perhaps $100 billion must be spent to provide a new wireline connection to every home in the country. This is a huge sum to justify, especially because the importance of the Internet (and broadband access to it) is still proving itself. To wire one home at a time is much more costly, so any piecemeal  wiring of isolated consumers would be even less feasible.";

    public static String strClear (String str) {
        str = str.replaceAll("\\n", " ");
        str = str.replaceAll("\\p{Punct}", "");
        str = str.replaceAll("  ", " ");
        return str;
    }

    public static String[] splitting() {
        String[] mas = strClear(text).split(" ");
        return mas;
    }

    public static Map repeat (String[] str) {

        Map <String, Integer> rez = new HashMap<>();
        List <String> list = new ArrayList<>();
        for (String value : str) {
            list.add(value);
        }
        Integer it;
        for (String value : list) {
            it = 0;
            for (int i = 0; i < list.size(); i++) {
                if (value.equals(list.get(i))) {
                    it++;
                }
            }
            rez.put(value, it);
        }
        return rez;
    }

    public static void processArray (Integer n) {
        List <Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        long st, en;
        st = System.nanoTime();
        Iterator <Integer> it = list.iterator();
        while (it.hasNext()) {
            if (it.next()%2 == 0) {
                it.remove();
            }
        }
        en = System.nanoTime();
        long rez = en - st;
        System.out.println("processArray = " + rez);
    }

    public static void processLinked (Integer n) {
        List <Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        long st, en;
        st = System.nanoTime();
        Iterator <Integer> it = list.iterator();
        while (it.hasNext()) {
            if (it.next()%2 == 0) {
                it.remove();
            }
        }
        en = System.nanoTime();
        long rez = en - st;
        System.out.println("processLinked = " + rez);
    }
}
