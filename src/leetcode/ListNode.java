package leetcode;

public class ListNode {

	int val;

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	ListNode next;// 下一个链表对象

	ListNode(int x) {
		val = x;
	}

	public ListNode(int i, ListNode head) {
	}; // 赋值链表的值
}