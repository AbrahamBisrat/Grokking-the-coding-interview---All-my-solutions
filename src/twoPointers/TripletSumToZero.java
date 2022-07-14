package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem Statement #
	Given an array of unsorted numbers, find all unique triplets in it that add up to zero.

	Example 1:
	Input: [-3, 0, 1, 2, -1, 1, -2]
	Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
	Explanation: There are four unique triplets whose sum is equal to zero.

	Example 2:
	Input: [-5, 2, -1, -2, 3]
	Output: [[-5, 2, 3], [-2, -1, 3]]
	Explanation: There are two unique triplets whose sum is equal to zero.
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class TripletSumToZero {
	public static void p(Object line) { System.out.println(line); }
	public static void pA(int[] arr) { p(Arrays.toString(arr)); }

	public static void main(String[] args) {
		List<int[]> result = tripletSumToZero(new int[] {-3, 0, 1, 2, -1, 1, -2});
		for(int[] eachArray : result) pA(eachArray);
		
		result = tripletSumToZero(new int[] {-5, 2, -1, -2, 3});
//		for(int[] eachArray : result) pA(eachArray);
	}
	public static List<int[]> tripletSumToZero(int[] arr) {
		List<int[]> result = new ArrayList<>();
		Arrays.sort(arr);
		for(int i = 0; i < arr.length; i++) {
			int target = -arr[i];
			
			int left = i + 1;
			int right = arr.length - 1;
			while(right >= left) {
				int currentSum = arr[right] + arr[left];
				if(currentSum == target) {
					result.add(new int[] {-target, arr[left], arr[right]});
					left++;
					right--;
					while(right > left && arr[left] == arr[left + 1]) left++;
					while(right > left && arr[right] == arr[right - 1]) right--;
				}
				else if(target > currentSum) left++;
				else right--;
			}
		}
		return result;
	}
}
