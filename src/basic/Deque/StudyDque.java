package basic.Deque;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/*
 * @author xjc
 * @date 2021-05-25
 * @desc 
 */
public class StudyDque {

	// Deque是一个双端队列接口，继承自Queue接口，Deque的实现类是LinkedList、ArrayDeque、LinkedBlockingDeque，
	// 其中LinkedList是最常用的。
	public static void main(String[] args) {
		// 普通队列(一端进一端出)
		Queue queue = new LinkedList();
		Deque deque = new LinkedList();
		// 双端队列(两端都可以进出) ,还要类似堆栈
		Deque hque = new LinkedList();
		// Stack类已经过时了，用deque来替代，堆栈的操作的方法是：push()，pop(),peek()

	}

	@Test
	public void queue() {
		// queue是一个先进先出的队列
		Queue<String> queue = new LinkedList();
		queue.offer("薛");
		queue.offer("景");
		queue.offer("超");
		while (queue.size() > 0) {
			String element = queue.poll();
			System.out.println(element);
		}
	}

	@Test
	public void TestQueue() {
		Deque deque = new LinkedList();
		
		
		
		
	}

}
