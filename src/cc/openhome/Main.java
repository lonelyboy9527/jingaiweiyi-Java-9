package cc.openhome;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		exp1();
		exp2();
	}
	/* ********************9.2 键值对应的Map******************** */
	public static void exp2() {
		/* 就像查字典，根据某个键(Key)来取得对应的值(Value)。
		 * 
		 * 可以事先利用 java.util.Map接口的操作对象来建立键值对应数据，
		 * 之后若要取值，只要利用对应的键就可以迅速取得。
		 * */
//		MyClass2.exp1(); // 9.2.1 常用 Map操作类
		MyClass2.exp2(); // 9.2.2 访问Map 键值
	}
	
	/* ********************9.1 使用Collection收集对象******************** */
	public static void exp1() {
		/* 程序中有收集对象的需求，就目前为止，
		 * 学过的收集对象的方式就是使用 Object数组，而6.2.5节曾自行开发过ArrayList类，
		 * 封装了自动增长Object数组长度等行为。在Java SE中，其实就提供了数个收集对象的类
		 * 
		 * 可以直接使用这些类，而不用重新打造类似的API
		 * */
//		MyClass.exp1(); // 9.1.1 认识Collection架构
//		MyClass.exp2(); // 9.1.2 具有索引的 List
//		MyClass.exp3(); // 9.1.3 内容不重复的 Set
//		MyClass.exp4(); // 9.1.4 支持队列操作的 Queue
//		MyClass.exp5(); // 9.1.5 访问对象的 Iterator
//		MyClass.exp6(); // 9.1.6 排序收集的对象
		MyClass.exp7(); // 9.1.7 使用泛型
	}
}
