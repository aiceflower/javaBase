package learn.basic.tarena;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 复习知识点
 * 
 * @author pillow
 *
 */
@SuppressWarnings("unused")
public class Review {
	//scanner
	@SuppressWarnings("resource")
	public static void testScanner(){
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入年龄：");
		int age = scan.nextInt(); 
		System.out.println("age="+age);
	}
	//Array
	public static void testArray(){
		int arr1[] = {1,3,5,6};
		/*
		 * 数组复制 1.使用循环结构 这种方法最灵活,但代码较多 2.使用Object类的clone（）方法,简单,灵活形也最差。效率最差.
		 * 3.使用Systems的arraycopy 4.Arrarys类的copyOf（）方法与copyOfRange（）方法
		 */
		int arr3[] = Arrays.copyOf(arr1, 4);//4
		int arr2[] = Arrays.copyOfRange(arr1, 0, 3);//4

		int [] a = new int [arr1.length];
		System.arraycopy(arr1, 0, a, 0, arr1.length);//3

		int[] clone = arr1.clone();//2
		
		//TODO	1
		System.out.println(Arrays.toString(a));
	}
	//StringBuilder
	public static void testStringBuilder(){
		StringBuilder sb = new StringBuilder();
		sb.append("上海自来水来自海上");// 追加
		sb.insert(3, "的");// 插入
		sb.replace(0, 2, "替换");// 替换
		sb.delete(0, 2);// 删除
		sb.reverse();// 反转
	}
	//String 
	public static void testString(){
		String s1 = "123abc";
		String s2 = "123abc";
		String s3 = new String("123abc");
		System.out.println(s1 == s2);//true
		System.out.println(s1 == s3);//false
		System.out.println(s1.equals(s3));//true
		System.out.println(s1.hashCode() == s3.hashCode());// true
															// equals相等则hashCode相等
		//--------------------------------
		/**
		 * 编译器有一个优化措施，在编译源程序时，所计算表达式两边的内容都是字面量
		 * 那么会直接计算，并将结果编译到字节码文件中，这样的好处在于JVM运行时不 用每次都计算了，所以，下面的代码在字节码文件中为： String
		 * s4= "123abc";
		 */
		String s4 = "123"+"abc";  
		System.out.println(s1==s4);//true
		
		//----------------------------------
		String s5 = "123";
		// 由于s5为变量，所以编译器不计算，编译器不计算，则s6同s4，s1不一样
		String s6 = s5+"abc";
		System.out.println(s4.hashCode()+","+s4);
		System.out.println(s6.hashCode()+","+s6);
		System.out.println(s4==s6);
		// 方法--------------------------------------------
		s1.length();// 计算长度
		
		s1.indexOf("abc");// 查看给定的字符串在当前字符串中的位置,若没有则返回-1
		s1.indexOf("abc",2);
		s1.lastIndexOf("abc");
		s1.lastIndexOf("abc",2);
		
		s1.subSequence(0, 3);// 截取子串
		
		s1.trim();// 去除当前字符串两边的空白
		
		s1.charAt(3);// 查看字符
		
		s1.startsWith("123");
		s1.endsWith("abc");
		
		s1.concat("abc");// 连接
		
		s1.contains("abc");// 判断
		s1.indexOf("abc");// 也可用于判断，返回-1表示没有
		s1.matches("[aaa]");// 匹配，正则
		s1.split(",");// 切割，正则
		s1.replace("123", "abc");// 替换
		s1.replaceAll("[abc]", "aaa");// 替换，正则
		/*
		 * 汉字范围 '\u4e00'----'\u9fa5'
		 */
		//
		/**
		 * 重写应满足： 任何时候，对于非空引用x，都应做到x.equals(null)返回false 自返性：x.equals(x)返回true
		 * 对称性：x.equals(y)返回true,y.equals(x)也应当返回true
		 * 传递性：x.equals(y)为true,y.equals(z)也为true,x.equals(z)就应当为true
		 * 一致性：若当前对象x参与equals比较的属性没有发生过改变，那么多次调用x.equals(y)返回值应当一致
		 */
	}
	//Integer
	public static void testInteger(){
		Integer int1 = 127;
		Integer int2 = 127;
		System.out.println(int1==int2);//true
		
		Integer int3 = 128;
		Integer int4 = 128;
		System.out.println(int3==int4);//false
		
		
		Integer i  = new Integer(3);
		int a = i.intValue();// 包装类型转为普通类型 xxxValue()
		int max = Integer.MAX_VALUE;// 获取最大，最小值
		String str = "123";
		int b = Integer.parseInt(str);// 将字符串转换为对应的基本类型数据
		// 十进制转其它进制
		String s1 = Integer.toBinaryString(33);//toXXXString();
		System.out.println(s1);
		// 其它进制转十进制
		int i1 = Integer.parseInt("1111", 2);
		System.out.println(i1);
	}

	// 日期Calendar
	@SuppressWarnings("static-access")
	public static void testCalendar() throws ParseException {
		Calendar c1 = Calendar.getInstance();// 获取实例，默认为系统当前时间
		System.out.println(c1);
		Date time = c1.getTime();// 获取日期
		System.out.println(time);
		// 设置------------------------------------
		c1.setTime(time);// 设置日间
		// 设置具体内容
		/*
		 * 希望表示为：2008-08-08 20:08:00
		 */
		// 设置年为:2008 时间分量使用常量即可
		c1.set(c1.YEAR,2008);
		// 设置月 0表示1月，以此类推
		c1.set(c1.MONTH,c1.AUGUST);
		// 设置日
		/*
		 * 日对应的时间分量： DATE:月中的天，俗称：几号 DAY_OF_MONTH 月中的天，与DATE一致
		 * 
		 * DAY_OF_WEEK:　周中的天，就是星期几
		 * 
		 * DAY_OF_YEAR:　年中的第几天
		 */
		c1.set(c1.DAY_OF_MONTH,8);
		// 设置时
		c1.set(c1.HOUR_OF_DAY,20);
		// 设置分
		c1.set(c1.MINUTE,8);
		// 设置秒
		c1.set(c1.SECOND,60);
		/*
		 * 查看08年的第165天？
		 */
		c1.set(c1.DAY_OF_YEAR,165);
		// 获取-------------------------
		// 获取年？
		int year = c1.get(c1.YEAR);
		// 获取月？
		int month = c1.get(c1.MONTH);
		// 获取日？
		int day = c1.get(c1.DAY_OF_MONTH);
		// 周几？
		/*
		 * 一周的第一天是周日， 1:周日 2:周一 ...
		 */
		int week = c1.get(c1.DAY_OF_WEEK);
		// ------------------------------------------
		// 使用Calendar计算时间
		// 查看３个月后的今天
		c1.add(c1.MONTH, 3);
		// 查看25天以后？加天使用DAY_OF_YEAR
		c1.add(c1.DAY_OF_YEAR, 25);
		// 一年前的今天
		c1.add(c1.YEAR, -1);
		// 查看
		// 查看今年一共多少天
		int days = c1.getActualMaximum(Calendar.DAY_OF_YEAR);
		// 查看本月一共多少天
		int days1 = c1.getActualMaximum(Calendar.DAY_OF_MONTH);

		// 日期
		Date d1 = new Date();
		long l = d1.getTime();// 获取内部维护的long值，记录自1970年元旦至该时间之间的毫秒差

		// 格式化日期,日期转String
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		String str = sdf.format(d1);
		// String转日期
		String str1 = "2008年08月08日　20点08分00秒";
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日　HH点mm分ss秒");
		Date date = sdf1.parse(str1);// 会抛出异常
	}

	// Collection 集合
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void testCollection() {
		Collection c = new ArrayList();
		c.add("one");// 添加
		c.size();// 获取集合元素数量
		c.isEmpty();// 查看当前集合是否不含有任何元素
		c.clear();// 清空集合
		c.contains("one");// 查看集合是否包含给定元素

		// 集合存储的是元素的引用
		int a[] = { 1, 2, 3 };
		c.add(a);
		a[2] = 7;// 修改
		for (Object o : c) {
			int aaa[] = (int[]) o;
			// 集合也看到了修改后的效果
			System.out.println(Arrays.toString(aaa));
		}
		// 集合存储的是元素的引用

		// 数组转集合，只能转换为List集合
		String[] array = { "one", "two", "three" };
		List<String> list = Arrays.asList(array);
		// 修改集合元素等于修改数组元素
		list.set(0, "1");
		System.out.println(Arrays.toString(array));

		// 集合转数组
		String[] array1 = list.toArray(new String[list.size()]);
		System.out.println(Arrays.toString(array1) + "............");

		// 所有的集合都支持一个带有Collection参数的构造方法
		List<String> list1 = new ArrayList<String>(list);
		list1.add("two");
		System.out.println(list1);
		Set<String> set = new HashSet<>(list1);
		System.out.println(set);

		// 批量操作
		list1.addAll(list);// 添加
		list1.containsAll(list);// 判断
		// 遍历集合1----------------------------
		// 集合提供了统一的遍历方式：迭代器,使用迭代器遍历集合要遵循：“问取删”的顺序，其中删除不是必须的
		Iterator it = list1.iterator();
		while (it.hasNext()) {
			// 取: E next() 该方法用于从集合中取出当前可遍历的元素
			String str = (String) it.next();
			System.out.println(str);
		}
		// 遍历集合2,不用强转----------------------------
		System.out.println("---------------------");
		Iterator<String> it1 = list1.iterator();
		while (it1.hasNext()) {
			String str = it1.next();
			System.out.println(str);
			// 删除
			if ("#".equals(str)) {
				// 迭代过程中不要通过集合方法修改元素数量
				// c.remove(str);
				/*
				 * 删除只能通过迭代器提供的删除方法 而删除的则是通过next()方法迭代的元素
				 */
				it.remove();
			}
		}
	}

	// list
	public static void testList() {
		// List集合是可重复集，且有序，特点是可以根据下标操作元素，这一点和数组很相似
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");

		String str = list.get(2);// 获取
		System.out.println(str);

		list.add(1, "four");// 插入
		String old = list.remove(3);// 删除
		System.out.println(old + ".......");

		// 遍历
		for (String s : list) {
			System.out.println(s);
		}
		// List可以获取子集
		List<String> subList = list.subList(0, 2);
		subList.add("five");
		System.out.println(subList);
		System.out.println(list);// 子集修改后，原集合也跟着修改
		// 排序
		// 集合的排序，只排序List集合,Set大部分实现是无序的，对其排序没意义
		// 要排序的List集合中的元素必须是可以比较大小的。java提供了一个接口Comparable
		// 只有实现了该接口的类才具有可比性，才可以通过sort方法进行自然排序。
		Collections.sort(list);
		// 传比较器比较
		Collections.sort(list,new MyCompare());
	}

	// map
	public static void testMap() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("语文", 98);
		map.put("数学", 97);
		map.put("英语", 95);
		map.put("物理", 99);
		map.put("化学", 98);

		// 通过key获取value
		Integer num = map.get("语文");
		// 替换value
		Integer old = map.put("语文", 100);// 返回原value
		// 判断是否存在key
		boolean tk = map.containsKey("语文");
		// 判断是否存在value
		boolean tv = map.containsValue(99);
		// 遍历
		// * 1：遍历所有的Map
		// * 2：遍历所有的Key-Value对
		// * 3：遍历所有的Value（不常用）
		/*
		 * 遍历所有的key Set keySet()
		 * 该方法会将当前Map中所有的key存入一个Set集合后返回，所以遍历该集合就相当于遍历了所有的key.
		 */
		Set<String> s1 = map.keySet();
		// 之一
		Iterator<String> it = s1.iterator();
		while (it.hasNext()) {
			String key = it.next();
			Integer value = map.get(key);
			System.out.println(key + "..." + value);
		}
		// 之二
		System.out.println("-----------------------");
		for (String s : s1) {
			Integer value = map.get(s);
			System.out.println(s + "..." + value);
		}

		/*
		 * 遍历每一组键值对 在Map中，每一组键值对由一个Map的内部类
		 * Entry的实例表示，Entry提供了两个方法分别是getKey(),getValue()用来获取这一组键值对中的key与value
		 * 
		 * Map提供了一个方法 Set entrySet() 该方法会将当前Map中每一组键值对对应的Entry实例存入一个集合后返回。
		 * 所以遍历集合中的每一个Entry实例，再分别获取key,value就达到了遍历每一组键值的目的
		 */
		Set<Entry<String, Integer>> set1 = map.entrySet();
		for (Entry<String, Integer> e : set1) {
			String key = e.getKey();
			Integer value = e.getValue();
			System.out.println(key + "..." + value);
		}
		// 也可用Iterator来遍历
		/*
		 * 不推荐， 遍历所有的value Collection values() 该方法会将所有的value存入一个集合后返回
		 */
		System.out.println(".............................");
		Collection<Integer> values = map.values();
		for (Integer value : values) {
			// 通过value获取key
			Set<String> kset=map.keySet();
			for(String ks:kset){
				if (value.equals(map.get(ks))) {
					System.out.println(ks + "..." + value);
			    }
			}
		}
	}

	// queue
	public static void testQueue() {
		Queue<String> queue = new LinkedList<String>();
		queue.offer("one");
		queue.offer("two");// 向队尾增加元素
		String s1 = queue.poll();// 从队首获取一个元素，取出后该元素就从队列中被移除了，所以是出队操作
		String s2 = queue.peek();// 引用队首元素，而不做出队操作
		int size = queue.size();// 获取当前队列的元素个数
		// 遍历
		while (queue.size() > 0) {
			System.out.println(queue.poll());
		}
	}

	// deque
	public static void testDeque() {
		Deque<String> stack = new LinkedList<String>();
		stack.push("one");// 向栈中“压入”新元素，该元素就会处于栈顶
		stack.push("two");
		String str = stack.pop();// 从栈顶获取元素，获取后该元素会从栈中被删除
		str = stack.peek();// 引用栈顶元素,不会删除
		System.out.println(stack);
		// 遍历
		while (stack.size() > 0) {
			str = stack.pop();
			System.out.println(str);
		}
	}

	// --------------------------文件IO相关--------------------------------------
	// file
	public static void testFile() throws IOException {
		// 通过File我们可以：
		// * １：获取文件或目录的属性信息
		// * ２：操作文件或目录（创建，删除）
		File file = new File("." + File.separator + "demo.txt");
		// 获取文件名
		String name = file.getName();
		// 获取文件大小（字节量）
		long length = file.length();
		// 判断当前File对象表示的是否为一个文件
		boolean isFile = file.isFile();
		// 判断当前File对象表示的是否为一个目录
		boolean isDir = file.isDirectory();
		// 查看文件最后修改时间
		long last = file.lastModified();
		Date date = new Date(last);
		// 这里判断不存在，这样才需要创建该文件
		if (!file.exists()) {
			file.createNewFile();// 创建file
		}
		file.delete();// 删除file
		// --------------------------
		File dir = new File("demo");
		if (!dir.exists()) {// 判断
			dir.mkdir();// 创建目录
		}
		dir.delete();// 删除空目录
		// --------------------
		File dirs = new File("a" + File.separator + "b" + File.separator + "c"
				+ File.separator + "f");
		if (!dirs.exists()) {
			dirs.mkdirs();// 创多级目录
		}
		// 递归删除给定的file对象
		deleteFile(dirs);
		// ------------------------------
		// 获取当前文件下的所有子项
		File f = new File(".");
		File[] subs = f.listFiles();// 获取所有子项
		for (File sub : subs) {
			System.out.println((sub.isFile() ? "文件：" : "目录：") + sub.getName());
		}
		// 按照过滤器，获取子项--------------------------------
		FileFilter ff = new FileFilter() {

			@Override
			public boolean accept(File pathname) {
				System.out.println("正在过滤：" + pathname.getName());
				return pathname.getName().startsWith(".");
			}
		};
		subs = f.listFiles(ff);
		for (File sub : subs) {
			System.out.println("子项：" + sub.getName());
		}
	}

	// randomAccessFile
	public static void testRandomAccessFile() throws IOException {
		@SuppressWarnings("resource")
		// "r":只读, "rw":读写
		RandomAccessFile raf = new RandomAccessFile("abc.txt", "rw");// 抛出异常FileNotFoundException
		raf.write(1);
		raf.writeInt(3);
		raf.writeDouble(3d);
		raf.writeChar('a');// 写入基本数据类型
		raf.write("abcdef".getBytes());// 抛出异常IOException
		raf.writeChars("abcdef");
		raf.close();// 关闭
		byte[] buf1 = new byte[1024 * 10];
		int len1 = raf.read(buf1);
		raf.write(buf1, 0, len1);
		int i = raf.read();// 读取一个字节，并以int的形式返回,返回-1，说明读取到文件末尾了EOP(end of file)
		// 批量读取
		byte[] buf = new byte[100];
		int len = raf.read(buf);// 返回值为实际读取到的字节量
		String str = new String(buf, 0, len, "UTF-8");
		// -------------------------------------------
		// 获取指针当前位置，默认为文件的第一个字节，是０
		long pos = raf.getFilePointer();
		raf.seek(0);// 该方法用来将指针移动到指定位置
		int ii = raf.readInt();// 连续读取4个字节并转换为int值返回
		double dd = raf.readDouble();// 连续读取8个字节并转换为double值返回
		raf.skipBytes(8);// 在指针当前位置处开始，连续跳过给定的字节量
	}

	// io
	public static void testIo() throws IOException, ClassNotFoundException {
		// 文件流,低级流,用于从文件中读写数据的流
		FileInputStream fis = new FileInputStream(new File("in.txt"));// 抛出FileNotFoundException
		FileOutputStream fos = new FileOutputStream(new File("out.txt"));
		FileOutputStream fos1 = new FileOutputStream(new File("out.txt"), true);// 追加模式

		// 缓冲字节流,提高字节读写效率，高级流，可以flush
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		bos.write("aaaa".getBytes());
		bos.flush();// 强制将缓冲区中的数据一次性写出。频繁调用该方法会提高写出次数从而降低写出的效率。
		BufferedInputStream bis = new BufferedInputStream(fis);
		bis.read();
		bis.close();
		bos.close();// 关闭流的时候只需要关闭最外层的高级流即可

		// 对象流
		/*
		 * 该方法会读取一组字节并将其转换为对应的对象，这个操作就是对象的反序列化
		 * 1.在反序列化时，会检测待反序列化的对象与该类定义的现有版本是否一致，若不一致，则会抛出异常，反序列化失败！
		 * 2.若版本号没变，但是类定义发生了改变，那么采用兼容模式： 　原来对象有的属性，现在还有的就还原 　原来对象有的属性，现在没有的就忽略
		 * 　原来对象没有的属性，现在有的则使用默认值
		 */
		Object o = new Object();
		ObjectOutputStream oos = new ObjectOutputStream(fos);// 写
		oos.writeObject(o);// 写对象,对象序列化
		ObjectInputStream ois = new ObjectInputStream(fis);// 读
		ois.readObject();// 读对象，对象反序列化
		// 字符流，字符流都是高级流，因为天生具有编解码能力，所以字符流只用来读写字符数据
		// 可以指定编码,连接字节，与字符的桥梁
		InputStreamReader isr = new InputStreamReader(fis);
		InputStreamReader isr1 = new InputStreamReader(fis, "utf-8");
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		OutputStreamWriter osw1 = new OutputStreamWriter(fos, "utf-8");
		// 缓冲字符流，可以读取一行 readLine()
		BufferedWriter bw = new BufferedWriter(osw);// 写
		BufferedReader br = new BufferedReader(isr);// 读
		br.readLine();// 读取一行
		// 例，读取键盘输入start----------------
		BufferedReader br1 = new BufferedReader(
				new InputStreamReader(System.in));

		String line = null;
		boolean flag = true;
		while (/* true */flag) {
			line = br.readLine();
			System.out.println(line);
		}
		// 读取键盘输入end----------------

		// 打印流
		/**
		 * 缓冲字符流 优势： １：读写字符串快 ２：可以以行为单位读写字符串
		 * 
		 * 缓冲字符输入输出流： BufferedReader,BufferedWriter
		 * 
		 * PrintWriter内部嵌套了BufferedWriter
		 * 所以其也具有缓冲功能，PrintWriter还提供了自动的行刷新功能，所以通常我们使用它来当做缓冲字符输出流
		 * 
		 * PrintWriter提供了很多构造方法，方便我们创建实例
		 * 
		 * @author tarena
		 *
		 */
		// 1
		PrintWriter pw = new PrintWriter("pw.txt", "GBK");// 可指定编码,文件形式
		// 2
		FileOutputStream foss = new FileOutputStream("pw1.txt");
		/*
		 * 直接将字节输出流转换为PrintWriter的话会按照系统默认字符集写出字符串！
		 */

		/*
		 * 若希望按照指定的字符集写出，我们需要先将字节流转换为OutputStreamWriter，然后指定字符集。
		 */
		OutputStreamWriter osww = new OutputStreamWriter(foss, "GBK");// 同样达到指定编码的方式
		PrintWriter pww = new PrintWriter(foss);
		// PrintWriter(OutputStream out,boolean autoFlush)
		// PrintWriter(Writer writer,boolean autoFlush)
		PrintWriter pww1 = new PrintWriter(pww, true);// true 自动行刷新
		pw.println("我爱北京天安门");// 写一行
		pw.flush();// 手动刷新
	}

	// exception
	public static void testException() {
		/**
		 * finally块 只能定义在异常捕获机制的最后， finally块中的代码无论try中的语句是否出错，都保证执行。
		 * 除非之前调用了System.exit(0);通常将释放资源这类的操作就放在finally中确保执行。
		 */
		// finalize
		/*
		 * 该方法是在Object中定义的方法，当该类的对象不被任何引用变量指向时， 会被GC回收，在回收前该方法会被调用
		 */
		/**
		 * throw关键字 用于主动抛出一个异常，通常两种情况我们会抛出异常而不是自己解决
		 * 1.当遇到了满足语法要求，但是不符合业务逻辑要求时，我们可以抛出异常，让调用者解决
		 * 2.当前代码遇到异常，但是不负责解决，而是应当将异常反馈给调用者时，会抛出异常。
		 */
		try {
			int i = 0;
		} catch (Exception e) {
			System.out.println(e.getCause());// 返回具体错误类型
		}
	}

	// thread 多线程
	public static void testThread() {
		/**
		 * 第一种：继承Thread并重写run方法来定义任务。 两个弊端:
		 * １：由于需要继承Thread，当前类就不能扩展其他类了，这在实际地开发项目时是很麻烦的一件事
		 * ２：由于线程内部重写了run方法决定了当前线程要执行的任务这就导致当前线程只能做这件事，任务与线程有了强耦合关系，不利于线程重用。
		 */
		new MyThread1().start();// start启动线程
		new MyThread2().start();// 第一种
		/**
		 * 线程的第二种创建方式： 使用Runnable接口,定义其实现类，定义线程要执行的任务
		 */
		new Thread(new MyRunnable1()).start();
		final Thread t1 = new Thread(new MyRunnable2());
		t1.start();

		// 用匿名内部类来完成两种线程的创建方式
		new Thread() {
			@Override
			public void run() {// 线程的执行逻辑
				System.out.println("你是谁啊？");
			}
		}.start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("我是查水表的。");
				try {
					/**
					 * join方法 允许当前线程在另一个线程上等待，进入阻塞状态，直到
					 * 另一个线程运行完毕，当前线程才会解除阻塞，继续执行， 通常用于协调两个线程同步工作使用。
					 */
					t1.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		// Thread提供了一个静态方法currentThread,来获取运行该方法的线程。
		Thread t = Thread.currentThread();
		/**
		 * 当我们要执行程序时，首先操作系统会启动一个进程来运行JVM,JVM启动后会启动一个线程来执行main方法。
		 * 进程结束：当一个进程中的所有前台线程都结束了，进程就结束了。 所以并不是说main方法执行完毕进程一定结束。
		 */
		// 查看线程的一些信息
		System.out.println("id:" + t.getId());
		System.out.println("name:" + t.getName());
		System.out.println("priority:" + t.getPriority());
		System.out.println("isAlive:" + t.isAlive());
		System.out.println("isDaemon:" + t.isDaemon());
		System.out.println("isInterrupted:" + t.isInterrupted());
		System.out.println("state:" + t.getState());
		/**
		 * 线程优先级 1-10个等级 10最大，1最小，５默认。 优先级高的线程理论上获取CPU时间片的次数多。
		 */
		t.setPriority(Thread.MIN_PRIORITY);// 设置线程优先级
		/**
		 * Thread的静态方法sleep，可以使得当前线程进入阻塞状态指定毫秒，当超时后，该线程会自动回到Runnable状态。
		 * 等待再次分配时间片运行。
		 */
		// Thread.sleep(1000);抛InterruptedException
		/**
		 * 守护线程：又叫后台线程，使用上与前台线程没有区别，不同点在于结束的时候：当进程中所有前台线程都结束时
		 * 无论后台线程是否还在运行都要强制结束，并最终结束进程。
		 */
		t.setDaemon(true); // 设置线程为守护线程,要在启动之前设置
		t.start();
		// -----------------------------------
		/**
		 * 线程池 主要解决两个问题： 1.控制线程数量 2.重用线程
		 */
		// 创建一个固定长度的线程池池中有两条线程
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		// 将任务交给线程池
		threadPool.execute(t);
		threadPool.shutdown();// 关闭线程池
		// synchronized
		/**
		 * Collections提供了很多静态方法 允许我们将现有的集合或Map转换为线程安全的
		 */
		List<String> list = new ArrayList<String>();
		list = Collections.synchronizedList(list);
		Set<String> set = new HashSet<String>(list);// HashSet也不是线程安全的
		set = Collections.synchronizedSet(set);
		// HashMap也不是线程安全的
		Map<String, Integer> map = new HashMap<String, Integer>();
		map = Collections.synchronizedMap(map);
		// -------------------------------
		/**
		 * 当一个方法被synchronized修饰后，该方法变为同步方法，意思是多个线程不能同时访问该方法内部。 public
		 * synchronized int getBean(){ if(beans==0){ ...}同步方法
		 *
		 */
		/**
		 * 有效的减少同步范围可以在保证安全的前提下提高并发效率 控制同步的代码 .... 范围可以使用“同步块”
		 * synchronized(同步监视器){ 需要同步的代码片段 }
		 * 同步监视器：需要上锁的对象，若想保证具有同步效力，多个线程看到的应当是相同中的对象。 通常选取使用this即可。
		 */
		synchronized (Review.class) {
			// 。。。
		}

		/**
		 * wait与notify 这两个方法是在Object上定义的，也就是说所有的对象都具有这两个方法
		 * 当一个线程调用一个对象的wait方法后，该线程进入阻塞状态，直到这个对象 的notify方法被调用后，当前线程方可解除阻塞
		 * 这样的好处是在协调两个工作时可以更加灵活
		 */
		try {
			t.wait();// 等待
		} catch (InterruptedException e) {
		}
		t.notify();// 唤醒
	}

	// xml
	public static void testXml() {
		/*
		 * 写出Xml的步骤： １：创建一个Document对象，表示文档内容 ２：向Document中添加一个元素（根元素）
		 * ３：向根元素中按照层级结构组建整个xml内容 ４：通过XMLWriter将Document写出完成工作
		 * 具体看xml包下的WriteXmlDemo类
		 */
		/*
		 * 解析xml过程： １：创建用于解析xml文档的SAXReader
		 * ２：使用SAXReader去解析给定的zml文档，并生成Doxument对象，
		 * 这一步就是耗时耗资源的步骤，因为在这里就会将xml文档全部解析完毕，并以
		 * Document对象的形式返回，由于对象的内存中，所有相当于将整个xml文档内容嵌入了内存 ３：通过Document获取根元素（根标签）
		 * ４：通过遍历根标签下的子标签，子标签下的子标签这样一层一层的最终将xml文档中所有内容全部获取到。
		 * 具体看xml包下的ParseXmlDemo类
		 */
	}

	// jdbc
	public static void testJdbc() {
		/*
		 * JDBC:java数据库连接 使用JDBC连接数据库的基本操作流程： 1：加载驱动类 2：与数据库建立连接 3：执行SQL语句
		 * 4：处理结果集 5：关闭连接
		 */
		try {
			// 1：加载驱动类
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2，通过DriverManager建立与数据库的连接
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:///", "gg2014", "gg2014");
			// 3：执行SQL语句
			Statement state = conn.createStatement();
			String sql = "SELECT ename,job,sal,deptno FROM  emp_pillow ";
			ResultSet rs = state.executeQuery(sql);
			state.addBatch(sql);// 批量执行
			state.executeBatch();
			/*
			 * Statement针对不同的SQL语句提供了不同的 执行方法。 ResultSet executeQuery(String
			 * sql) 该方法专门用来执行DQL语句，返回的ResultSet 表示查询出来的结果集
			 * 
			 * int exceuteUpdate（String sql） 该方法专门用来执行DML语句，返回的数字表示
			 * 执行该语句后影响了表中多少条数据
			 * 
			 * boolean execute (String sql) 该方法理论上什么语句都可以执行，但是由于
			 * DQL，DML都有专门的方法执行了，扎该方法 通常用来执行DDL语句。
			 * 
			 * 该方法的返回值表示执行SQL语句后是否存在 结果集。存在则返回true 基SQL语句本身有错误
			 * 执行会抛出异常：SQLException
			 */
			// 4:遍历结果集获取查询结果
			while (rs.next()) {
				// 获取员工的名字 参数可以是字符串或下标从1形如
				String ename = rs.getString("ename");
				// ....
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		testDeque();
	}

	// ------------------------抽取的方法-----------------
	// 删除file
	public static void deleteFile(File file) {
		if (file.isDirectory()) {
			File[] subs = file.listFiles();
			for (File sub : subs) {
				deleteFile(sub);// 自己调用自己，递归
			}
		}
		file.delete();
	}
}

// 自定义比较器类
class MyCompare implements Comparator<String> {

	@Override
	public int compare(String s1,String s2) {
		return s1.length() - s2.length();
	}
	
}

// 第一种线程类1
class MyThread1 extends Thread {
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("你是谁啊？");
		}
	}
}

// 第一种线程类2
class MyThread2 extends Thread {
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("我是查水表的！");
		}
	}
}

// 第二种线程类1
class MyRunnable1 implements Runnable {
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("你是谁啊？");
		}
	}
}

// 第二种线程类1
class MyRunnable2 implements Runnable {
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("我是查水表的！");
		}
	}
}