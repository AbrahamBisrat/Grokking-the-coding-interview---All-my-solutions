package breadthFirstSearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

/**
 * ZigZag order traversal of a binary search tree
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class ZigZagOrderTraversal {
	static class TreeNode {
		private TreeNode left;
		private TreeNode right;
		private int val;
		TreeNode(int thatVal) {
			this.val = thatVal;
		}
	}
	static void p(Object line) { System.out.println(line); }
	static List<List<Integer>> zigzagLevelOrderTraversal(TreeNode root) {
		List<List<Integer>> allZigzagTraversal = new ArrayList<>();
		if(root == null) return allZigzagTraversal;
		
		Queue<TreeNode> queue = new LinkedList<>();
		// the trick here is to reverse one order and to not reverse the other based on level even or odd
		queue.add(root);
		
		// keep a level counter to reverse on even and not to reverse on odd
		boolean reverse = false;
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> levelData = new ArrayList<>();
			while(levelSize-- > 0) {
				TreeNode currentNode = queue.poll();
				levelData.add(currentNode.val);
				
				if(currentNode.right != null)
					queue.add(currentNode.right);
				if(currentNode.left != null)
					queue.add(currentNode.left);
			}
			reverse = !reverse;
			if(reverse) Collections.reverse(levelData);
			allZigzagTraversal.add(levelData);
		}
		return allZigzagTraversal;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		p(zigzagLevelOrderTraversal(root));
		/* level order normal traversal
		 * [[12], [1, 7], [5, 10, 9]]
		 */
	}
}
