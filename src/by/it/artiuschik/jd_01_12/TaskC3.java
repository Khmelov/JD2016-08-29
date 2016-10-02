package by.it.artiuschik.jd_01_12;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class TaskC3 {
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
