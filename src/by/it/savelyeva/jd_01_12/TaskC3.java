package by.it.savelyeva.jd_01_12;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Created by nato on 9/28/16.
 */
public class TaskC3 {

	public static boolean validate(StringBuilder sb) {
		Stack<Integer> st = new Stack<Integer>();
		Pattern pattern = Pattern.compile("[{}\\[\\]()]");
		Matcher matcher = pattern.matcher(sb);
		while (matcher.find()) {
		    int code = 0;
		    switch (matcher.group()) {
		    	case "{": code = -1; break;
		    	case "}": code = 1;  break;
		    	case "(": code = -2; break;
		    	case ")": code = 2;  break;
		    	case "[": code = -3; break;
			    case "]": code = 3;  break;		    
		    }
		    //System.out.println(code);
			if (st.isEmpty()) {
				if (code<0) st.push(code);
			} else {
				int peek = st.peek();
				if (code>0 && peek + code == 0) st.pop();
				else st.push(code);
			}
		}
		return st.isEmpty();
	}
}
