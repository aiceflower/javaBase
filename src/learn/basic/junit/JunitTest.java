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
	 * ����String
	 */
	@Test
	public void testString() throws Exception {
		String str = "abcdef";
		System.out.println();
	}
	
	/**
	 *�������� 
	 */
	@Test
	public void testReg(){
		String str = "892604768";
		String s = StringUtil.getStrByReg(str, CommonRegex.QQ);
		System.out.println(s);
	}
	/**
	 * ��������ǰ����
	 */
	@Test
	public void testLPadZero(){
		String l = StringUtil.leftPad(5, 4,'x');
		System.out.println(l);
		String s = StringUtil.lPadZero(5, 4);
		System.out.println(s);
	}
	
	/**
	 * ���԰��쳣ת��Ϊ�ַ���
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
	 * ����java���������ַ���
	 */
	@Test
	public void testMapValue(){
		System.out.println(StringUtil.nextString(32));//��
		System.out.println(StringUtil.nextSessionId(34).length());//��ȫ
	}
	/**
	 * ���Բ����޸ĵ�Map
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
		map2.put("wangwu", 18);//��仰����
		System.out.println(map2);
	}
	
	/**
	 * ���Դ�����������
	 */
	@Test
	public void testCreateGenericArray(){
		Integer[] arr = Array.getArray(Integer.class, 5);
		System.out.println(arr.length);
	}
	
	/**
	 * ���Ի�ȡMD5ֵ
	 */
	@Test
	public void testMD5(){
		System.out.println(MD5Util.getMD532("hjfu5"));
	}
	
	/**
	 * ����ThreadLocal
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
	 * ����ö��ʹ��switch
	 */
	@Test
	public void testEnumSwitch() {
		switch (EnumDemo.hofailure) {
		case hofailure:
			System.out.println("�ɹ�");
			break;
		case hosuccess:
			System.out.println("ʧ��");
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
		System.out.println(ld4 - ld3);// 353,����jdk1.6��ld6-ld5=1
	}

	/**
	 * ���Դ����ļ������ļ���д����
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
	 * ���Դ�������
	 */
	@SuppressWarnings("unused")
	@Test
	public void testCreateArray() {
		// ������������
		int ints1[] = new int[3];
		int ints2[] = { 1, 2, 3 };
		int ints3[] = new int[] { 1, 2, 3 };
		// String
		String strs1[] = new String[3];
		String strs2[] = { "a", "b", "c" };
		String strs3[] = new String[] { "a", "b", "c" };
		// ����
		Book books1[] = new Book[3];
		Book books2[] = { new Book(), new Book(), new Book() };
		Book books3[] = new Book[] { new Book(), new Book(), new Book() };
	}

	/**
	 * ����ö�ٻ�ȡͯ����
	 */
	@Test
	public void testEnumSingleton() {
		/*
		 * ��ö����������ȷ�˹��췽������Ϊ˽�У������Ƿ���ö��ʵ��ʱ��ִ�й��췽���� ͬʱÿ��ö��ʵ������static
		 * final���͵ģ�Ҳ�ͱ���ֻ�ܱ�ʵ����һ�Ρ�
		 * Ҳ����˵����Ϊÿ��enum�е�ö�ٳ�������ֻ֤�ᱻʵ����һ�Σ��������ǵ�singletonҲ����֤ʵ����һ�Ρ�
		 * ö�ٽ��бȽϿ�����equalsҲ����==����Ϊÿ��ö�ٳ���ֻ��һ��ʵ����һ����==
		 */
		Book b1 = EnumSingleton.singleton.getBook();
		Book b2 = EnumSingleton.singleton.getBook();
		System.out.println(b1 == b2);
	}

	/**
	 * ���Ը���String��ȡö�ٶ���
	 */
	@Test
	public void testEnum() {
		EnumDemo hand = EnumUtils
				.getEnumFromString(EnumDemo.class, "hosuccess");
		System.out.println(hand.getFlag());
	}

	/**
	 * ���Դ���List
	 */
	@SuppressWarnings("serial")
	@Test
	public void testList() {
		List<String> list;
		// ����
		list = Collections.singletonList("1");
		// list.add("2");//����
		System.out.println(list);
		list = Arrays.asList("x", "y", "z");
		// list.add("t");//����
		System.out.println(list);
		// �䳤
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
	 * java����ָ����Χ�������
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
	 * ����setת��Ϊmap
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
	 * ����null�Ĺ�ϵ
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
	 * ���Բ�����
	 */
	@Test
	public void testOperate() {
		int i = 1;
		double j = 2.3;
		// i = i+j ����
		i += j;// ����
		System.out.println(i);
	}

	/**
	 * ����stringת��Ϊint
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
	 * ���Բ����������Ƿ����ָ������
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
		b1.setName("����");
		b1.setYear("2017");
		Book b2 = new Book();
		b2.setName("����");
		b2.setYear("2018");
		Book b3 = new Book();
		b3.setName("����");
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
		 * java����дequals������Ҫ��
		 * 
		 * 1.�Է���x.equals(x)����true
		 * 
		 * 2.�Գ���y.equals(x)����true��x.equals(y)��Ӧ����true
		 * 
		 * 3.������x.equals(y)��y.equals(z)������true��x.equals(z)Ӧ����true
		 * 
		 * 4.һ���Զ����κηǿ�����x��y����ε���x.equals(y)ʼ�շ���true��false
		 * 
		 * 5.�����κηǿ�����x��x.equals(null)��Ӧ����false
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
		// ����һά�������ά����ռ���ڴ��С֮һά����
		int a[] = new int[1024 * 1024 * 2];
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
		}
		System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024);
	}

	@Test
	public void test5() {
		// ����һά�������ά����ռ���ڴ��С֮��ά����
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
		Text nameText = parse.createTextNode("����");
		name.appendChild(nameText);

		Element age = parse.createElement("age");
		Text ageText = parse.createTextNode("19");
		age.appendChild(ageText);

		Element gender = parse.createElement("gender");
		Text genderText = parse.createTextNode("Ů");
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
