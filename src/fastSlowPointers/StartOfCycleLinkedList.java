package fastSlowPointers;

import java.util.Arrays;

import fastSlowPointers.DetectCycleInLinkedList.ListNode;

/**
 * Problem Statement #
	Given the head of a Singly LinkedList that contains a cycle, 
	write a function to find the starting node of the cycle.
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class StartOfCycleLinkedList {
	public static void p(Object line) { System.out.println(line); }
	public static void pA(int[] arr) { p(Arrays.toString(arr)); }

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		
		p(LinkedListCycleStart(head));
		
		head.next.next.next.next.next.next = head.next.next;
		p(LinkedListCycleStart(head));

		head.next.next.next.next.next.next = head.next.next.next;
		p(LinkedListCycleStart(head));
	}
	public static int LinkedListCycleStart(ListNode head) {
		if(head == null || head.next == null) return false;
		
		return 0;
	}
	// problem premise
	static class ListNode {
		private int value = 0;
		ListNode next;
		ListNode(int value) { this.value = value; }
	}
}
