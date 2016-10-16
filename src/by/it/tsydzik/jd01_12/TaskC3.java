package by.it.tsydzik.jd01_12;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Eugene Tsydzik
 * @since 16.10.16.
 */
public class TaskC3 {
    public static void task(String str) {
        boolean validate = validate(str);
        System.out.println(validate ? "Your string is valid" : "Your string is invalid");

    }

    public static boolean validate(String str) {
        char[] chars = str.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (char elem : chars) {
            switch (elem) {
                case '{':
                case '(':
                case '[':
                    stack.addLast(elem);
                    break;
                case '}':
                    if (!isClosedBracketValid(stack, '{')) {
                        return false;
                    }
                    break;
                case ')':
                    if (!isClosedBracketValid(stack, '(')) {
                        return false;
                    }
                    break;
                case ']':
                    if (!isClosedBracketValid(stack, '[')) {
                        return false;
                    }
                    break;
                default:
                    return false;
            }

        }
        return stack.isEmpty();
    }

    private static boolean isClosedBracketValid(Deque<Character> stack, char compareWithChar) {
        if (stack.isEmpty()) {
            return false;
        }

        return stack.pollLast() == compareWithChar;
    }
}
