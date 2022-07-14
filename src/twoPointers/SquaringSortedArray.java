package twoPointers;

import java.util.Arrays;

/**
 * Problem Statement #
	Given a sorted array, create a new array containing squares of all the number of the input array in the sorted order.

	Example 1:
	Input: [-2, -1, 0, 2, 3]
	Output: [0, 1, 4, 4, 9]

	Example 2:
	Input: [-3, -1, 0, 1, 2]
	Output: [0 1 1 4 9]
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class SquaringSortedArray {
	public static void p(Object line) { System.out.println(line); }
	public static void pA(int[] arr) { p(Arrays.toString(arr)); }

	public static void main(String[] args) {
		pA(squareSortedArray(new int[] {-2, -1, 0, 2, 3}));
		pA(squareSortedArray(new int[] {-3, -1, 0, 1, 2}));
	}
	public static int[] squareSortedArray(int[] arr) {
		int[] result = new int[arr.length];
		int left = 0;
		int right = arr.length - 1;
		
		for(int i = arr.length - 1; i >= 0; i--) {
			if(Math.abs(arr[right]) >= Math.abs(arr[left])) {
				result[i] = arr[right] * arr[right];
				right--;
			} else {
				result[i] = arr[left] * arr[left];
				left++;
			}
		}
		return result;
	}
}
