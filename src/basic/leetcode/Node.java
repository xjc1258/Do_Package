package basic.leetcode;

public class Node {
	private int Data;// 数据域
	private Node Next;// 指针域

	
	//有参构造函数
	public Node(int Data) {
		// super();
		this.Data = Data;
	}

	public int getData() {
		return Data;
	}

	public void setData(int Data) {
		this.Data = Data;
	}

	public Node getNext() {
		return Next;
	}

	public void setNext(Node Next) {
		this.Next = Next;
	}
}
