package cc.openhome.class1;

public class SimpleLinkedList {
	// 将收集的对象用Node封装 （内部类）
	private class Node {
		Object o;  // 当前节的对象
		Node next; // 下一个节点(指向)
		public Node(Object o) {
			this.o = o;
		}
	}
	
	private Node first; // 第一个节点
	
	public void add(Object o) { // 新增Node 封装对象，并由上一个Node的next参考
		if (first == null) {
			// 设置第一个节点的值
			first = new Node(o);
		} else {
			Node last = first;
			// 从第一个节点first 遍历到最后一个节点
			while (last.next != null) {
				last = last.next;
			}
			last.next = new Node(o); // 最后一个节点指向的下一个对象是当前新加的对象
		}
	}
	
	public int size() { // 访问所有的Node并计数以取得长度。
		int count = 0;
		Node last = first; // 是不是有点问题？如果存在第一个节点，count应该是1？
						   // 改造
		if (last != null) {
			count = 1;
		}
		while (last.next != null) {
			last = last.next;
			count ++;
		}
		return count;
	}
	
	public Object get(int index) { // 访问所有Node并计数以取得对应的索引对象。
		int size = size();
		if (index >= size) {
			// 抛出超过边界的异常
			throw new IndexOutOfBoundsException(String.format("Index: %d, Size: %d", index, size));
		}
		int count = 0;
		Node last = first;
		// 从first开始遍历所有的Node
		while (count < index) {
			last = last.next;
			count ++;
		}
		return last.o;
	}
}
