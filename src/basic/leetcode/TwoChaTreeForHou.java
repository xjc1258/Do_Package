package basic.leetcode;
/*
 * @author xjc
 * @date 2021-06-05
 * @desc 二叉树的后序遍历
 */

import java.util.ArrayList;
import java.util.List;

public class TwoChaTreeForHou {

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		postorder(root, res);
		return res;
	}

	public void postorder(TreeNode root, List<Integer> res) {
		if (root == null) {
			return;
		}
		postorder(root.left, res);
		postorder(root.right, res);
		res.add(root.val);
	}

}
