package fastSlowPointers;

import java.util.Arrays;

/**
 * Problem Statement #
	Given the head of a Singly LinkedList, 
	write a function to determine if the LinkedList has a cycle in it or not.
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class DetectCycleInLinkedList {
	public static void p(Object line) { System.out.println(line); }
	public static void pA(int[] arr) { p(Arrays.toString(arr)); }

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		
		p(hasCycle(head));
		
		head.next.next.next.next.next.next = head.next.next;
		p(hasCycle(head));

		head.next.next.next.next.next.next = head.next.next.next;
		p(hasCycle(head));
	}
	public static boolean hasCycle(ListNode head) {
		if(head == null || head.next == null) return false;
		
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast != null && fast.next == null) {
			slow = slow.next;
			fast = fast.next.next;
			if(fast.equals(slow)) return true;
		}
		return false;
	}
	
	
	// problem premise
	static class ListNode {
		private int value = 0;
		ListNode next;
		ListNode(int value) { this.value = value; }
	}
}
