package learn.basic.file;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileUtil {

	/**
	 * 向文件中写入内容
	 * @param path
	 * @param lines
	 * @throws IOException
	 */
	public static void writeFile(String path,Iterable<? extends CharSequence> lines) throws IOException{
		writeFile(path, lines,DEFAULT_ENCODING);
	}
	/**
	 * 向文件中写入内容
	 * @param path
	 * @param lines
	 * @throws IOException
	 */
	public static void writeFile(String path,Iterable<? extends CharSequence> lines,Charset charset) throws IOException{
		Path file = Paths.get(path);
		Files.write(file, lines, charset);
	}
	
	private static Charset DEFAULT_ENCODING = StandardCharsets.UTF_8;
	
	/**
	 * 读取文件内容
	 * @param path
	 * @param encoding
	 * @return String
	 * @throws IOException
	 */
	public static String readFileToString(String path,Charset encoding) throws IOException{
		 byte[] encoded = Files.readAllBytes(Paths.get(path));
		 return new String(encoded, encoding);
	}
	
	public static String readFileToString(String path) throws IOException{
		return readFileToString(path,DEFAULT_ENCODING);
	}
	
	/**
	 * 读取文件内容
	 * @param path
	 * @param encoding
	 * @return List<String>
	 * @throws IOException
	 */
	public static List<String> readFileToList(String path,Charset charset) throws IOException{
		List<String> lines = Files.readAllLines(Paths.get(path), charset);
		return lines;
	}
	
	public static List<String> readFileToList(String path) throws IOException{
		return readFileToList(path,DEFAULT_ENCODING);
	}
	
}
