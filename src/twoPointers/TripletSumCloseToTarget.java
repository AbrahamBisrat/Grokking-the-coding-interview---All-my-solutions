package twoPointers;

import java.util.Arrays;

/**
 * Problem Statement #
	Given an array of unsorted numbers and a target number, find a triplet in the array whose sum is as close to the target number as possible, return the sum of the triplet. If there are more than one such triplet, return the sum of the triplet with the smallest sum.
	
	Example 1:
	Input: [-2, 0, 1, 2], target=2
	Output: 1
	Explanation: The triplet [-2, 1, 2] has the closest sum to the target.

	Example 2:
	Input: [-3, -1, 1, 2], target=1
	Output: 0
	Explanation: The triplet [-3, 1, 2] has the closest sum to the target.

	Example 3:
	Input: [1, 0, 1, 1], target=100
	Output: 3
	Explanation: The triplet [1, 1, 1] has the closest sum to the target.
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class TripletSumCloseToTarget {
	public static void p(Object line) { System.out.println(line); }
	public static void pA(int[] arr) { p(Arrays.toString(arr)); }

	public static void main(String[] args) {
		p(tripletSumCloseToTarget(new int[] {-2, 0, 1, 2}, 2));
		p(tripletSumCloseToTarget(new int[] {-3, -1, 1, 2}, 1));
		p(tripletSumCloseToTarget(new int[] {1, 0, 1, 1}, 100));
	}
	public static int tripletSumCloseToTarget(int[] arr, int targetSum) {
		if(arr == null || arr.length == 0) throw new IllegalArgumentException("Illegal input");
		int smallestDiff = Integer.MAX_VALUE;

		Arrays.sort(arr);
		
		for(int i = 0; i < arr.length; i++) {
			int left = i + 1;
			int right = arr.length - 1;
			
			while(right > left) {
				int targetDiff = targetSum - arr[i] - arr[left] - arr[right];
				
				if(targetDiff == 0) return targetSum - targetDiff;
				
				if(Math.abs(targetDiff) < Math.abs(smallestDiff) 
						|| (Math.abs(targetDiff) == Math.abs(smallestDiff) && targetDiff > smallestDiff)) {
					smallestDiff = targetDiff;
				}
				if(targetDiff > 0) left ++;
				else right--;
			}
		}
		return targetSum - smallestDiff;
	}
}
