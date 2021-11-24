package basic.leetcode;
/*
 * @author xjc
 * @date 2021-06-05
 * @desc 二叉树的前序遍历
 */

import java.util.ArrayList;
import java.util.List;

public class TwoChaTreeForward {

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		preorder(root, res);
		return res;
	}

	//递归遍历
	public void preorder(TreeNode root, List<Integer> res) {
		if (root == null) {
			return;
		}
		res.add(root.val);
		preorder(root.left, res);
		preorder(root.right, res);
	}

}
