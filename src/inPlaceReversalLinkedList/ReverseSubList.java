package inPlaceReversalLinkedList;

import java.util.Arrays;


/**
 *	Problem Statement #
	Given the head of a LinkedList and two positions ‘p’ and ‘q’, 
	reverse the LinkedList from position ‘p’ to ‘q’.
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class ReverseSubList {
	public static void p(Object line) { System.out.println(line); }
	public static void pA(int[] arr) { p(Arrays.toString(arr)); }

	static class ListNode {
		int value = 0;
		ListNode next;
		ListNode(int val) { value = val; }
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		ListNode result = reverseLinkedListInRange(head, 2, 4);
		p("Nodes of the reversed LinkedList are : ");
		
		while(result != null) {
			p(result.value + " ");
			result = result.next;
		}
	}
	static ListNode reverseLinkedListInRange(ListNode head, int start, int end) {
		if(head == null || start == end) return head;
		
		ListNode prev = null;
		ListNode current = head;
		
		int i = 0;
		
		// skip till the start position
		while(current != null && i++ < start - 1) {
			prev = current;
			current = current.next;
		}
		
		// now we are in range of start - end;
		// so lets first save the end of our previous position;
		ListNode tailOfFirstPart = prev;
		// initialize the end position of the secondPart
		ListNode headOfSecondPart = current;
		
		// update the headOfSecondPart
		while(current != null && i++ < end + 1) {
			ListNode temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		// tie them back together
		
		if(tailOfFirstPart != null) tailOfFirstPart.next = prev;
		else head = prev;
		
		// connect with the last part
		headOfSecondPart.next = current;
		return head;
	}
}
