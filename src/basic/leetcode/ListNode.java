package basic.leetcode;

public class ListNode {

	int val;
	ListNode next;// 下一个链表对象

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	ListNode(int x) {
		val = x;
	}

	public ListNode(int i, ListNode head) {
		
	};

	ListNode prev;

	public ListNode getPrev() {
		return null;
	}

	public void setPrev(ListNode prev) {
		this.prev = null;
	}

	@Override
	public String toString() {
		return "ListNode{" + "val=" + val + '}';
	}

}