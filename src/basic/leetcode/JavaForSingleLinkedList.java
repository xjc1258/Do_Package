package basic.leetcode;

import java.util.ArrayList;

public class JavaForSingleLinkedList<T> {
	// 定义结点类
	public class ListNode<T> {
		T val;
		ListNode<T> next = null;

		ListNode(T val) {
			this.val = val;
		}
	}

	public ListNode<T> head;

	public JavaForSingleLinkedList() {
		this.head = new ListNode<T>(null);
	}

	// 由指定数组中的多个对象构建单链表，采用【尾插法】构建单链表，并实现逆序输出
	public JavaForSingleLinkedList(T[] element) {
		this();// 初始头结点为空
		ListNode<T> rear = this.head;
		for (int i = 0; i < element.length; i++) {
			rear.next = new ListNode<T>(element[i]);
			rear = rear.next;
		}
		System.out.println(printListFromTailToHead(head.next));// 在初始化方法中调用printListFromTailToHead方法可保证参数是结点类型
																// 此处传入参数为head.next；如果是head，会输出头结点的null值
	}

	// 按链表从尾到头的顺序返回一个ArrayList
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		if (listNode == null) {
			return arrayList;
		}
		while (listNode != null) {
			arrayList.add(0, (Integer) listNode.val);// 始终将遍历到链表的数据插入到arrayList的第一个位置，即保证输出结果与原链表逆序
			listNode = listNode.next;
		}
		return arrayList;
	}

	public static void main(String[] args) {
		// 通过结点类定义单链表
		Integer[] a = { 1, 2, 3, 4, 5, 7, 8, 9, 10 };
		JavaForSingleLinkedList<Integer> list = new JavaForSingleLinkedList<Integer>(a);

	}

}