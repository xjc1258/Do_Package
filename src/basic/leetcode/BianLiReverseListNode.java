package basic.leetcode;

/*
 *  data域：存储数据元素信息的域称为数据域；　
    next域：存储直接后继位置的域称为指针域，它是存放结点的直接后继的地址（位置）的指针域（链域）。
    data域+ next域：组成数据ai的存储映射，称为结点；
 */
//通俗的讲就是和谐号，node就是车厢，next就是钢丝绳
public class BianLiReverseListNode {

	public static void main(String[] args) {
		Node head = new Node(0);
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		head.setNext(node1);
		node1.setNext(node2);
		node2.setNext(node3);
		// 打印反转前的链表
		Node h = head;
		while (null != h) {
			System.out.print(h.getData() + " ");
			h = h.getNext();
		}
		// 调用反转方法------------------------只要给了头，那整个火车就自然而然的查出来了
		head = Reverse1(head);

		System.out.println("\n**************************");
		// 打印反转后的结果
		while (null != head) {
			System.out.print(head.getData() + " ");
			head = head.getNext();
		}
	}

	/**
	 * 递归，在反转当前节点之前先反转后续节点
	 */
	public static Node Reverse1(Node head) {
		// head看作是前一结点，head.getNext()是当前结点，reHead是反转后新链表的头结点
		if (head == null || head.getNext() == null) {
			return head;// 若为空链或者当前结点在尾结点，则直接还回
		}
		Node reHead = Reverse1(head.getNext());//
		head.getNext().setNext(head);// 将当前结点的指针域指向前一结点
		head.setNext(null);// 前一结点的指针域令为null;
		return reHead;// 反转后新链表的头结点
	}

}
