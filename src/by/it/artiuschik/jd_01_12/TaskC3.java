package by.it.artiuschik.jd_01_12;

import java.util.*;

public class TaskC3 {
    public static boolean isBracketsCorrect(String str) {
        Stack<Character> bracketsStack = new Stack<>();
        try {
            for (int i = 0; i < str.length(); i++) {//проход по всем символам строки
                char c = str.charAt(i);
                switch (c) {
                    case '(':
                    case '{':
                    case '[':
                        bracketsStack.push(c);
                        break;
                /*как только встретили закрывающую скобку-проверяем была ли перед ней
                открывающая-она должна быть на верхушке стека
                 */
                    case ')':
                        if (bracketsStack.pop().charValue() != '(') {
                            return false;
                        }
                        break;
                    case '}':
                        if (bracketsStack.pop().charValue() != '{') {
                            return false;
                        }
                        break;
                    case ']':
                        if (bracketsStack.pop().charValue() != ']') {
                            return false;
                        }
                        break;
                }
            }
            return bracketsStack.isEmpty();//если стек пустой, то все корректно
        } catch (EmptyStackException e) {
            return false;//пытались найти открывающую скобку, а стек пуст
        }
    }
}
