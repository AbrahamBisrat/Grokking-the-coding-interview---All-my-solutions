package slidingWindow.smallestSubarrayWithGivenSum;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given an array of positive numbers and a positive number 'S', find the length 
 * of the smallest contiguous sub-array whose sum is greater than the given number k.
 * 
 * 	Input: [2, 1, 5, 2, 3, 2], S=7 
	Output: 2
	Explanation: The smallest sub-array with a sum great than or equal to '7' is [5, 2].
 * 
 * 
 *	Input: [2, 1, 5, 2, 8], S=7 
	Output: 1
	Explanation: The smallest sub-array with a sum greater than or equal to '7' is [8].
	
 * @author Abraham Bisrat
 *
 */

public class smallestSubArrayWithGivenSum {
	public static void main(String[] args) {
		System.out.println(smallestSubArrayWithSumK(new int[] {2, 1, 5, 2, 3, 2}, 7));
		
		System.out.println(smallestSubArrayWithSumK(new int[] {2, 1, 5, 2, 8}, 7));
		
		System.out.println(smallestSubArrayWithSumK(new int[] {3, 4, 1, 1, 6}, 8));
	}
	private static int smallestSubArrayWithSumK(int[] arr, int k) {
		int windowStart = 0;
		int windowSum = 0;
		int optimalSubArrayLength = Integer.MAX_VALUE;
		
		for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			windowSum += arr[windowEnd];
			
			while(windowSum >= k) {
				if(windowEnd - windowStart < optimalSubArrayLength)
					optimalSubArrayLength = windowEnd - windowStart + 1;
				windowSum -= arr[windowStart++];
			}
		}
		return optimalSubArrayLength;
	}
}
