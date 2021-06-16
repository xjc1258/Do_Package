package leetcode;

import java.util.Stack;

public class StackReverse {
	public static void main(String[] args) {
		ListNode a = new ListNode(0);
		ListNode b = new ListNode(1);
		ListNode c = new ListNode(2);
		ListNode d = new ListNode(3);
		ListNode e = new ListNode(4);
		ListNode f = new ListNode(5);
		ListNode g = new ListNode(6);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;
		print(reverseList(a));
	}

	private static void print(ListNode head) {
		while (head != null) {
			System.out.println(head.getVal() + " ");
			head = head.next;
		}
	}

	/*
	 * 利用栈的特点来进行节点的反
	 */
	public static ListNode reverseList(ListNode head) {
		Stack<ListNode> stack = new Stack<ListNode>();
		ListNode pre;
		// 将节点依次入栈
		while (head != null) {
			stack.push(head);
			head = head.next;
		}
		if (stack.isEmpty()) {
			return null;
		}
		/*
		 * stack.pop()和stack.peek()的区别 相同点：大家都返回栈顶的值。 不同点：peek
		 * 不改变栈的值(不删除栈顶的值)，pop会把栈顶的值删除。
		 */
		ListNode node = stack.pop();//返回栈顶的元素，并且弹出 ====》这个是临时的量
		pre = node;
		while (!stack.isEmpty()) {
			ListNode tempNode = stack.pop();
			node.next = tempNode;
			node = node.next;
		}
		node.next = null;
		return pre;
	}
}
