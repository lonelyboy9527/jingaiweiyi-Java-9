package cc.openhome.class1;

import java.util.ArrayDeque;
import java.util.Deque;


public class MyStack {
	private Deque deque = new ArrayDeque();
	private int capacity;
	
	public MyStack(int capacity) {
		this.capacity = capacity;
	}
	
	public boolean push(Object o) {
		if (deque.size() + 1 > capacity) {
			return false;
		}
		return deque.offerLast(o); // 添加到最上
	}
	public Object pop() {
		return deque.pollLast(); // 最上的一个对象弹出（最后进的弹出）
	}
	public Object peek() {
		return deque.peekLast(); // 获取最上的对象（最后进的一个对象，但不弹出）
	}
	public int size() {
		return deque.size();
	}
}
