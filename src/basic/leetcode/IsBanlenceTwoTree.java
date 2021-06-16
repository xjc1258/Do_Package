package basic.leetcode;

/*
 * 
 * @author xjc
 * @date 2021-05-13
 * @desc 是否是平衡二叉树
 */
public class IsBanlenceTwoTree {
	/*
	 * 方法一：自顶向下的递归
	 */
	public boolean isBalancedOne(TreeNode root) {
		if (root == null) {
			return true;
		} else {
			return Math.abs(heightOne(root.left) - heightOne(root.right)) <= 1 && isBalancedOne(root.left)
					&& isBalancedOne(root.right);
		}
	}

	public int heightOne(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			return Math.max(heightOne(root.left), heightOne(root.right)) + 1;
		}
	}

	/*
	 * 方法二：自底向上的递归
	 */
	public boolean isBalancedTwo(TreeNode root) {
		return heightTwo(root) >= 0;
	}

	public int heightTwo(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = heightTwo(root.left);
		int rightHeight = heightTwo(root.right);
		if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}

}
