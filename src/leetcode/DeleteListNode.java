package leetcode;

public class DeleteListNode {
	/*
	 * @author xjc
	 * 
	 * @date 2021-05-12
	 * 
	 * @desc 删除链表的特定节点 因为无法获得当前节点的前一个节点，所以就让后一个节点的值前移
	 */

	public static void deleteNode(ListNode a, ListNode node) {
		while (a != null) {
			if (a.getVal() == node.getVal()) {
				if (a.next != null) {
					// 后面值前移
					a.setVal(a.next.getVal());
					// 删除后面的节点
					a.next = a.next.next;
				} else {
					// 删除最后一个节点
					a = null;
				}

			} else {
				a = a.next;
			}
		}
	}

	public static void main(String[] args) {

		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		ListNode f = new ListNode(6);
		ListNode g = new ListNode(7);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;
		ListNode tar = new ListNode(7);
		deleteNode(tar, a);
		while (a != null) {
			System.out.println(a.getVal() + "");
			a = a.next;
		}
	}

	/*
	 * 官方的答案
	 */
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}

}
