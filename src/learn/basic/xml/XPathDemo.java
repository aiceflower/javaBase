package learn.basic.xml;

import java.io.FileInputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 使用xpath查找内容
 * @author tarena
 *
 */
public class XPathDemo {
	public static void main(String[] args) {
		try{
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new FileInputStream("myemp.xml"));
			/*
			 * 支持xpath检索内容的方法
			 * List selectNodes(String path)
			 * 该方法会使用给定的路径检索内容，并将检索回来的内容存入List集合后返回，
			 * 这里的集合不要使用泛型，因为检索回来的内容不一定都是标签(Element),也有可能
			 * 是属性(Attribute),这都要看xpath检索的内容确定
			 */
			@SuppressWarnings("unchecked")
			List<Element> list = doc.selectNodes("/list/emp[age>30]/salary");
			
			for(Element ele : list){
				System.out.println(ele.getText());
			}
			
			@SuppressWarnings("unchecked")
			List<Element> list1 = doc.selectNodes("/list/emp[gender='男' and age>18]/name");
			for(Element ele : list1){
				System.out.println(ele.getText());
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
