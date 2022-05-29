package slidingWindow.fruitsIntoBasket;

import java.util.HashMap;
import java.util.Map;

/**
 *	Problem Statement #
	Given an array of characters where each character represents a fruit tree, you are given two baskets and your goal is to put maximum number of fruits in each basket. The only restriction is that each basket can have only one type of fruit.
	
	You can start with any tree, but once you have started you can’t skip a tree. You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.
	
	Write a function to return the maximum number of fruits in both the baskets.
	
	Example 1:
	
	Input: Fruit=['A', 'B', 'C', 'A', 'C']
	Output: 3
	Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
	Example 2:
	
	Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
	Output: 5
	Explanation: We can put 3 'B' in one basket and two 'C' in the other basket. 
	This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']
	
 * @author Abraham Bisrat
 *
 */
public class fruitsIntoBasket {
	public static void main(String[] args) {
		System.out.println(maxFruitsIntoTwoBaskets(new Character[] {'A', 'B', 'C', 'A', 'C'}));
		System.out.println(maxFruitsIntoTwoBaskets(new Character[] {'A', 'B', 'C', 'B', 'B', 'C'}));
	}
	private static int maxFruitsIntoTwoBaskets(Character[] arr) {
		if(arr.length < 2) throw new IllegalArgumentException("Invalid input");
		Map<Character, Integer> charFrequencyMap = new HashMap<>();
		int max = 0;
		int secondMax = 0;
		for(Character each : arr) {
			charFrequencyMap.put(each, charFrequencyMap.getOrDefault(each, 0) + 1);
			if(charFrequencyMap.get(each) > max) {
				secondMax = max;
				max = charFrequencyMap.get(each);
			}
			System.out.println(charFrequencyMap);
		}
		return max + secondMax;
	}
}
