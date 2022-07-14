package twoPointers;

import java.util.Arrays;

/**
 * Problem Statement #
	Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
	Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.
	
	Example 1:
	Input: [1, 2, 3, 4, 6], target=6
	Output: [1, 3]
	Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6

	Example 2:
	Input: [2, 5, 9, 11], target=11
	Output: [0, 2]
	Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class PairWithTargetSum {
	public static void p(Object line) { System.out.println(line); }
	public static void pA(int[] arr) { p(Arrays.toString(arr)); }
	public static void main(String[] args) {
		pA(pairWithTarget(new int[] {1, 2, 3, 4, 6}, 6));
		pA(pairWithTarget(new int[] {2, 5, 9, 11}, 11));
	}
	static int[] pairWithTarget(int[] arr, int target) {
		if(arr == null || arr.length == 0) return null;
		int left = 0;
		int right = arr.length - 1;
		
		while(right > left) {
			int sum = arr[left] + arr[right];
			if(sum == target) return new int[] {left, right};
			
			else if(sum > target) right--;
			else left++;
		}
		return null;
	}
}
