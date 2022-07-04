package breadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalBST {
	class TreeNode {
		private TreeNode left;
		private TreeNode right;
		private int val;
		public TreeNode(int thatVal, TreeNode left, TreeNode right) {
			this.val = thatVal;
			this.right = right;
			this.left = left;
		}
	}
	public List<List<Integer>> levelOrder(TreeNode root) {
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
}
