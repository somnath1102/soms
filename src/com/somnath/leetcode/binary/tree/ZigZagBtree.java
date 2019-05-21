package com.somnath.leetcode.binary.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagBtree {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		// do bfs
		if (root == null)
			return null;
		Queue<TreeNode> q = new LinkedList<>();
		List<List<Integer>> r = new ArrayList<List<Integer>>();
		q.offer(root);
		boolean flip = false;
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> l = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode poll = q.poll();
				l.add(poll.val);
				if (poll.left != null)
					q.offer(poll.left);
				if (poll.right != null)
					q.offer(poll.right);
			}
			if (flip) {
				Collections.reverse(l);
			}
			r.add(l);
			flip = !flip;
		}
		return r;
	}

}
