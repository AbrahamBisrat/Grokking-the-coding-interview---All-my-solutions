package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 	Problem Statement #
	Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter, find the length of the longest substring having the same letters after replacement.
	
	Example 1:
	
	Input: String="aabccbb", k=2
	Output: 5
	Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
	Example 2:
	
	Input: String="abbcb", k=1
	Output: 4
	Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".
	Example 3:
	
	Input: String="abccde", k=1
	Output: 3
	Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
	
 * @author Er. Abraham Bisrat
 *
 */
public class longestSubStringWithSameLettersAfterReplacement {
	// do the longest substring first and then proceed to add the replacement logic in it.
	
	public static void main(String[] args) {
		System.out.println(longestSubStringWithSameLettersAfterReplacement("aabccbb", 2));
		System.out.println(longestSubStringWithSameLettersAfterReplacement("abbcb", 1));
		System.out.println(longestSubStringWithSameLettersAfterReplacement("abccde", 1));
	}
	private static int longestSubStringWithSameLettersAfterReplacement(String str, int k) {
		int windowStart = 0;
		int maxLength = 0;
		int maxRepeatCount = 0;
		Map<Character, Integer> charFreqMap = new HashMap<>();		
		
		char rightChar;
		for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			rightChar = str.charAt(windowEnd);
			charFreqMap.put(rightChar, charFreqMap.getOrDefault(rightChar, 0) + 1);
			maxRepeatCount = Math.max(maxRepeatCount, charFreqMap.get(rightChar));
			
			if(windowEnd - windowStart + 1 - maxRepeatCount > k) {
				char leftChar = str.charAt(windowStart);
				charFreqMap.put(leftChar, charFreqMap.get(leftChar) - 1 );
				windowStart++;
			}	
			maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
		}
		
		return maxLength;
	}
}




