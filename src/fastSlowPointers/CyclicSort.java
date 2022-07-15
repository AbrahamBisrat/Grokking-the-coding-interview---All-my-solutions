package fastSlowPointers;

import java.util.Arrays;

/**
 * Problem Statement #
	We are given an array containing ‘n’ objects. Each object, when created, 
	was assigned a unique number from 1 to ‘n’ based on their creation sequence.
	This means that the object with sequence number ‘3’ was created just before the object with sequence number ‘4’.
	Write a function to sort the objects in-place on their creation sequence number in O(n)O(n) 
	and without any extra space. For simplicity, let’s assume we are passed an integer 
	array containing only the sequence numbers, though each number is actually an object.

	Example 1:
	Input: [3, 1, 5, 4, 2]
	Output: [1, 2, 3, 4, 5]

	Example 2:
	Input: [2, 6, 4, 3, 1, 5]
	Output: [1, 2, 3, 4, 5, 6]

	Example 3:
	Input: [1, 5, 6, 4, 3, 2]
	Output: [1, 2, 3, 4, 5, 6]
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class CyclicSort {
	public static void p(Object line) { System.out.println(line); }
	public static void pA(int[] arr) { p(Arrays.toString(arr)); }

	public static void main(String[] args) {
		pA(cyclicSort(new int[] {3, 1, 5, 4, 2}));
		pA(cyclicSort(new int[] {2, 6, 4, 3, 1, 5}));
		pA(cyclicSort(new int[] {1, 5, 6, 4, 3, 2}));
	}
	public static int[] cyclicSort(int[] arr) {
		int index = 0;
		
		while(index < arr.length)
			if(arr[index] - 1 != index) swap(arr, index, arr[index] - 1);
			else index++;
		return arr;
	}
	static void swap(int[] arr, int from, int to) {
		int temp = arr[from];
		arr[from] = arr[to];
		arr[to] = temp;
	}
}
