package learn.basic.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;


public class IOUtils {
	
	public static void main(String[] args) throws Exception {
		File file = new File("C:\\Users\\pillow\\Desktop\\excelƴ��sql.txt");
		FileInputStream fis = new FileInputStream(file);
		String content = convertStreamToString(fis);
		System.out.println(content);
	}

	/*
	 * ʹ��Apache�� ���ظ������ӡ���׵ķ�����������Apache commons IOUtils �����򵥼��д���͸㶨��
	 * StringWriter writer = new StringWriter();
	 * IOUtils.copy(inputStream, writer, encoding);
	 * String theString = writer.toString();
	 * ���� String theString = IOUtils.toString(inputStream, encoding)//���������ʵ��װ������ķ�����������һ������
	 */
	/**
	 * ����ת����String
	 * @param is
	 * @return
	 */
	@SuppressWarnings("resource")
	public static String convertStreamToString(InputStream is){
		Scanner scanner = new Scanner(is).useDelimiter("\\A");
		return scanner.hasNext()?scanner.next():"";
	}
}
