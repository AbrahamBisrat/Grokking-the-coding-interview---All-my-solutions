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
		
		p(linkedListCycleLength(head));
		//////////////////////////////////////////////////////////////////////////////////
		head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = head.next.next;
		
		p(hasCycle(head));
		p(linkedListCycleLength(head));
		head.next.next.next.next.next.next = head.next.next.next;
		p(linkedListCycleLength(head));
	}
	public static boolean hasCycle(ListNode head) {
		if(head == null || head.next == null) return false;
		
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(fast == slow) return true;
		}
		return false;
	}
	public static int linkedListCycleLength(ListNode head) {
		if(head == null || head.next == null) return 0;
		
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(fast == slow) return findCycleLength(slow);
		}
		return 0;
	}
	public static int findCycleLength(ListNode start) {
		int length = 1;
		ListNode temp = start.next;
		while(!start.equals(temp)) {
			length++;
			temp = temp.next;
		}
		return length;
	}
	// problem premise
	static class ListNode {
		private int value = 0;
		ListNode next;
		ListNode(int value) { this.value = value; }
	}
}
