package cc.openhome;

import java.io.File;
import java.io.FileInputStream;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.TreeMap;


public class MyClass2 {
	// 常用 Map操作类
	public static void exp1() {
		/* 在使用Map相关API前，先了解Map设计框架，
		 * 对正确使用API会有帮助。
		 * 
		 * 常用的Map操作类为： 
		 * java.util.HashMap 与 
		 * java.util.TreeMap
		 * 	其继承自抽象类 java.util.AbstractMap。
		 * 
		 * 至于：
		 * java.util.Dictionary 与 
		 * java.util.HashTable
		 * 是从JDK1.0就遗留下来的API，不建议使用。
		 * 
		 * 	HashTable从JDK1.2开始操作了Map接口，以与Map API结合，虽然不建议再使用HashTable，但子类
		 * 	java.util.Properties倒是还蛮常见使用，因此这里一并介绍。
		 * 
		 * */
		/* <1>.使用HaseMap
		 * 
		 * Map也指出泛型语法，使用上很简单，直接看个例子：
		 * */
		Map<String, String> messages = new HashMap<>();
		messages.put("Justin", "Hello! Justin的信息！");
		messages.put("Monica", "给Monica的悄悄话！");
		messages.put("Irene", "Irene的可爱猫喵喵叫！");
		 Scanner scanner = new Scanner(System.in);
		 System.out.print("收取谁的信息：");
		 String message = messages.get(scanner.nextLine());
		 System.out.println(message);
		 System.out.println(messages);
		 /* 建立Map操作对象时，可以使用泛型语法指定键与值的类型
		  * 
		  * 要建立键值对应，可以使用put()方法。 
		  * 
		  * 对于Map，键不能重复，判断键是否重复是根据hashCode()与equals()方法，
		  * 所以作为键的对象必须操作haseCode() 与 equals()。
		  * 
		  * 若要获取指定键的值，使用get()方法。
		  * 
		  * 在HashMap中建立键值对应后，键是无序的。
		  * 若想让键是有序的，则可以使用TreeMap。
		  * */
		 
		 /* <2>.使用TreeMap
		  * 
		  * 如果使用TreeMap建立键值对应，则键的部分将会排序，
		  * 条件是：作为键的对象必须操作Comparable接口，或者是在创建TreeMap时，指定操作Comparator接口的对象。
		  * 
		  * 例如：
		  * */
		 Map<String, String> messages2 = new TreeMap<>();
		 messages2.put("Bustin", "Hello! Bustin的信息！");
		 messages2.put("Aonica", "给Aonica的悄悄话！");
		 messages2.put("Crene", "Crene的可爱猫喵喵叫！");
		 System.out.println(messages2);
		 /* 由于String有操作Comparable接口
		  * 所以可看到结果是根据键来排序（通过键的第一个字母来排序。）
		  * 
		  * 如果想看到从大到小排序的话，可以这样做
		  * 例如：
		  * */
		 Map<String, String> messages3 = new TreeMap<>(new StringComparator3());
		 messages3.put("Bustin", "Hello! Bustin的信息！");
		 messages3.put("Aonica", "给Aonica的悄悄话！");
		 messages3.put("Crene", "Crene的可爱猫喵喵叫！");
		 System.out.println(messages3);
		 
		 /* <3>.使用Properties (属性)
		  * 
		  * Properties类继承自HashTable，HashTable操作了Map接口，Properties自然也有Map的行为。
		  * 虽然也可以使用put()设定键值对应、get()指定键取值，
		  * 
		  * 不过一般常用Properties的：（针对键值都是字符串，通常称为属性名称与属性值）
		  * setProperty()指定字符串类型的键值，
		  * getProperty()指定字符串类型的键，取回字符串类型的值。
		  * 
		  * 例如：
		  * */
		 Properties properties = new Properties();
		 properties.setProperty("userName", "justin");
		 properties.setProperty("password", "123456");
		 System.out.println(properties.getProperty("userName"));
		 System.out.println(properties.getProperty("password"));
		 
		 /* Properties也可以从文档中读取属性
		  * 
		  * 1.例如有个.properties文档如下
		  * (建立properties文档：File -> New -> File)
		  * */
        // 生成文件对象  
        File pf = new File(System.getProperty("user.dir")  
                + "/src/cc/openhome/file/config.properties");  
  
        // 生成文件输入流  
        FileInputStream inpf = null;  
        try {  
            inpf = new FileInputStream(pf);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        // 生成properties对象  
        Properties p = new Properties();  
        try {  
            p.load(inpf);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        // 输出properties文件的内容  
        System.out.println("username:" + p.getProperty("username"));  
        System.out.println("password:" + p.getProperty("password"));
        /* load方法结束后，会自动关闭FileInputStream实例。*/
        
        /* 2.Properties还可以使用loadFromXML()加载.xml文档。
         * 
         * xml文档文件格式有固定结构。
         * */
        
        /* 3.在第二章的时候，我们曾在获取过系统属性
         * 
         * System.getProperties().
         * (在使用java 指令启动JVM时，可以用-D指定系统属性)
         * */
        Properties properties3 = System.getProperties();
        System.out.println("java.class.version:" + properties3.getProperty("java.class.version"));
        System.out.println("java.version:" + properties3.getProperty("java.version"));
        System.out.println("java.runtime.version:" + properties3.getProperty("java.runtime.version"));
	}
	// 访问Map 键值
	public static void exp2() {
		/* 如果想取得Map中所有的键，或者想取得Map中所有的值怎么做？
		 * 
		 * Map虽然与Collection没有继承上的关系，然而却是彼此搭配的API
		 * 
		 * 如果想取得Map中所有的键，可以调用Map的keySet()方法返Set对象。
		 * 如果想取得Map中所有的值，可以调用values()返回Collection对象。
		 * */
		Map<String, String> map = new HashMap<>();
		map.put("one", "一");
		map.put("two", "二");
		map.put("three", "三");
		System.out.println("显示键:");
		
		for (String key : map.keySet()) {
			System.out.println(key);
		}
		System.out.println("显示值:");
		for (String value : map.values()) {
			System.out.println(value);
		}
		
		/* 如果想同时取得Map的键与值，可以使用entrySet方法
		 * 这会返回一个set对象，每个元素都是Map.Entry实例，
		 * 可以调用getKey()取得键，调用getValue取得值。
		 * */
		Map<String, String> map2 = new TreeMap<>();
		map2.put("one", "一");
		map2.put("two", "二");
		map2.put("three", "三");
		for (Map.Entry<String, String> entry : map2.entrySet()) {
			System.out.printf("key: %s, value: %s\n", entry.getKey(), entry.getValue());
		}
	}
}

class StringComparator3 implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return -1*o1.compareTo(o2);
	}
}