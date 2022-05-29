package slidingWindow.longestDistinctSubString;

import java.util.HashMap;
import java.util.Map;

/**
 *	Given a string, find the length of the longest substring which has no repeating characters.

	Example 1:
	
	Input: String="aabccbb"
	Output: 3
	Explanation: The longest substring without any repeating characters is "abc".
	Example 2:
	
	Input: String="abbbb"
	Output: 2
	Explanation: The longest substring without any repeating characters is "ab".
	Example 3:
	
	Input: String="abccde"
	Output: 3
	Explanation: Longest substrings without any repeating characters are "abc" & "cde".
	
 * @author Er. Abraham Bisrat
 *
 */
public class longestDistinctSubstring {
	public static void main(String[] args) {
		System.out.println(longestDistinctSubString("aabccbb"));
		System.out.println(longestDistinctSubString("abbbb"));
		System.out.println(longestDistinctSubString("abccde"));//aaaxyzcdl"));
	}
	private static int longestDistinctSubString(String str) {
		System.out.println(str);
		int windowStart = 0;
		int maxLength = 0;
		Character current;
		Map<Character, Integer> charFreqMap = new HashMap<>();
		
		for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			current = str.charAt(windowEnd);
			while(charFreqMap.containsKey(current)) {
				charFreqMap.put(str.charAt(windowStart), charFreqMap.get(current) - 1);
				if(charFreqMap.get(current) == 0)
					charFreqMap.remove(current);
				windowStart++;
			}
			charFreqMap.put(current, charFreqMap.getOrDefault(current, 0) + 1);
			maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
//			System.out.println(charFreqMap);
		}
		return maxLength;
	}
}
