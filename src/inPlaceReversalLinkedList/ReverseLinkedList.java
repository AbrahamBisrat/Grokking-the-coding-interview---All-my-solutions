package inPlaceReversalLinkedList;

import java.util.Arrays;

/**
 *  Problem Statement #
	Given the head of a Singly LinkedList, reverse the LinkedList.
	Write a function to return the new head of the reversed LinkedList.
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class ReverseLinkedList {
	public static void p(Object line) { System.out.println(line); }
	public static void pA(int[] arr) { p(Arrays.toString(arr)); }

	static class ListNode {
		int value = 0;
		ListNode next;
		ListNode(int val) { value = val; }
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(4);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(8);
		head.next.next.next.next = new ListNode(10);
		
		ListNode result = reverseLinkedList(head);
		p("Nodes of the reversed LinkedList are : ");
		
		while(result != null) {
			p(result.value + " ");
			result = result.next;
		}
	}
	static ListNode reverseLinkedList(ListNode head) {
		if(head == null) return head;
		ListNode prev = null;
		ListNode current = head;
		
		while(current != null) {
			ListNode temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		return prev;
	}
}