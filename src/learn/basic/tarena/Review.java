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
 * ��ϰ֪ʶ��
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
		System.out.println("���������䣺");
		int age = scan.nextInt(); 
		System.out.println("age="+age);
	}
	//Array
	public static void testArray(){
		int arr1[] = {1,3,5,6};
		/*
		 * ���鸴�� 1.ʹ��ѭ���ṹ ���ַ��������,������϶� 2.ʹ��Object���clone��������,��,�����Ҳ��Ч�����.
		 * 3.ʹ��Systems��arraycopy 4.Arrarys���copyOf����������copyOfRange��������
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
		sb.append("�Ϻ�����ˮ���Ժ���");// ׷��
		sb.insert(3, "��");// ����
		sb.replace(0, 2, "�滻");// �滻
		sb.delete(0, 2);// ɾ��
		sb.reverse();// ��ת
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
															// equals�����hashCode���
		//--------------------------------
		/**
		 * ��������һ���Ż���ʩ���ڱ���Դ����ʱ����������ʽ���ߵ����ݶ���������
		 * ��ô��ֱ�Ӽ��㣬����������뵽�ֽ����ļ��У������ĺô�����JVM����ʱ�� ��ÿ�ζ������ˣ����ԣ�����Ĵ������ֽ����ļ���Ϊ�� String
		 * s4= "123abc";
		 */
		String s4 = "123"+"abc";  
		System.out.println(s1==s4);//true
		
		//----------------------------------
		String s5 = "123";
		// ����s5Ϊ���������Ա����������㣬�����������㣬��s6ͬs4��s1��һ��
		String s6 = s5+"abc";
		System.out.println(s4.hashCode()+","+s4);
		System.out.println(s6.hashCode()+","+s6);
		System.out.println(s4==s6);
		// ����--------------------------------------------
		s1.length();// ���㳤��
		
		s1.indexOf("abc");// �鿴�������ַ����ڵ�ǰ�ַ����е�λ��,��û���򷵻�-1
		s1.indexOf("abc",2);
		s1.lastIndexOf("abc");
		s1.lastIndexOf("abc",2);
		
		s1.subSequence(0, 3);// ��ȡ�Ӵ�
		
		s1.trim();// ȥ����ǰ�ַ������ߵĿհ�
		
		s1.charAt(3);// �鿴�ַ�
		
		s1.startsWith("123");
		s1.endsWith("abc");
		
		s1.concat("abc");// ����
		
		s1.contains("abc");// �ж�
		s1.indexOf("abc");// Ҳ�������жϣ�����-1��ʾû��
		s1.matches("[aaa]");// ƥ�䣬����
		s1.split(",");// �и����
		s1.replace("123", "abc");// �滻
		s1.replaceAll("[abc]", "aaa");// �滻������
		/*
		 * ���ַ�Χ '\u4e00'----'\u9fa5'
		 */
		//
		/**
		 * ��дӦ���㣺 �κ�ʱ�򣬶��ڷǿ�����x����Ӧ����x.equals(null)����false �Է��ԣ�x.equals(x)����true
		 * �Գ��ԣ�x.equals(y)����true,y.equals(x)ҲӦ������true
		 * �����ԣ�x.equals(y)Ϊtrue,y.equals(z)ҲΪtrue,x.equals(z)��Ӧ��Ϊtrue
		 * һ���ԣ�����ǰ����x����equals�Ƚϵ�����û�з������ı䣬��ô��ε���x.equals(y)����ֵӦ��һ��
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
		int a = i.intValue();// ��װ����תΪ��ͨ���� xxxValue()
		int max = Integer.MAX_VALUE;// ��ȡ�����Сֵ
		String str = "123";
		int b = Integer.parseInt(str);// ���ַ���ת��Ϊ��Ӧ�Ļ�����������
		// ʮ����ת��������
		String s1 = Integer.toBinaryString(33);//toXXXString();
		System.out.println(s1);
		// ��������תʮ����
		int i1 = Integer.parseInt("1111", 2);
		System.out.println(i1);
	}

	// ����Calendar
	@SuppressWarnings("static-access")
	public static void testCalendar() throws ParseException {
		Calendar c1 = Calendar.getInstance();// ��ȡʵ����Ĭ��Ϊϵͳ��ǰʱ��
		System.out.println(c1);
		Date time = c1.getTime();// ��ȡ����
		System.out.println(time);
		// ����------------------------------------
		c1.setTime(time);// �����ռ�
		// ���þ�������
		/*
		 * ϣ����ʾΪ��2008-08-08 20:08:00
		 */
		// ������Ϊ:2008 ʱ�����ʹ�ó�������
		c1.set(c1.YEAR,2008);
		// ������ 0��ʾ1�£��Դ�����
		c1.set(c1.MONTH,c1.AUGUST);
		// ������
		/*
		 * �ն�Ӧ��ʱ������� DATE:���е��죬�׳ƣ����� DAY_OF_MONTH ���е��죬��DATEһ��
		 * 
		 * DAY_OF_WEEK:�����е��죬�������ڼ�
		 * 
		 * DAY_OF_YEAR:�����еĵڼ���
		 */
		c1.set(c1.DAY_OF_MONTH,8);
		// ����ʱ
		c1.set(c1.HOUR_OF_DAY,20);
		// ���÷�
		c1.set(c1.MINUTE,8);
		// ������
		c1.set(c1.SECOND,60);
		/*
		 * �鿴08��ĵ�165�죿
		 */
		c1.set(c1.DAY_OF_YEAR,165);
		// ��ȡ-------------------------
		// ��ȡ�ꣿ
		int year = c1.get(c1.YEAR);
		// ��ȡ�£�
		int month = c1.get(c1.MONTH);
		// ��ȡ�գ�
		int day = c1.get(c1.DAY_OF_MONTH);
		// �ܼ���
		/*
		 * һ�ܵĵ�һ�������գ� 1:���� 2:��һ ...
		 */
		int week = c1.get(c1.DAY_OF_WEEK);
		// ------------------------------------------
		// ʹ��Calendar����ʱ��
		// �鿴�����º�Ľ���
		c1.add(c1.MONTH, 3);
		// �鿴25���Ժ󣿼���ʹ��DAY_OF_YEAR
		c1.add(c1.DAY_OF_YEAR, 25);
		// һ��ǰ�Ľ���
		c1.add(c1.YEAR, -1);
		// �鿴
		// �鿴����һ��������
		int days = c1.getActualMaximum(Calendar.DAY_OF_YEAR);
		// �鿴����һ��������
		int days1 = c1.getActualMaximum(Calendar.DAY_OF_MONTH);

		// ����
		Date d1 = new Date();
		long l = d1.getTime();// ��ȡ�ڲ�ά����longֵ����¼��1970��Ԫ������ʱ��֮��ĺ����

		// ��ʽ������,����תString
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HHʱmm��ss��");
		String str = sdf.format(d1);
		// Stringת����
		String str1 = "2008��08��08�ա�20��08��00��";
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy��MM��dd�ա�HH��mm��ss��");
		Date date = sdf1.parse(str1);// ���׳��쳣
	}

	// Collection ����
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void testCollection() {
		Collection c = new ArrayList();
		c.add("one");// ���
		c.size();// ��ȡ����Ԫ������
		c.isEmpty();// �鿴��ǰ�����Ƿ񲻺����κ�Ԫ��
		c.clear();// ��ռ���
		c.contains("one");// �鿴�����Ƿ��������Ԫ��

		// ���ϴ洢����Ԫ�ص�����
		int a[] = { 1, 2, 3 };
		c.add(a);
		a[2] = 7;// �޸�
		for (Object o : c) {
			int aaa[] = (int[]) o;
			// ����Ҳ�������޸ĺ��Ч��
			System.out.println(Arrays.toString(aaa));
		}
		// ���ϴ洢����Ԫ�ص�����

		// ����ת���ϣ�ֻ��ת��ΪList����
		String[] array = { "one", "two", "three" };
		List<String> list = Arrays.asList(array);
		// �޸ļ���Ԫ�ص����޸�����Ԫ��
		list.set(0, "1");
		System.out.println(Arrays.toString(array));

		// ����ת����
		String[] array1 = list.toArray(new String[list.size()]);
		System.out.println(Arrays.toString(array1) + "............");

		// ���еļ��϶�֧��һ������Collection�����Ĺ��췽��
		List<String> list1 = new ArrayList<String>(list);
		list1.add("two");
		System.out.println(list1);
		Set<String> set = new HashSet<>(list1);
		System.out.println(set);

		// ��������
		list1.addAll(list);// ���
		list1.containsAll(list);// �ж�
		// ��������1----------------------------
		// �����ṩ��ͳһ�ı�����ʽ��������,ʹ�õ�������������Ҫ��ѭ������ȡɾ����˳������ɾ�����Ǳ����
		Iterator it = list1.iterator();
		while (it.hasNext()) {
			// ȡ: E next() �÷������ڴӼ�����ȡ����ǰ�ɱ�����Ԫ��
			String str = (String) it.next();
			System.out.println(str);
		}
		// ��������2,����ǿת----------------------------
		System.out.println("---------------------");
		Iterator<String> it1 = list1.iterator();
		while (it1.hasNext()) {
			String str = it1.next();
			System.out.println(str);
			// ɾ��
			if ("#".equals(str)) {
				// ���������в�Ҫͨ�����Ϸ����޸�Ԫ������
				// c.remove(str);
				/*
				 * ɾ��ֻ��ͨ���������ṩ��ɾ������ ��ɾ��������ͨ��next()����������Ԫ��
				 */
				it.remove();
			}
		}
	}

	// list
	public static void testList() {
		// List�����ǿ��ظ������������ص��ǿ��Ը����±����Ԫ�أ���һ������������
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");

		String str = list.get(2);// ��ȡ
		System.out.println(str);

		list.add(1, "four");// ����
		String old = list.remove(3);// ɾ��
		System.out.println(old + ".......");

		// ����
		for (String s : list) {
			System.out.println(s);
		}
		// List���Ի�ȡ�Ӽ�
		List<String> subList = list.subList(0, 2);
		subList.add("five");
		System.out.println(subList);
		System.out.println(list);// �Ӽ��޸ĺ�ԭ����Ҳ�����޸�
		// ����
		// ���ϵ�����ֻ����List����,Set�󲿷�ʵ��������ģ���������û����
		// Ҫ�����List�����е�Ԫ�ر����ǿ��ԱȽϴ�С�ġ�java�ṩ��һ���ӿ�Comparable
		// ֻ��ʵ���˸ýӿڵ���ž��пɱ��ԣ��ſ���ͨ��sort����������Ȼ����
		Collections.sort(list);
		// ���Ƚ����Ƚ�
		Collections.sort(list,new MyCompare());
	}

	// map
	public static void testMap() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("����", 98);
		map.put("��ѧ", 97);
		map.put("Ӣ��", 95);
		map.put("����", 99);
		map.put("��ѧ", 98);

		// ͨ��key��ȡvalue
		Integer num = map.get("����");
		// �滻value
		Integer old = map.put("����", 100);// ����ԭvalue
		// �ж��Ƿ����key
		boolean tk = map.containsKey("����");
		// �ж��Ƿ����value
		boolean tv = map.containsValue(99);
		// ����
		// * 1���������е�Map
		// * 2���������е�Key-Value��
		// * 3���������е�Value�������ã�
		/*
		 * �������е�key Set keySet()
		 * �÷����Ὣ��ǰMap�����е�key����һ��Set���Ϻ󷵻أ����Ա����ü��Ͼ��൱�ڱ��������е�key.
		 */
		Set<String> s1 = map.keySet();
		// ֮һ
		Iterator<String> it = s1.iterator();
		while (it.hasNext()) {
			String key = it.next();
			Integer value = map.get(key);
			System.out.println(key + "..." + value);
		}
		// ֮��
		System.out.println("-----------------------");
		for (String s : s1) {
			Integer value = map.get(s);
			System.out.println(s + "..." + value);
		}

		/*
		 * ����ÿһ���ֵ�� ��Map�У�ÿһ���ֵ����һ��Map���ڲ���
		 * Entry��ʵ����ʾ��Entry�ṩ�����������ֱ���getKey(),getValue()������ȡ��һ���ֵ���е�key��value
		 * 
		 * Map�ṩ��һ������ Set entrySet() �÷����Ὣ��ǰMap��ÿһ���ֵ�Զ�Ӧ��Entryʵ������һ�����Ϻ󷵻ء�
		 * ���Ա��������е�ÿһ��Entryʵ�����ٷֱ��ȡkey,value�ʹﵽ�˱���ÿһ���ֵ��Ŀ��
		 */
		Set<Entry<String, Integer>> set1 = map.entrySet();
		for (Entry<String, Integer> e : set1) {
			String key = e.getKey();
			Integer value = e.getValue();
			System.out.println(key + "..." + value);
		}
		// Ҳ����Iterator������
		/*
		 * ���Ƽ��� �������е�value Collection values() �÷����Ὣ���е�value����һ�����Ϻ󷵻�
		 */
		System.out.println(".............................");
		Collection<Integer> values = map.values();
		for (Integer value : values) {
			// ͨ��value��ȡkey
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
		queue.offer("two");// ���β����Ԫ��
		String s1 = queue.poll();// �Ӷ��׻�ȡһ��Ԫ�أ�ȡ�����Ԫ�ؾʹӶ����б��Ƴ��ˣ������ǳ��Ӳ���
		String s2 = queue.peek();// ���ö���Ԫ�أ����������Ӳ���
		int size = queue.size();// ��ȡ��ǰ���е�Ԫ�ظ���
		// ����
		while (queue.size() > 0) {
			System.out.println(queue.poll());
		}
	}

	// deque
	public static void testDeque() {
		Deque<String> stack = new LinkedList<String>();
		stack.push("one");// ��ջ�С�ѹ�롱��Ԫ�أ���Ԫ�ؾͻᴦ��ջ��
		stack.push("two");
		String str = stack.pop();// ��ջ����ȡԪ�أ���ȡ���Ԫ�ػ��ջ�б�ɾ��
		str = stack.peek();// ����ջ��Ԫ��,����ɾ��
		System.out.println(stack);
		// ����
		while (stack.size() > 0) {
			str = stack.pop();
			System.out.println(str);
		}
	}

	// --------------------------�ļ�IO���--------------------------------------
	// file
	public static void testFile() throws IOException {
		// ͨ��File���ǿ��ԣ�
		// * ������ȡ�ļ���Ŀ¼��������Ϣ
		// * ���������ļ���Ŀ¼��������ɾ����
		File file = new File("." + File.separator + "demo.txt");
		// ��ȡ�ļ���
		String name = file.getName();
		// ��ȡ�ļ���С���ֽ�����
		long length = file.length();
		// �жϵ�ǰFile�����ʾ���Ƿ�Ϊһ���ļ�
		boolean isFile = file.isFile();
		// �жϵ�ǰFile�����ʾ���Ƿ�Ϊһ��Ŀ¼
		boolean isDir = file.isDirectory();
		// �鿴�ļ�����޸�ʱ��
		long last = file.lastModified();
		Date date = new Date(last);
		// �����жϲ����ڣ���������Ҫ�������ļ�
		if (!file.exists()) {
			file.createNewFile();// ����file
		}
		file.delete();// ɾ��file
		// --------------------------
		File dir = new File("demo");
		if (!dir.exists()) {// �ж�
			dir.mkdir();// ����Ŀ¼
		}
		dir.delete();// ɾ����Ŀ¼
		// --------------------
		File dirs = new File("a" + File.separator + "b" + File.separator + "c"
				+ File.separator + "f");
		if (!dirs.exists()) {
			dirs.mkdirs();// ���༶Ŀ¼
		}
		// �ݹ�ɾ��������file����
		deleteFile(dirs);
		// ------------------------------
		// ��ȡ��ǰ�ļ��µ���������
		File f = new File(".");
		File[] subs = f.listFiles();// ��ȡ��������
		for (File sub : subs) {
			System.out.println((sub.isFile() ? "�ļ���" : "Ŀ¼��") + sub.getName());
		}
		// ���չ���������ȡ����--------------------------------
		FileFilter ff = new FileFilter() {

			@Override
			public boolean accept(File pathname) {
				System.out.println("���ڹ��ˣ�" + pathname.getName());
				return pathname.getName().startsWith(".");
			}
		};
		subs = f.listFiles(ff);
		for (File sub : subs) {
			System.out.println("���" + sub.getName());
		}
	}

	// randomAccessFile
	public static void testRandomAccessFile() throws IOException {
		@SuppressWarnings("resource")
		// "r":ֻ��, "rw":��д
		RandomAccessFile raf = new RandomAccessFile("abc.txt", "rw");// �׳��쳣FileNotFoundException
		raf.write(1);
		raf.writeInt(3);
		raf.writeDouble(3d);
		raf.writeChar('a');// д�������������
		raf.write("abcdef".getBytes());// �׳��쳣IOException
		raf.writeChars("abcdef");
		raf.close();// �ر�
		byte[] buf1 = new byte[1024 * 10];
		int len1 = raf.read(buf1);
		raf.write(buf1, 0, len1);
		int i = raf.read();// ��ȡһ���ֽڣ�����int����ʽ����,����-1��˵����ȡ���ļ�ĩβ��EOP(end of file)
		// ������ȡ
		byte[] buf = new byte[100];
		int len = raf.read(buf);// ����ֵΪʵ�ʶ�ȡ�����ֽ���
		String str = new String(buf, 0, len, "UTF-8");
		// -------------------------------------------
		// ��ȡָ�뵱ǰλ�ã�Ĭ��Ϊ�ļ��ĵ�һ���ֽڣ��ǣ�
		long pos = raf.getFilePointer();
		raf.seek(0);// �÷���������ָ���ƶ���ָ��λ��
		int ii = raf.readInt();// ������ȡ4���ֽڲ�ת��Ϊintֵ����
		double dd = raf.readDouble();// ������ȡ8���ֽڲ�ת��Ϊdoubleֵ����
		raf.skipBytes(8);// ��ָ�뵱ǰλ�ô���ʼ�����������������ֽ���
	}

	// io
	public static void testIo() throws IOException, ClassNotFoundException {
		// �ļ���,�ͼ���,���ڴ��ļ��ж�д���ݵ���
		FileInputStream fis = new FileInputStream(new File("in.txt"));// �׳�FileNotFoundException
		FileOutputStream fos = new FileOutputStream(new File("out.txt"));
		FileOutputStream fos1 = new FileOutputStream(new File("out.txt"), true);// ׷��ģʽ

		// �����ֽ���,����ֽڶ�дЧ�ʣ��߼���������flush
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		bos.write("aaaa".getBytes());
		bos.flush();// ǿ�ƽ��������е�����һ����д����Ƶ�����ø÷��������д�������Ӷ�����д����Ч�ʡ�
		BufferedInputStream bis = new BufferedInputStream(fis);
		bis.read();
		bis.close();
		bos.close();// �ر�����ʱ��ֻ��Ҫ�ر������ĸ߼�������

		// ������
		/*
		 * �÷������ȡһ���ֽڲ�����ת��Ϊ��Ӧ�Ķ�������������Ƕ���ķ����л�
		 * 1.�ڷ����л�ʱ������������л��Ķ�������ඨ������а汾�Ƿ�һ�£�����һ�£�����׳��쳣�������л�ʧ�ܣ�
		 * 2.���汾��û�䣬�����ඨ�巢���˸ı䣬��ô���ü���ģʽ�� ��ԭ�������е����ԣ����ڻ��еľͻ�ԭ ��ԭ�������е����ԣ�����û�еľͺ���
		 * ��ԭ������û�е����ԣ������е���ʹ��Ĭ��ֵ
		 */
		Object o = new Object();
		ObjectOutputStream oos = new ObjectOutputStream(fos);// д
		oos.writeObject(o);// д����,�������л�
		ObjectInputStream ois = new ObjectInputStream(fis);// ��
		ois.readObject();// �����󣬶������л�
		// �ַ������ַ������Ǹ߼�������Ϊ�������б���������������ַ���ֻ������д�ַ�����
		// ����ָ������,�����ֽڣ����ַ�������
		InputStreamReader isr = new InputStreamReader(fis);
		InputStreamReader isr1 = new InputStreamReader(fis, "utf-8");
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		OutputStreamWriter osw1 = new OutputStreamWriter(fos, "utf-8");
		// �����ַ��������Զ�ȡһ�� readLine()
		BufferedWriter bw = new BufferedWriter(osw);// д
		BufferedReader br = new BufferedReader(isr);// ��
		br.readLine();// ��ȡһ��
		// ������ȡ��������start----------------
		BufferedReader br1 = new BufferedReader(
				new InputStreamReader(System.in));

		String line = null;
		boolean flag = true;
		while (/* true */flag) {
			line = br.readLine();
			System.out.println(line);
		}
		// ��ȡ��������end----------------

		// ��ӡ��
		/**
		 * �����ַ��� ���ƣ� ������д�ַ����� ������������Ϊ��λ��д�ַ���
		 * 
		 * �����ַ������������ BufferedReader,BufferedWriter
		 * 
		 * PrintWriter�ڲ�Ƕ����BufferedWriter
		 * ������Ҳ���л��幦�ܣ�PrintWriter���ṩ���Զ�����ˢ�¹��ܣ�����ͨ������ʹ���������������ַ������
		 * 
		 * PrintWriter�ṩ�˺ܶ๹�췽�����������Ǵ���ʵ��
		 * 
		 * @author tarena
		 *
		 */
		// 1
		PrintWriter pw = new PrintWriter("pw.txt", "GBK");// ��ָ������,�ļ���ʽ
		// 2
		FileOutputStream foss = new FileOutputStream("pw1.txt");
		/*
		 * ֱ�ӽ��ֽ������ת��ΪPrintWriter�Ļ��ᰴ��ϵͳĬ���ַ���д���ַ�����
		 */

		/*
		 * ��ϣ������ָ�����ַ���д����������Ҫ�Ƚ��ֽ���ת��ΪOutputStreamWriter��Ȼ��ָ���ַ�����
		 */
		OutputStreamWriter osww = new OutputStreamWriter(foss, "GBK");// ͬ���ﵽָ������ķ�ʽ
		PrintWriter pww = new PrintWriter(foss);
		// PrintWriter(OutputStream out,boolean autoFlush)
		// PrintWriter(Writer writer,boolean autoFlush)
		PrintWriter pww1 = new PrintWriter(pww, true);// true �Զ���ˢ��
		pw.println("�Ұ������찲��");// дһ��
		pw.flush();// �ֶ�ˢ��
	}

	// exception
	public static void testException() {
		/**
		 * finally�� ֻ�ܶ������쳣������Ƶ���� finally���еĴ�������try�е�����Ƿ��������ִ֤�С�
		 * ����֮ǰ������System.exit(0);ͨ�����ͷ���Դ����Ĳ����ͷ���finally��ȷ��ִ�С�
		 */
		// finalize
		/*
		 * �÷�������Object�ж���ķ�����������Ķ��󲻱��κ����ñ���ָ��ʱ�� �ᱻGC���գ��ڻ���ǰ�÷����ᱻ����
		 */
		/**
		 * throw�ؼ��� ���������׳�һ���쳣��ͨ������������ǻ��׳��쳣�������Լ����
		 * 1.�������������﷨Ҫ�󣬵��ǲ�����ҵ���߼�Ҫ��ʱ�����ǿ����׳��쳣���õ����߽��
		 * 2.��ǰ���������쳣�����ǲ�������������Ӧ�����쳣������������ʱ�����׳��쳣��
		 */
		try {
			int i = 0;
		} catch (Exception e) {
			System.out.println(e.getCause());// ���ؾ����������
		}
	}

	// thread ���߳�
	public static void testThread() {
		/**
		 * ��һ�֣��̳�Thread����дrun�������������� �����׶�:
		 * ����������Ҫ�̳�Thread����ǰ��Ͳ�����չ�������ˣ�����ʵ�ʵؿ�����Ŀʱ�Ǻ��鷳��һ����
		 * ���������߳��ڲ���д��run���������˵�ǰ�߳�Ҫִ�е�������͵��µ�ǰ�߳�ֻ��������£��������߳�����ǿ��Ϲ�ϵ���������߳����á�
		 */
		new MyThread1().start();// start�����߳�
		new MyThread2().start();// ��һ��
		/**
		 * �̵߳ĵڶ��ִ�����ʽ�� ʹ��Runnable�ӿ�,������ʵ���࣬�����߳�Ҫִ�е�����
		 */
		new Thread(new MyRunnable1()).start();
		final Thread t1 = new Thread(new MyRunnable2());
		t1.start();

		// �������ڲ�������������̵߳Ĵ�����ʽ
		new Thread() {
			@Override
			public void run() {// �̵߳�ִ���߼�
				System.out.println("����˭����");
			}
		}.start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("���ǲ�ˮ��ġ�");
				try {
					/**
					 * join���� ����ǰ�߳�����һ���߳��ϵȴ�����������״̬��ֱ��
					 * ��һ���߳�������ϣ���ǰ�̲߳Ż�������������ִ�У� ͨ������Э�������߳�ͬ������ʹ�á�
					 */
					t1.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		// Thread�ṩ��һ����̬����currentThread,����ȡ���и÷������̡߳�
		Thread t = Thread.currentThread();
		/**
		 * ������Ҫִ�г���ʱ�����Ȳ���ϵͳ������һ������������JVM,JVM�����������һ���߳���ִ��main������
		 * ���̽�������һ�������е�����ǰ̨�̶߳������ˣ����̾ͽ����ˡ� ���Բ�����˵main����ִ����Ͻ���һ��������
		 */
		// �鿴�̵߳�һЩ��Ϣ
		System.out.println("id:" + t.getId());
		System.out.println("name:" + t.getName());
		System.out.println("priority:" + t.getPriority());
		System.out.println("isAlive:" + t.isAlive());
		System.out.println("isDaemon:" + t.isDaemon());
		System.out.println("isInterrupted:" + t.isInterrupted());
		System.out.println("state:" + t.getState());
		/**
		 * �߳����ȼ� 1-10���ȼ� 10���1��С����Ĭ�ϡ� ���ȼ��ߵ��߳������ϻ�ȡCPUʱ��Ƭ�Ĵ����ࡣ
		 */
		t.setPriority(Thread.MIN_PRIORITY);// �����߳����ȼ�
		/**
		 * Thread�ľ�̬����sleep������ʹ�õ�ǰ�߳̽�������״ָ̬�����룬����ʱ�󣬸��̻߳��Զ��ص�Runnable״̬��
		 * �ȴ��ٴη���ʱ��Ƭ���С�
		 */
		// Thread.sleep(1000);��InterruptedException
		/**
		 * �ػ��̣߳��ֽк�̨�̣߳�ʹ������ǰ̨�߳�û�����𣬲�ͬ�����ڽ�����ʱ�򣺵�����������ǰ̨�̶߳�����ʱ
		 * ���ۺ�̨�߳��Ƿ������ж�Ҫǿ�ƽ����������ս������̡�
		 */
		t.setDaemon(true); // �����߳�Ϊ�ػ��߳�,Ҫ������֮ǰ����
		t.start();
		// -----------------------------------
		/**
		 * �̳߳� ��Ҫ����������⣺ 1.�����߳����� 2.�����߳�
		 */
		// ����һ���̶����ȵ��̳߳س����������߳�
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		// �����񽻸��̳߳�
		threadPool.execute(t);
		threadPool.shutdown();// �ر��̳߳�
		// synchronized
		/**
		 * Collections�ṩ�˺ܶྲ̬���� �������ǽ����еļ��ϻ�Mapת��Ϊ�̰߳�ȫ��
		 */
		List<String> list = new ArrayList<String>();
		list = Collections.synchronizedList(list);
		Set<String> set = new HashSet<String>(list);// HashSetҲ�����̰߳�ȫ��
		set = Collections.synchronizedSet(set);
		// HashMapҲ�����̰߳�ȫ��
		Map<String, Integer> map = new HashMap<String, Integer>();
		map = Collections.synchronizedMap(map);
		// -------------------------------
		/**
		 * ��һ��������synchronized���κ󣬸÷�����Ϊͬ����������˼�Ƕ���̲߳���ͬʱ���ʸ÷����ڲ��� public
		 * synchronized int getBean(){ if(beans==0){ ...}ͬ������
		 *
		 */
		/**
		 * ��Ч�ļ���ͬ����Χ�����ڱ�֤��ȫ��ǰ������߲���Ч�� ����ͬ���Ĵ��� .... ��Χ����ʹ�á�ͬ���顱
		 * synchronized(ͬ��������){ ��Ҫͬ���Ĵ���Ƭ�� }
		 * ͬ������������Ҫ�����Ķ������뱣֤����ͬ��Ч��������߳̿�����Ӧ������ͬ�еĶ��� ͨ��ѡȡʹ��this���ɡ�
		 */
		synchronized (Review.class) {
			// ������
		}

		/**
		 * wait��notify ��������������Object�϶���ģ�Ҳ����˵���еĶ��󶼾�������������
		 * ��һ���̵߳���һ�������wait�����󣬸��߳̽�������״̬��ֱ��������� ��notify���������ú󣬵�ǰ�̷߳��ɽ������
		 * �����ĺô�����Э����������ʱ���Ը������
		 */
		try {
			t.wait();// �ȴ�
		} catch (InterruptedException e) {
		}
		t.notify();// ����
	}

	// xml
	public static void testXml() {
		/*
		 * д��Xml�Ĳ��裺 ��������һ��Document���󣬱�ʾ�ĵ����� ������Document�����һ��Ԫ�أ���Ԫ�أ�
		 * �������Ԫ���а��ղ㼶�ṹ�齨����xml���� ����ͨ��XMLWriter��Documentд����ɹ���
		 * ���忴xml���µ�WriteXmlDemo��
		 */
		/*
		 * ����xml���̣� �����������ڽ���xml�ĵ���SAXReader
		 * ����ʹ��SAXReaderȥ����������zml�ĵ���������Doxument����
		 * ��һ�����Ǻ�ʱ����Դ�Ĳ��裬��Ϊ������ͻὫxml�ĵ�ȫ��������ϣ�����
		 * Document�������ʽ���أ����ڶ�����ڴ��У������൱�ڽ�����xml�ĵ�����Ƕ�����ڴ� ����ͨ��Document��ȡ��Ԫ�أ�����ǩ��
		 * ����ͨ����������ǩ�µ��ӱ�ǩ���ӱ�ǩ�µ��ӱ�ǩ����һ��һ������ս�xml�ĵ�����������ȫ����ȡ����
		 * ���忴xml���µ�ParseXmlDemo��
		 */
	}

	// jdbc
	public static void testJdbc() {
		/*
		 * JDBC:java���ݿ����� ʹ��JDBC�������ݿ�Ļ����������̣� 1������������ 2�������ݿ⽨������ 3��ִ��SQL���
		 * 4���������� 5���ر�����
		 */
		try {
			// 1������������
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2��ͨ��DriverManager���������ݿ������
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:///", "gg2014", "gg2014");
			// 3��ִ��SQL���
			Statement state = conn.createStatement();
			String sql = "SELECT ename,job,sal,deptno FROM  emp_pillow ";
			ResultSet rs = state.executeQuery(sql);
			state.addBatch(sql);// ����ִ��
			state.executeBatch();
			/*
			 * Statement��Բ�ͬ��SQL����ṩ�˲�ͬ�� ִ�з����� ResultSet executeQuery(String
			 * sql) �÷���ר������ִ��DQL��䣬���ص�ResultSet ��ʾ��ѯ�����Ľ����
			 * 
			 * int exceuteUpdate��String sql�� �÷���ר������ִ��DML��䣬���ص����ֱ�ʾ
			 * ִ�и�����Ӱ���˱��ж���������
			 * 
			 * boolean execute (String sql) �÷���������ʲô��䶼����ִ�У���������
			 * DQL��DML����ר�ŵķ���ִ���ˣ����÷��� ͨ������ִ��DDL��䡣
			 * 
			 * �÷����ķ���ֵ��ʾִ��SQL�����Ƿ���� ������������򷵻�true ��SQL��䱾���д���
			 * ִ�л��׳��쳣��SQLException
			 */
			// 4:�����������ȡ��ѯ���
			while (rs.next()) {
				// ��ȡԱ�������� �����������ַ������±��1����
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

	// ------------------------��ȡ�ķ���-----------------
	// ɾ��file
	public static void deleteFile(File file) {
		if (file.isDirectory()) {
			File[] subs = file.listFiles();
			for (File sub : subs) {
				deleteFile(sub);// �Լ������Լ����ݹ�
			}
		}
		file.delete();
	}
}

// �Զ���Ƚ�����
class MyCompare implements Comparator<String> {

	@Override
	public int compare(String s1,String s2) {
		return s1.length() - s2.length();
	}
	
}

// ��һ���߳���1
class MyThread1 extends Thread {
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("����˭����");
		}
	}
}

// ��һ���߳���2
class MyThread2 extends Thread {
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("���ǲ�ˮ��ģ�");
		}
	}
}

// �ڶ����߳���1
class MyRunnable1 implements Runnable {
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("����˭����");
		}
	}
}

// �ڶ����߳���1
class MyRunnable2 implements Runnable {
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("���ǲ�ˮ��ģ�");
		}
	}
}