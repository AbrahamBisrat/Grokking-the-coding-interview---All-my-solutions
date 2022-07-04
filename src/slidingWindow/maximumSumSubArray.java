package slidingWindow;

/**
 * Given an array of positive numbers and a positive number 'k',
 * find the maximum sum of any contiguous sub-array of size k;
 * 
 * Input: [2, 1, 5, 1, 3, 2], k=3 
 * Output: 9
 * Explanation: Sub-array with maximum sum is [5, 1, 3]
 * 
 * @author Er. Abraham Bisrat
 *
 */

public class maximumSumSubArray {
	
	public static void main(String[] args) {
		int[] testArray = {2, 1, 5, 1, 3, 2};
		int k = 3;
		System.out.println("Max sum of the contiguous values : " + maxSumSubArray(testArray, k));
		System.out.println("Same Concept different code : " + findMaxSubArray(testArray, k));
	}
	
	// O(N)
	private static int maxSumSubArray(int[] arr, int k) {
		int maxSum = 0;
		for(int i = 0; i < k; i++)
			maxSum += arr[i];
		int finalResult = maxSum;
		for(int i = 0; i < arr.length - k; i++) {
			maxSum -= arr[i];
			maxSum += arr[i+k];
			System.out.println(maxSum);
			if(maxSum > finalResult) finalResult = maxSum;
		}
		return finalResult;
	}
	
	/*
	 * Same concept but slightly different approach with the first iteration of filling the 
	 * 'k' elements.
	 * 
	 * TC - O(N)
	 * SC - O(1) - constant space, since we are only keeping track of the window elements.
	 * 
	 */
	private static int findMaxSubArray(int[] arr, int k) {
		int windowSum = 0;
		int maxSum = 0;
		int windowStart = 0;
		
		for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			windowSum += arr[windowEnd];
			// do not start working before the window has 'k' amount of items in the buffer.
			if(windowEnd >= k - 1) {
				maxSum = Math.max(maxSum, windowSum);
				windowSum -= arr[windowStart++];
			}
		}
		return maxSum;
	}
	
}
