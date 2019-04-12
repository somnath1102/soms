package com.somnath.leetcode.binary.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LevelOrderTreeTraversal {
	List<List<Integer>> output;
	List<List<TreeNode>> levelwiseNodes;

	public List<List<Integer>> levelOrder(TreeNode root) {
		int level = 0;
		if (output == null) {
			output = new ArrayList<List<Integer>>();
			output.add(new ArrayList<Integer>());
			levelwiseNodes = new ArrayList<List<TreeNode>>();
			levelwiseNodes.add(Arrays.asList(new TreeNode[] { root }));
		}

		while (true) {
			for (TreeNode t : levelwiseNodes.get(level)) {
				if (output.size() <= level) {
					output.add(new ArrayList<Integer>());
				}
				output.get(level).add(t.val);
				if (t.left != null || t.right != null) {
					if (levelwiseNodes.size() <= (level + 1))
						levelwiseNodes.add(new ArrayList<TreeNode>());
					if (t.left != null)
						levelwiseNodes.get(level + 1).add(t.left);
					if (t.right != null)
						levelwiseNodes.get(level + 1).add(t.right);
				}
			}
			level++;
			if (levelwiseNodes.size() <= level)
				break;
		}
		return output;
	}

	public static void main(String[] args) {
		 TreeNode root = CreateTree.createTree(new Integer []
		 {1,11,12,111,112,121,122,1111,1112,1121,1122,1211,1212});
		 //System.out.println(root);
		LevelOrderTreeTraversal t = new LevelOrderTreeTraversal();
		// System.out.println(Arrays.toString(t.levelOrder(createTree(new
		// Integer[] { 1, 2 })).toArray()));
		//System.out.println((int) 'h' - 'a');
	}
}
