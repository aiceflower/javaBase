package learn.basic.junit;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import learn.basic.array.Array;
import learn.basic.date.DateUtil;
import learn.basic.encryption.MD5Util;
import learn.basic.enums.EnumDemo;
import learn.basic.enums.EnumSingleton;
import learn.basic.enums.EnumUtils;
import learn.basic.file.FileUtil;
import learn.basic.math.MathUtil;
import learn.basic.string.CommonRegex;
import learn.basic.string.StringUtil;
import learn.basic.xml.Book;

import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class JunitTest {
	
	/*
	 * 测试String
	 */
	@Test
	public void testString() throws Exception {
		String str = "abcdef";
		System.out.println();
	}
	
	/**
	 *测试正则 
	 */
	@Test
	public void testReg(){
		String str = "892604768";
		String s = StringUtil.getStrByReg(str, CommonRegex.QQ);
		System.out.println(s);
	}
	/**
	 * 测试整数前补零
	 */
	@Test
	public void testLPadZero(){
		String l = StringUtil.leftPad(5, 4,'x');
		System.out.println(l);
		String s = StringUtil.lPadZero(5, 4);
		System.out.println(s);
	}
	
	/**
	 * 测试把异常转换为字符串
	 */
	@Test
	public void TestThrowable(){
		try {
			System.out.println(3/0);
		} catch (Exception e) {
			System.out.println(StringUtil.parseThrowableToStr(e));
		}
	}
	/**
	 * 测试java生成数字字符串
	 */
	@Test
	public void testMapValue(){
		System.out.println(StringUtil.nextString(32));//快
		System.out.println(StringUtil.nextSessionId(34).length());//安全
	}
	/**
	 * 测试不可修改的Map
	 */
	@Test
	public void testUnModifiableMap(){
		@SuppressWarnings("serial")
		Map<String,Object> map = new HashMap<String, Object>(){
			{
				put("zhangsan",12);
				put("lisi",15);
			}
		};
		Map<String, Object> map2 = Collections.unmodifiableMap(map);
		map2.put("wangwu", 18);//这句话报错
		System.out.println(map2);
	}
	
	/**
	 * 测试创建泛型数组
	 */
	@Test
	public void testCreateGenericArray(){
		Integer[] arr = Array.getArray(Integer.class, 5);
		System.out.println(arr.length);
	}
	
	/**
	 * 测试获取MD5值
	 */
	@Test
	public void testMD5(){
		System.out.println(MD5Util.getMD532("hjfu5"));
	}
	
	/**
	 * 测试ThreadLocal
	 */
	@Test
	public void testThreadLocal(){
		SimpleDateFormat fm1 = DateUtil.getSimpleDateFormat();
		SimpleDateFormat fm2 = DateUtil.getSimpleDateFormat();
		System.out.println(fm1==fm2);
		String f1 = DateUtil.formatDate(new Date(),"yyyy-MM-dd");
		System.out.println(f1);
		String f2 = DateUtil.formatDate(new Date());
		System.out.println(f2);
	}
	
	/**
	 * 测试枚举使用switch
	 */
	@Test
	public void testEnumSwitch() {
		switch (EnumDemo.hofailure) {
		case hofailure:
			System.out.println("成功");
			break;
		case hosuccess:
			System.out.println("失败");
		}
	}

	@Test
	public void testTime() throws ParseException {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str3 = "1927-12-31 23:54:07";
		String str4 = "1927-12-31 23:54:08";
		// String str5 = "1927-12-31 23:54:07";
		// String str6 = "1927-12-31 23:54:08";
		Date sDt3 = sf.parse(str3);
		Date sDt4 = sf.parse(str4);
		long ld3 = sDt3.getTime() / 1000;
		long ld4 = sDt4.getTime() / 1000;
		System.out.println(ld4 - ld3);// 353,仅限jdk1.6，ld6-ld5=1
	}

	/**
	 * 测试创建文件并向文件中写内容
	 */
	@Test
	public void testCreateFile() {
		List<String> lines = Arrays.asList("one line", "two line");
		try {
			FileUtil.writeFile("c:\\test.txt", lines);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 测试创建数组
	 */
	@SuppressWarnings("unused")
	@Test
	public void testCreateArray() {
		// 基本数据类型
		int ints1[] = new int[3];
		int ints2[] = { 1, 2, 3 };
		int ints3[] = new int[] { 1, 2, 3 };
		// String
		String strs1[] = new String[3];
		String strs2[] = { "a", "b", "c" };
		String strs3[] = new String[] { "a", "b", "c" };
		// 对象
		Book books1[] = new Book[3];
		Book books2[] = { new Book(), new Book(), new Book() };
		Book books3[] = new Book[] { new Book(), new Book(), new Book() };
	}

	/**
	 * 测试枚举获取童单例
	 */
	@Test
	public void testEnumSingleton() {
		/*
		 * 在枚举中我们明确了构造方法限制为私有，在我们访问枚举实例时会执行构造方法， 同时每个枚举实例都是static
		 * final类型的，也就表明只能被实例化一次。
		 * 也就是说，因为每个enum中的枚举常量被保证只会被实例化一次，所以我们的singleton也被保证实例化一次。
		 * 枚举进行比较可以用equals也可用==，因为每个枚举常量只有一个实例，一般用==
		 */
		Book b1 = EnumSingleton.singleton.getBook();
		Book b2 = EnumSingleton.singleton.getBook();
		System.out.println(b1 == b2);
	}

	/**
	 * 测试根据String获取枚举对象
	 */
	@Test
	public void testEnum() {
		EnumDemo hand = EnumUtils
				.getEnumFromString(EnumDemo.class, "hosuccess");
		System.out.println(hand.getFlag());
	}

	/**
	 * 测试创建List
	 */
	@SuppressWarnings("serial")
	@Test
	public void testList() {
		List<String> list;
		// 定长
		list = Collections.singletonList("1");
		// list.add("2");//报错
		System.out.println(list);
		list = Arrays.asList("x", "y", "z");
		// list.add("t");//摄氏
		System.out.println(list);
		// 变长
		list = new ArrayList<String>() {
			{
				add("zhangsan");
				add("lisi");
				add("wangwu");
			}
		};
		list.add("zhaoliu");
		System.out.println(list);
		list = new ArrayList<String>(Arrays.asList("aa", "bb", "cc"));
		list.add("dd");
		System.out.println(list);
	}

	/**
	 * java生成指定范围的随机数
	 */
	@Test
	public void testRandom() {
		int min = 5;
		int max = 10;
		for (int i = 0; i < 1000; i++) {
			System.out.println(MathUtil.randomInt(min,max));
		}
	}

	/**
	 * 测试set转换为map
	 */
	@Test
	public void testSetToMap() {
		Set<String> set = new HashSet<String>();
		set.add("zhangsan");
		set.add("lisi");
		set.add("wangwu");
		Map<Integer, String> map = new HashMap<Integer, String>();
		int i = 0;
		for (String string : set) {
			map.put(i, string);
			i++;
		}
		System.out.println(map);
	}

	/**
	 * 测试null的关系
	 */
	@Test
	public void testNull() {
		System.out.println(null == null);// true
	}

	@SuppressWarnings("unused")
	@Test
	public void testBoolean() {
		boolean b = true;
		boolean f = false;
		// System.out.println(b|true);//true
		// System.out.println(b|=false);//true
		// System.out.println(f|=true);//true
		// System.out.println(f|=false);//false
	}

	/**
	 * 测试操作符
	 */
	@Test
	public void testOperate() {
		int i = 1;
		double j = 2.3;
		// i = i+j 报错
		i += j;// 正常
		System.out.println(i);
	}

	/**
	 * 测试string转换为int
	 */
	@Test
	public void testStringToInt() {
		String str = "123";
		int i = Integer.valueOf(str);
		int j = Integer.parseInt(str);
		System.out.println(i);
		System.out.println(j);
	}

	/**
	 * 测试查找数组中是否包含指定内容
	 */
	@Test
	public void testBinarySearch() {
		String arrs[] = { "java", "c++" };
		int res = Arrays.binarySearch(arrs, "java");
		System.out.println(res >= 0);
	}

	@SuppressWarnings("static-access")
	@Test
	public void testArrayToList() {

		Book b1 = new Book();
		b1.setName("张三");
		b1.setYear("2017");
		Book b2 = new Book();
		b2.setName("李四");
		b2.setYear("2018");
		Book b3 = new Book();
		b3.setName("王五");
		b3.setYear("2019");
		Book books[] = { b1 };
		Array a = new Array();
		Book[] books2 = a.arraycopy(books, 2);
		books2[1] = b2;
		books2[2] = b3;
		Book[] books3 = Array.shuffle(books2);
		for (Book book : books3) {
			System.out.println(book.getName());
		}
	}

	@Test
	public void test1() {
		String randomString = StringUtil.getNoRepeatRandomString(20);
		System.out.println(randomString);
		String str = "";
		Assert.assertEquals(true, StringUtil.notNullOrEmpty(str));
	}

	@Test
	public void test2() {
		/**
		 * java中重写equals方法的要求
		 * 
		 * 1.自反性x.equals(x)返回true
		 * 
		 * 2.对称性y.equals(x)返回true，x.equals(y)才应返回true
		 * 
		 * 3.传递性x.equals(y)与y.equals(z)都返回true则x.equals(z)应返回true
		 * 
		 * 4.一致性对于任何非空引用x和y，多次调用x.equals(y)始终返回true或false
		 * 
		 * 5.对于任何非空引用x，x.equals(null)都应返回false
		 */
	}

	@SuppressWarnings("unused")
	@Test
	public void test3() {

		Integer a[] = new Integer[] { 1, 2, 3, 4, 5, 6 };
		List<Integer> list = Arrays.asList(a);
	}

	public static String enc(String str, char key) {
		byte[] bt = str.getBytes();
		for (int i = 0; i < bt.length; i++) {
			bt[i] = (byte) (bt[i] ^ (int) key);
		}
		return new String(bt, 0, bt.length);
	}

	@Test
	public void test4() {
		// 测试一维数组与二维数组占用内存大小之一维数组
		int a[] = new int[1024 * 1024 * 2];
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
		}
		System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024);
	}

	@Test
	public void test5() {
		// 测试一维数组与二维数组占用内存大小之二维数组
		int arr[][] = new int[1024 * 1024][2];
		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = i;
			arr[i][1] = i;
		}
		System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024);
	}

	@Test
	public void test6() throws Exception {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory
				.newDocumentBuilder();
		Document parse = documentBuilder.parse("src/person.xml");
		NodeList childNodes = parse.getChildNodes();
		System.out.println(childNodes);
		Node p1 = childNodes.item(0);
		Element user = parse.createElement("user");

		Element name = parse.createElement("name");
		Text nameText = parse.createTextNode("王五");
		name.appendChild(nameText);

		Element age = parse.createElement("age");
		Text ageText = parse.createTextNode("19");
		age.appendChild(ageText);

		Element gender = parse.createElement("gender");
		Text genderText = parse.createTextNode("女");
		gender.appendChild(genderText);

		user.appendChild(name);
		user.appendChild(age);
		user.appendChild(gender);

		p1.appendChild(user);

		TransformerFactory tfs = TransformerFactory.newInstance();
		Transformer tf = tfs.newTransformer();
		tf.transform(new DOMSource(parse), new StreamResult("src/person.xml"));

	}
}
