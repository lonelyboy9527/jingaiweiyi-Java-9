package cc.openhome;

import java.util.*;

import cc.openhome.class1.MyArrayList;
import cc.openhome.class1.MyStack;
import cc.openhome.class1.SimpleLinkedList;

public class MyClass {

	// 认识Collection架构
	public static void exp1() { 
		/* Java SE提供了满足各种需求的API，在使用这些API前，
		 * 建议先了解其继承与接口操作架构，才能了解何时该采用哪个类，以及类之间如何彼此合作。
		 * 而不会沦于死背API或抄写范例的窘境。
		 * 
		 * 针对收集对象的需求，Java SE提供了Collection API，其接口继承架构设计如图9.1所示：
		 * 
		 * 收集对象的共同行为定义在 java.util.collection中，然而收集对象会有不同的需求。
		 * 
		 * 收集对象时，会依照需求使用不同的接口操作对象。
		 * 例如，如果想要收集时，具有索引顺序，操作方式之一就是使用数组，
		 * 而以数组操作 ArrayList的就是 java.util.ArrayList。
		 * 如果查看API文档，会发现有以下继承与小作架构。
		 * 
		 * Java SE API不仅提供许多已操作类，也考虑到你自行扩充 API的需求，
		 * 以收集对象的基本行为来说，其提供了 java.util.AbstractCollection 
		 * 操作了Collection基本行为，java.util.AbstractCollection 操作了List
		 * 基本行为，必要时，可以继承AbstractCollection操作自己的 Collection，
		 * 继承AbstractCollection操作自己的List，这会比直接操作 Collection或List接口方便许多。
		 * 
		 * */
	}
	
	// 具有索引的 List
	public static void exp2() {
		/* List是一种Collection，作用是收集对象。并以索引方式保留收集的对象顺序，
		 * 其操作类之一就是 java.util.ArrayList
		 * 
		 * 例子：
		 * */
		System.out.println("quit退出:");
		List list = new ArrayList(); // 使用Java SE 的List与ArrayList
		Scanner scanner = new Scanner(System.in);
		String name;
		while (true) {
			System.out.print("访客名称:");
			name = scanner.nextLine();
			if (name.equals("quit")) {
				break;
			}
			list.add(name);
		}
		System.out.println("访客名单:");
		foreach(list);
		
		/* LinkedList 同样也操作了List接口，那么
		 * 
		 * 什么时候该用 ArrayList？
		 * 
		 * 什么时候该用 LinkedList？
		 * */
		
		/* <一>.ArrayList 特性
		 * 
		 * 数组在内存中会是连续的线性空间，根据索引随机存取时速度快。（如排序）
		 * 如果需要调整索引顺序时，会有较差的表现。（如把新的元素，放在0位置）
		 * 数组的长度固定也是要考虑的问题：在ArrayList内部数组长度不够时，会建立新的数组，并将旧数组参考至新数组。
		 * 
		 * */
		
		/* <二>.LinkedList 特性
		 * 
		 * LinkedList 在操作List接口时，采用了链接 (Link)结构，若不是很了解何谓链接，
		 * 
		 * 例子：
		 * 
		 * SimpleLinkedList内部使用Node封装新增的对象，每次add()新增对象之后，将会形成链状结构。
		 * 
		 * 所以每次 add()对象时，才会建立新的Node实例来保存对象，不会事先耗费内存
		 * 所调用size()方法，则从第一个对象，逐一参考下一个对象并计数，则可取得收集的对象长度。
		 * 若调用get()方法指定索引取得对象，则从第一个对象，逐一参考下一个对象并计数。则可取得指定索引的对象。
		 * 
		 * */
		Object object = new Object();
		SimpleLinkedList simpleLinkedList = new SimpleLinkedList();
		simpleLinkedList.add(object);
		System.out.printf("simpleLinkedList size: %d\n", simpleLinkedList.size());
		System.out.printf("%s objectAtIndex: %d\n", simpleLinkedList.get(0).toString(), 0);
		
		/* 可以看出，想要指定索引随机存取对象时， 链接方式都得使用从第一个元素开始查找下一个元素的方式，会比较没有效率
		 * 
		 * 1.所以排序就不适合使用链接操作的List。
		 * 2.链接的每一个元素会参考下一个元素，有利于调整索引顺序。(因此若收集的对象经常有变动索引的情况，考虑链接方式操作的List会比较好)
		 * */
		/* 系统LinkedList的用法
		 * http://blog.csdn.net/jdsjlzx/article/details/41654295
		 * */ 
	    LinkedList<String> lList = new LinkedList<String>();  
	    lList.add("1");  
	    lList.add("2");  
	    lList.add("3");  
	    lList.add("4");  
	    lList.add("5");  
	    System.out.println("链表的第一个元素是 : " + lList.getFirst());  
	    System.out.println("链表最后一个元素是 : " + lList.getLast());
	    // 2、获取链表元素 
	    for (String str: lList) {  
	        System.out.println(str);  
	    } 
	    // 3、从链表生成子表
	    List subl = lList.subList(1, 4);  
	    System.out.println(subl);  
	}
	public static void foreach(List list) {
		for (int i = 0; i < list.size(); i++) {
			// 使用get依索引取得收集的对象。
			String guest = (String) list.get(i);
			System.out.println(guest.toUpperCase());
		}
	}
	
	// 内容不重复的 Set
	public static void exp3() {
		/* 同样是收集对象，在收集过程中若有相同对象，则不再重复收集
		 * 若有这样的需求，可以使用 Set接口的操作对象。
		 * 
		 * 例子：若有一个字符串，当中有许多英文单次，你希望知道不重复的单次有几个？
		 * */
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入英文:");
		String line = scanner.nextLine();
		String[] tokens = line.split(" "); // 根据空白切割出字符串
		Set words = new HashSet();
		for (String token : tokens) {
			words.add(token);
		}
		System.out.printf("不重复单词有 %d个:%s\n", words.size(), words);// words通过%s打印，会自动调用toString()方法
		/* Set的特性是不重复，因此若有相同单词，则不会再重复加入
		 * 最后只要调用 size()方法，就可以知道收集的字符串个数
		 * HashSet的toString()操作，则会包括收集的字符串。（通过%s打印，会自动调用toString()方法）
		 * */
		
		/* 再来看看一个例子：
		 * 
		 * 1.对于自定义的对象, 如果加入HashSet，并且没有实现自己的hashCode()与equals()：（上例中的String， 是系统自动实现了hashCode()与equals()）。
		 * 
		 * 
		 * 程序中使用了Set收集了Student对象，其中故意重复加入了相同学生的数据，
		 * 然而在执行结果中看到，Set并没有将重复的学生数据排除:
		 * 
		 * 这是因为，我们没有告诉Set，什么样的Student实例才算是重复。
		 * 
		 * 例如：
		 * HashSet，会使用对象的hashCode()与equals来判断对象是否相同。
		 * 		HashSet的概念是，在内存中开设空间，每个空间会有个哈希编码。这些空间被称为哈希桶
		 * 		如果对象要加入HashSet，则会调用对象的hashCode()取得哈希码，并尝试放入对应号码的哈希桶中，
		 * 		如果哈希桶中没有对象，则直接放入。如果有对象，会再调用对象的equals进行比较。	
		 * 
		 * */
		Set set = new HashSet(); // HashSet
		set.add(new Student("tangfei", "11424033"));
		set.add(new Student("zhangjingyi", "11424001"));
		set.add(new Student("tangfei", "11424033"));
		System.out.println(set);
		
		/* 事实上，不只有HashSet,
		 * Java中有许多判断对象是否重复时，都会调用hashCode()与equals方法。
		 * 因此规格书中建议，两个方法必须同时操作。
		 * 对于上个例子:
		 * 	假如Student同时操作了hashCode()与equals()方法，那么重复的Student将不会被收集。
		 * 
		 * 2.对于自定义的对象, 如果加入HashSet，并且实现自己的hashCode()与equals()
		 * 例子：
		 * 在Student2中，我们自己重写了 hashCode和 equals方法
		 * 
		 * 实现自己的hashCode和 equals方法
		 * 虽然定义的学生姓名和学号相同，表示为相同的Student对象。
		 * hashCode()则直接利用String的hashCode()再做运算。
		 * 执行结果不再收集重复的Student对象。
		 * */
		Set set2 = new HashSet<>();
		set2.add(new Student2("tangfei", "11424033"));
		set2.add(new Student2("zhangjingyi", "11424001"));
		set2.add(new Student2("tangfei", "11424033"));
		System.out.println(set2);
		
	}
	 
	// 支持队列操作的 Queue
	public static void exp4() {
		/* 如果希望收集对象时，可以队列方式，收集的对象加入至尾端，取得对象时可以从前端，则可以使用Queue接口操作对象。
		 * 
		 * Queue继承自 Collection，所以也具有Collection的 add()、remove()、element()等方法。
		 * 
		 * 然而Queue定义了自己的 offer()、poll()与peek()等方法。
		 * 
		 * 最主要差别之一在于，
		 * add()、remove()、element()等方法操作失败时会抛出异常，
		 * 而offer()、poll()与peek()等方法操作失败时会返回特定值。
		 * 
		 * offer() 方法：用来在队列后端加入对象，成功会返回true。
		 * poll() 方法：用来取出队列前端对象，若队列为空则返回null。
		 * peek() 方法：用来取得（但不取出）队列前端对象，若队列为空则返回null。
		 * 
		 * 前面提过的 LinkedList，它不仅操作了List接口，也操作了Queue的行为，
		 * 所以可将LinkedList当作队列来使用。
		 * 
		 * 例如：
		 * */
		Queue requests = new LinkedList();
		//  仿真请求加入队列
		for (int i = 0; i < 6; i++) {
			requests.offer(new Request() {
				
				@Override
				public void execute() {
					// TODO Auto-generated method stub
					System.out.printf("处理数据 %f\n", Math.random());
				}
			});
		}
		process(requests);
		
		/* 经常地，你也会想对队列的前端与尾端进行操作，
		 * 在前端加入对象与取出对象，在尾端加入对象与取出对象，
		 * Queue的子接口 Deque 就定义了这类行为。
		 * 
		 * Deque 中定义了 addFirst()、 removeFirst()、getFirst()、
		 * 				addLast()、removeLast()、getLast()等方法。操作失败时会抛出异常。
		 * 		而 offerFirst()、 pollFirst()、peekFirst、
		 * 		offerLast、pollLast()、peekLast()、操作失败时会返回特定值。
		 * 
		 * 注意：Queue与Deque有写操作是等义的:
		 * 	add() - addLast()
		 * 	offer() - offerLast()
		 * 	remove() - removeFirst()
		 * 	poll() - pollFirst()
		 *  element() - getFirst()
		 *  peek() - peekFirst();
		 *  
		 *  java.util.ArrayDeque操作了 Deque接口，
		 *  以下例子使用ArrayDeque来操作容量有限的堆栈：
		 *  
		 *  自定义一个堆栈：
		 *  堆栈结构是先进后出
		 * */
		MyStack stack = new MyStack(5);
		stack.push("Justin");
		stack.push("Monica");
		stack.push("Irene");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
	}
	public static void process(Queue requests) {
		while (requests.peek() != null) {
			Request request = (Request) requests.poll();
			request.execute();
		}
	}
	
	// 访问对象的 Iterator
	public static void exp5() {
		/* 如果要写个 forEach方法，可以显示List收集的所有对象，
		 * 也许你会这么写： 
		 * */
		List list = new ArrayList();
		list.add(new Student("ArrayList tangfei", "1314520zjy"));
		list.add(new Student("ArrayList zhangjy", "1314520tf"));
		forEach(list);
		/* 这个方法适用于所有操作List接口的对象，
		 * 
		 * 如ArrayList、LinkedList等，如果要让你写个forEach方法
		 * 
		 * 显示Set收集的所有对象:
		 * 在查阅 Set的API中看到，有个toArray()方法
		 * 可以将Set收集的的对象转为 Object[]返回。
		 * */
		Set set = new HashSet();
		set.add(new Student("HashSet tangfei", "1314520zjy"));
		set.add(new Student("HashSet zhangjy", "1314520tf"));
		forEach2(set);
		
		/* 再写一个显示 Queue收集的所有对象
		 * 
		 * 注意：这个forEach3是有问题的
		 * */
		Queue queue = new LinkedList(); // 注意前面提过的 LinkedList，它不仅操作了List接口，也操作了Queue的行为，所以可将LinkedList当作队列来使用。
		queue.offer(new Student("Queue tangfei", "1314520zjy"));
		queue.offer(new Student("Queue zhangjy", "1314520tf"));
		forEach3(queue); 
		/* 表面上是正确的，
		 * 但是，queue.poll()方法取出对象，当你显示完Queue中所有对象，
		 * queue也空了，这并不是你想要的结果，怎么办？
		 * */
		
		/* 解决：
		 * 事实上，无论是List、Set还是Queue，都会有个iterator()方法，
		 * 这个方法在JDK1.4之前，是定义在 Collection接口中，
		 * 而List、set、Queue继承自collection，所以也都拥有iterator()行为。
		 * 
		 * iterator()方法：
		 * 	会返回java.util.Iterator接口的操作对象。这个对象包括了Collection收集的所有对象。
		 * 	你可以使用Iterator的hasNext()看看有无下一个对象，若有的话，再使用next()取得下一个对象。
		 * 
		 * 因此，无论List、set、Queue、还是任何Collection。都可以使用以下的方法来显示所收集的对象：
		 * 例子：
		 * 
		 * */
		myForEach(list);
		myForEach(set);
		myForEach(queue);
		
		/* 在JDK5之后，原先定义在Collection中的iterator()方法，
		 * 提升至新的ava.util.Iterable父接口。因此在JDK5之后，可以使用以下的方法来显示所收集的对象：
		 * 
		 * 例子：
		 * */
		myForEach2(list);
		myForEach2(set);
		myForEach2(queue);
		
		/* 注意：
		 * 
		 * 任何操作Iterable的对象，都可以使用这个myForEach2方法。
		 * 改进：使用JDK5之后的 增强式for循环遍历Iterable.iterator()
		 * */
		List list2 = Arrays.asList("Jutin", "Monica", "Irene");
		myForEach3(list2);
		myForEach3(new HashSet(list2));
		myForEach3(new ArrayDeque(list2));
		/* 这里使用了java.util.Arrays的static方法asList()
		 * 这个方法接受不定长自变量，可将指定的自变量收集为List。
		 * 
		 * List是一种Collection，所以可用来创建HaseSet
		 * List是一种Collection，所以可用来创建ArrayDeque
		 * */

	}
	public static void myForEach3(Iterable iterable) {
		for (Object object : iterable) {
			System.out.println("foreach iterable:" + object);
		}
	}
	
	public static void myForEach2(Iterable iterable) {
		Iterator iterator = iterable.iterator();
		while (iterator.hasNext()) {
			System.out.println("使用Iterable.iterator()操作:" + iterator.next());
		}
	}
	
	public static void myForEach(Collection collection) {
		Iterator iterator = collection.iterator();
		while (iterator.hasNext()) {
			System.out.println("使用Collection.iterator()操作:" + iterator.next());
		}
	}
	
	public static void forEach3(Queue queue) {
		while (queue.peek() != null) {
			System.out.println(queue.poll());
		}
	}
	
	public static void forEach2(Set set) {
		for (Object object : set.toArray()) {
			System.out.println(object);
		}
	}
	public static void forEach(List list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			System.out.println(list.get(i));
		}
	}
	
	// 排序收集的对象
	public static void exp6() {
		/* 在收集对象之后，对对象进行排序是常用对动作，
		 * 你不用亲自操作排序算法，java.util.Collections提供有sort()方法。
		 * 
		 * 由于必须有索引才能进行排序，因此 sort()方法接受List操作对象。
		 * 
		 * 例如：
		 * */
		List number = Arrays.asList(10, 3, 5, 7, 1, 0, 8);
		Collections.sort(number); // 默认从小到大排序
		System.out.println(number);
		
		/* 下面例子，
		 * 
		 * 执行结果会抛出异常。
		 * 因为你没有告诉 sort()方法，到底要根据Account的哪个属性进行排序。
		 * 
		 * */
		try {
			List accounts = Arrays.asList(
					new Account("jutin", "X1234", 1000),
					new Account("Monnica", "X5678", 500),
					new Account("Irene", "X2468", 200)
					);
			Collections.sort(accounts);
			System.out.println(accounts);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		/* 那么要怎么排序呢?*/
		
		/* <1>.操作Comparable
		 * 
		 * sort()方法要求被排序的对象，必须操作java.lang.Comparable接口，这个接口有个 compareTo()方法
		 * 必须返回大于0，等于0或小于0的数
		 * 
		 * 例子：
		 * 实现对余额进行排序
		 * */
		List accounts2 = Arrays.asList(
				new Account2("jutin", "X1234", 1000),
				new Account2("Monnica", "X5678", 500),
				new Account2("Irene", "X2468", 200)
				);
		Collections.sort(accounts2);
		System.out.println(accounts2);
		/* sort()方法在取得a对象与b对象进行比较时，会先将a对象扮演(Cast) 为Comparable (注意，若对象没有操作Comparable，将会抛出 ClassCastException)
		 * 然后调用a.compareTo(b)，
		 * 如果要使 a对象顺序上小于b对象，必须返回小于0对值，等于则返回0，否则返回大于0.
		 * 
		 * 因此，上面对例子将余额从小到大排序。
		 * */
		// 思考？为什么sort类中，可以直接对Integer进行排序呢？因为Interger有操作Comparable接口。
		
		/* <2>.操作Comparator
		 * 
		 * 实际开发总是不断有意外，如果你的对象无法操作Comparable呢，无法修改compareTo()方法呢？
		 * 
		 * 例子：String类本身有操作Comparable，但是是正序，但是你想反序呢？
		 * 修改String这个类不行， String类被标为 final，也不能继承。
		 * */
		List words = Arrays.asList("B", "X", "A", "M", "F");
		Collections.sort(words);
		System.out.println(words);
		/* sort()方法有另外一个重载版本，可接受java.util.Comparator接口的操作对象
		 * 
		 * 如果使用这个版本，排序方式将根据Comparator的compare()定义来决定。
		 * 
		 * 例子：
		 * */ 
		List words2 = Arrays.asList("B", "X", "A", "M", "F");
		Collections.sort(words2, new StringComparator()); // 接受java.util.Comparator接口的操作对象
		System.out.println(words2);
		/* 使用这种方法，可以指定按照我们需要的排序来排序 List*/

		
		/* Set的操作类之一java.util.TreeSet，不仅拥有收集不重复对象的能力，
		 * 还可用红黑树方式排序收集的对象。
		 * 条件就是：收集的对象必须是Comparable，或者创建 TreeSet时，指定 Comparator对象。
		 * 
		 * */
		/* Queue的操作类之一java.util.priorityQueue也是，收集至PriorityQueue对象，
		 * 会根据你指定的优先全来决定对象在队列中的顺序，优先权的告知：
		 * 条件就是：收集的对象必须是Comparable，或者创建 PriorityQueue时，指定 Comparator对象。
		 * 
		 * */
		
		/* 总结：
		 * 
		 * 在Java规范中，与顺序有关的行为，通常要么对象本身是 Comparable，
		 * 要么就另行指定Comparator对象告知如何排序。
		 * */
	}
	
	// 使用泛型
	public static void exp7() {
		/* 在使用Collecton收集对象时，由于事先不知道被收集对象的形态，
		 * 因此内部操作时，都是使用Object来参考被收集的对象，取回对象也是以Object类型返回。
		 * 
		 * 在JDK5之后，新增了泛型语法，让你在设计API时，可以指定类或方法执行泛型，
		 * 而使用API的客户端在语法上会更为简洁，并得到编译时期检查。
		 * 
		 * 在类名旁出现 <E>，表明此类支持泛型。E只是一个类型代号（表示Element），也可以用其他。
		 * 由于使用 <E>定义类型，在需要编译程序检查类型的地方，都可以使用E。如add() 和 get()。
		 * 
		 * 使用泛型语法，会对API造成一些语法上的麻烦。但对客户端会多一些友好。
		 * 例如：
		 * */
		// 声明与建立对象时，可使用 <String> 告知编译程序，这个对象收集的都会是String，取回之后也会是String 
		// 就不需要使用Cast()语法，强制转换了。
		MyArrayList<String> names = new MyArrayList<String>();
		names.add("Jutin");
		names.add("Monica");
		String name1 = names.get(0);
		String name2 = names.get(1);
		
		/*若接口支持泛型，在操作时也会比较方便。
		 * 
		 * 有些接口支持泛型，是这样的：
		 * public interface Comparator <T> {
		 * 	 // ...
		 * }
		 * 
		 * 例如：
		 * 将上一节对字符串反排序的例子改进，因为Comparator就是支持泛型的。
		 * 所以StringComparator2类实现接口时，可以指定 String
		 * */
		List words = Arrays.asList("B", "A", "K", "M", "Z");
		Collections.sort(words, new StringComparator2());
		System.out.println(words);
		
		/* 再来看一段程序
		 * 例子：
		 * 
		 * 会不会觉得有些啰嗦呢？明明声明words已经使用 <String>告诉编译程序了，
		 * 为什么创建  LinkedList 还要 <String>呢。
		 * */
		List<String> words2 = new LinkedList<String>();
		/* 这个问题在 JDK7之后有了改善，你可以这样撰写：
		 * 只要在声明参考时 有指定类型，那么创建对象时就不用再写类型了。
		 * */
		List<String> words3 = new LinkedList<>();
		
	}
}
//+++++++++++++使用泛型+++++++++++++
class StringComparator2 implements Comparator <String> {
	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return -o1.compareTo(o2);
	}
}
//+++++++++++++排序收集的对象+++++++++++++
class StringComparator implements Comparator {
	@Override
	public int compare(Object o1, Object o2) {
		String str1 = (String) o1;
		String str2 = (String) o2;
		
		/* compare()会传入两个对象，如果要使 o1顺序上小于o2,必须返回小于0的值，相等返回0，否则返回大于1的值。
		 * 
		 * 在这个例子中，由于String本身就是 Comparable，
		 * 所以调用compareTo后返回值乘以-1，就可以调换顺序。
		 * */
		return -str1.compareTo(str2);
	}
}
class Account2 implements Comparable {
	private String name;
	private String number;
	private int balance;
	
	public Account2(String name, String number, int balance) {
		this.balance = balance;
		this.name = name;
		this.number = number;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Account2 (%s, %s, %d)", name, number, balance);
	}
	
	// 实现对余额进行排序
	@Override
	public int compareTo(Object o) {
		Account2 other = (Account2)o;
		return this.balance - other.balance;
	}
}
class Account {
	private String name;
	private String number;
	private int balance;
	
	public Account(String name, String number, int balance) {
		this.balance = balance;
		this.name = name;
		this.number = number;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Account (%s, %s, %d)", name, number, balance);
	}
}

interface Request {
	void execute();
}

//+++++++++++++内容不重复的 Set+++++++++++++
class Student {
	private String name;
	private String number;
	public Student(String name, String number) {
		this.name = name;
		this.number = number;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("{%s, %s}", name, number);
	}
}

class Student2 {
	private String name;
	private String number;
	public Student2(String name, String number) {
		this.name = name;
		this.number = number;
	}
	
	// eclipse自动产生的equals()与hashCode
	// 就示范而言已经足够了
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Student2 other = (Student2)obj;
		return true;
	}
	
	@Override
	public int hashCode() {
		int hash = 5;
		hash = 13 * hash + (this.name != null?this.name.hashCode(): 0);
		hash = 13 * hash + (this.number != null?this.number.hashCode(): 0);
		return hash;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("{%s, %s}", name, number);
	}
}


