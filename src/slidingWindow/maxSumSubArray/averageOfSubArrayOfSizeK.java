package slidingWindow.maxSumSubArray;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given an array, Find the average of all sub-arrays of "K" contiguous elements in it.
 * 
 * @author Er. Abraham Bisrat
 *
 */


public class averageOfSubArrayOfSizeK {
	public static void main(String[] args) {
		int[] testArray = {1, 3, 2, 6, -1, 4, 1, 8, 2};
		int k = 5; // k - contiguous elements 
		System.out.println("First Attempt : " + maxSumSubArrayAvg(testArray, k));
		System.out.println("Improved Attempt : " + maxSumSubArrayAvg(testArray, k));
	}

	/*
	 * O(N * K) k - being the size of the contiguous elements in a row
	 * and N being the elements of the given array 
	 */
	private static List<Float> maxSumSubArrayAvg(int[] arr, int k) {
		List<Float> resultSet = new ArrayList<>();
		for(int i = 0; i <= arr.length - k; i++) {
			float iterationSum = 0f;
			for(int j = 0; j < k; j++)
				iterationSum += arr[i+j];
			resultSet.add((float) (iterationSum/k));
		}
		return resultSet;
	}
	
	/*
	 * This is the improved version that takes O(N) time.
	 * This is achieved by using the sliding window principle
	 * re-use the computation of k-1 elements rather than doing it for every iteration
	 */
	private static List<Float> maxSumSubArrayAvgSlidingWindow(int[] arr, int k) {
		
	}
	
}
