package cyclicSort;

import java.util.Arrays;

/**
 * 	Problem Statement #
	We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’.
	Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, find the missing number.

	Example 1:
	Input: [4, 0, 3, 1]
	Output: 2

	Example 2:
	Input: [8, 3, 5, 2, 4, 6, 0, 1]
	Output: 7
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class FindMissingNumber {
	public static void p(Object line) { System.out.println(line); }
	public static void pA(int[] arr) { p(Arrays.toString(arr)); }

	public static void main(String[] args) {
		p(findMissingNumber(new int[] {4, 0, 3, 1}));
		p(findMissingNumber(new int[] {8, 3, 5, 2, 4, 6, 0, 1}));
	}
	public static int findMissingNumber(int[] arr) {
		
		
		return 0;
	}
}
