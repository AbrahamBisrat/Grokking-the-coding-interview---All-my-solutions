package breadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraversalBST {
	static class TreeNode {
		private TreeNode left;
		private TreeNode right;
		private int val;
		TreeNode(int thatVal) {
			this.val = thatVal;
		}
	}
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> allLevels = new ArrayList<>();
		if(root == null) return allLevels;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> levelData = new ArrayList<>();
			while(levelSize > 0) {
				TreeNode currentNode = queue.poll();
				levelData.add(currentNode.val);
				
				// if it has children add them
				if(currentNode.right != null)
					queue.add(currentNode.right);
				if(currentNode.left != null)
					queue.add(currentNode.left);
				
				levelSize--;
			}
			allLevels.add(levelData);
		}
		return allLevels;
	}
	public static List<List<Integer>> reverseLevelOrder(TreeNode root) {
		List<List<Integer>> allReverseLevels = new ArrayList<>();
		if(root == null) return allReverseLevels;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		Stack<List<Integer>> reverseOrderStack = new Stack<>();
		
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
			reverseOrderStack.push(levelData);
		}
		while(!reverseOrderStack.isEmpty())
			allReverseLevels.add(reverseOrderStack.pop());
		return allReverseLevels;
	}
	static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		p(levelOrder(root));
		p(reverseLevelOrder(root));
	}
}
