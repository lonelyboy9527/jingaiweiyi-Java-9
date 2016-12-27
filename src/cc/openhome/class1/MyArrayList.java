package cc.openhome.class1;

import java.util.Arrays;

import org.omg.CORBA.portable.IndirectionException;

public class MyArrayList <E> { // 此类支持泛型

	private Object[] list;
	private int next;
	public MyArrayList(int capacity) {
		// TODO Auto-generated constructor stub
		list = new Object[capacity];
	}
	
	public MyArrayList() {
		// TODO Auto-generated constructor stub
		this(16);
	}
	
	public void add(E e) { // 加入的对象必须是客户端声明的E类型
		if (next == list.length) {
			list = Arrays.copyOf(list, list.length * 2);
		}
		list[next++] = e;
	}
	public E get(int index) { // 取回对象以客户端声明的E类型返回 
		E e = (E)list[index];
		return e;
	}
	public int size() {
		return next;
	}
}
