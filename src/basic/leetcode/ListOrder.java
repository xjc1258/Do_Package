package leetcode;

public class ListOrder {

	// 有序链表，去重复的
	public static ListNode deleteDuplicates(ListNode head) {
		// 没有节点或者只有一个节点，必然没有重复的元素
		if (head == null || head.next == null) {
			return head;
		}
		// 当前节点和下一个节点，值不同，则head的值是需要保留的，对head.next继续递归
		if (head.val != head.next.val) {
			head.next = deleteDuplicates(head.next);
			return head;
		} else {
			// 当前节点与下一个节点的值重复了，重复的值都不能要
			// 一直往下找，找不到重复的节点，返回对不重复节点的递归结果
			ListNode notDup = head.next.next;
			while (notDup != null && notDup.val == head.val) {
				notDup = notDup.next;

			}
			return deleteDuplicates(notDup);
		}

	}

	public static ListNode createListNode() {

		ListNode nodestr = new ListNode(0); // 创建首结点
		ListNode nextNode; // 创建下一个结点
		nextNode = nodestr; // 指向首结点
		// 创建链表
		for (int i = 0; i < 10; i++) {
			ListNode newnode = new ListNode(i); // 创建新的结点
			nextNode.next = newnode; // 把新结点连起来
			nextNode = nextNode.next; // 把结点往后移
		} // nextNode指向最后一个结点
		nextNode = nodestr; // 重新指向首结点
		// 打印
		while (nextNode != null) {
			System.out.println("第一个结点值：" + nextNode.val);
			nextNode = nextNode.next;
		}
		System.out.println(nodestr.toString());
		return nodestr;

	}

	public static void main(String[] args) {
		/*
		 * ListNode head = new ListNode(1); ListNode first = new ListNode(2);
		 * ListNode second = new ListNode(3); ListNode third = new ListNode(3);
		 * ListNode four = new ListNode(3); ListNode five = new ListNode(4);
		 * ListNode six = new ListNode(5); ListNode serven = new ListNode(6);
		 * deleteDuplicates(head);
		 */
		deleteDuplicates(createListNode());
	}

}
