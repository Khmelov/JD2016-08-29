package by.it.savelyeva.jd_01_12;

import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 * Created by nato on 9/28/16.
 */
public class TaskB1 {
	private static HashMap<String, Integer> convertTextToHashMap(StringBuilder sb) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		Pattern pattern = Pattern.compile("[a-zA-Z']+");
        Matcher matcher = pattern.matcher(sb);
        int cnt;
        while (matcher.find()) {
            String word = matcher.group();
        	if (hm.containsKey(word)) cnt = hm.get(word);
        	else cnt = 0;
        	hm.put(word, ++cnt);
        }
		return hm;
	}
	
	public static void printWordsStatistics(StringBuilder sb) {
		HashMap<String, Integer> hm = convertTextToHashMap(sb);
		Iterator<String> it = hm.keySet().iterator(); 
		int i = 0;
        int allWordsCount = 0;
		while(it.hasNext()) {
			String word = it.next(); 
			int cnt = hm.get(word);
			allWordsCount += cnt;
			System.out.printf("No. %d: %s - %d time(s)\n", ++i, word, cnt); 
		} 
        System.out.printf("All words count = %d\n", allWordsCount);
        System.out.printf("Different words count = %d\n", hm.size());
	}
}
