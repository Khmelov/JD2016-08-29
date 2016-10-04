package by.it.sukora.jd01_12.HomeWork;


import java.util.*;

public class TaskC {
    public static String[] words(String str)
    {
        String[] result=str.split("[^a-zA-Z0-9]+");
        return result;
    }
    //C1
    public static List<MyObject> buildList(String str){
        String[] objectNames = words(str);
        List<MyObject> objectLinkedList=new LinkedList<>();
        for(String name:objectNames)
        {
            objectLinkedList.add(new MyObject(name,(int)(Math.random()*1000)));
        }
        Collections.sort(objectLinkedList);
        return objectLinkedList;
    }
    public static List<MyObject> deleteEqual(List<MyObject> list)
    {
        HashMap<String,MyObject> map=new HashMap<>();
        Iterator<MyObject> iter=list.iterator();
        while(iter.hasNext())
        {
            MyObject ob=iter.next();
            map.put(ob.getObjectName(),ob);
        }
        list=new LinkedList(map.values());
        return list;
    }
    //C3
    public static boolean isBracketsCorrect(String str) {
        StringBuilder s = new StringBuilder(str);
        Deque<Character> brackets = new LinkedList<>();
        char openBr = '(';
        char closeBr = ')';
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(': {
                    brackets.addFirst(openBr);
                    break;
                }
                case ')':
                    brackets.addLast(closeBr);
                    break;
                default:
                    break;
            }

        }
        while ((brackets.peekFirst() == '(') && (brackets.peekLast() == ')')) {
            brackets.removeFirst();
            brackets.removeLast();
            if(brackets.isEmpty())
            {
                return true;
            }
        }

        return false;
    }
}
