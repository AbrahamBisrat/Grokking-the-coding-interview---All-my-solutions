package slidingWindow.smallestSumSubArray;

/**
 * 
 * Given an array of positive numbers and a positive number ‘S’, 
 * find the length of the smallest contiguous sub-array whose sum is 
 * greater than or equal to ‘S’. Return 0, if no such sub-array exists.
 * 
 * Input: [2, 1, 5, 2, 3, 2], S=7 
	Output: 2
	Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2].
 * 
 * @author Er. Abraham Bisrat
 *
 */

public class smallestSumSubArray {
	public static void main(String[] args) {
		int[] testArray = {2, 1, 5, 2, 3, 2};
		int k = 7;
		System.out.println("The smallest sum of all contiguous subsets is : " + smallestSumSubArray(testArray, k));
	}
	
	private static int smallestSumSubArray(int[] arr, int k) {
		int windowSum = 0;
		int minSum = 0;
		int windowStart = 0;
		
		for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			windowSum += arr[windowEnd];
			System.out.println(windowSum);
			if(windowEnd >= k - 1) {
				// the buffer has filled
				minSum = Math.min(minSum, windowSum);
				windowSum -= arr[windowStart++];
			}
		}
		return minSum;
	}
}
