package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.

	Example 1:
	
	Input: String="araaci", K=2
	Output: 4
	Explanation: The longest substring with no more than '2' distinct characters is "araa".
	Example 2:
	
	Input: String="araaci", K=1
	Output: 2
	Explanation: The longest substring with no more than '1' distinct characters is "aa".
	Example 3:
	
	Input: String="cbbebi", K=3
	Output: 5
	Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
 * 
 * 
 */

public class longestSubArrayWithKDistinctElements {
	public static void main(String[] args) {
		System.out.println(longestSubArrayWithKDistinctElement("araaci", 2));
		System.out.println(longestSubArrayWithKDistinctElement("araaci", 1));
		System.out.println(longestSubArrayWithKDistinctElement("cbbebi", 3));
	}
	private static int longestSubArrayWithKDistinctElement(String str, int k) {
		System.out.println("\n" + str + "\t with distinct elements of : " + k);
		if(str == null || str.length() == 0 || k > str.length())
			throw new IllegalArgumentException("Input invalid");
		
		int windowStart = 0, maxLength = 0;
		Map<Character, Integer> charFrequencyMap = new HashMap<>();
		
		for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			char rightChar = str.charAt(windowEnd);
			charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);
			
			// Shrink the sliding window, until we are left with 'k' distinct characters in the frequency map
			while(charFrequencyMap.size() > k) {
				char leftChar = str.charAt(windowStart);
				charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
				if(charFrequencyMap.get(leftChar) == 0)
					charFrequencyMap.remove(leftChar);
				windowStart++; // Shrink the window
				System.out.println(charFrequencyMap);
			}
			// if the window is larger than the previous value, remember it.
			maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
		}
		return maxLength;
	}
}
