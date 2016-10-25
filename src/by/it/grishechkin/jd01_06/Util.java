package by.it.grishechkin.jd01_06;

import java.util.*;

import static by.it.grishechkin.jd01_06.TaskA.strClear;

/**
 * Created by Yury on 30.09.2016.
 */
public class Util {
// Идея такая: Идти посимвольно пока не встретим '.', запоминаем индекс и засовываем в массив все до этого индекса
    public static ArrayList splitting(String str) {

        int ferstIndex = 0;
        int lastIndex;
        ArrayList <String> mas = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '.') {
                lastIndex = i;
                mas.add(str.substring(ferstIndex, lastIndex));
                ferstIndex = lastIndex + 1;
            }
        }
        ArrayList<String> newMas = new ArrayList<>();
        for (String value : mas) {
            while (value.charAt(0) == ' ') {
                StringBuffer temp = new StringBuffer(value);
                temp.deleteCharAt(0);
                value = temp.toString();
            }
            value = value.replaceAll("\n", " ");
            newMas.add(value);
        }
        return newMas;

    }

    public static HashMap country(ArrayList<String> mas) {
        Integer [] country = new Integer[mas.size()];
        int flag = 0;
        HashMap<Integer, String> rez = new HashMap<>();
        for (String value : mas) {
            country[flag] = 0;
            for (int i = 0; i < value.length(); i++) {
                if (value.charAt(i) == ' ')
                    country[flag]++;
            }
            rez.put(country[flag], value);
        }
        return rez;
    }

    public static void sort(HashMap<Integer, String> hmap) {

        Map<Integer, String> map = new TreeMap<Integer, String>(hmap);
        System.out.println("After Sorting:");
        Set set2 = map.entrySet();
        Iterator iterator2 = set2.iterator();
        while(iterator2.hasNext()) {
            Map.Entry me2 = (Map.Entry)iterator2.next();
            System.out.println(me2.getValue());
        }
    }

    public static HashMap sortBySymbols(String str, char symbol) {
        str = strClear(str);
        String[] words = str.split(" ");
        Arrays.sort(words);

        Integer[] country = new Integer[words.length];
        HashMap<String, Integer> rez = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            country[i] = 0;
            for (int j = 0; j < words[i].length(); j++) {
                if (words[i].charAt(j) == symbol) {
                    country[i]++;
                }
                rez.put(words[i], country[i]);
            }
        }
        return rez;
    }

    public static void sortB(HashMap<String, Integer> hmap) {

        Map<String, Integer> map = sortByValues(hmap);
        System.out.println("After Sorting:");
        Set set2 = map.entrySet();
        Iterator iterator2 = set2.iterator();
        while(iterator2.hasNext()) {
            Map.Entry me2 = (Map.Entry)iterator2.next();
            System.out.print(me2.getKey() + ": ");
            System.out.println(me2.getValue());
        }
    }

    private static HashMap sortByValues(HashMap map) {
        List list = new LinkedList(map.entrySet());

        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o1)).getValue())
                        .compareTo(((Map.Entry) (o2)).getValue());
            }
        });


        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }
}
