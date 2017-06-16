package learn.basic.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;


public class IOUtils {
	
	public static void main(String[] args) throws Exception {
		File file = new File("C:\\Users\\pillow\\Desktop\\excel拼接sql.txt");
		FileInputStream fis = new FileInputStream(file);
		String content = convertStreamToString(fis);
		System.out.println(content);
	}

	/*
	 * 使用Apache库 不重复造轮子。最靠谱的方法，还是用Apache commons IOUtils 这样简单几行代码就搞定了
	 * StringWriter writer = new StringWriter();
	 * IOUtils.copy(inputStream, writer, encoding);
	 * String theString = writer.toString();
	 * 或者 String theString = IOUtils.toString(inputStream, encoding)//这个方法其实封装了上面的方法，减少了一个参数
	 */
	/**
	 * 将流转换成String
	 * @param is
	 * @return
	 */
	@SuppressWarnings("resource")
	public static String convertStreamToString(InputStream is){
		Scanner scanner = new Scanner(is).useDelimiter("\\A");
		return scanner.hasNext()?scanner.next():"";
	}
}
