package learn.basic.xml;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 使用DCM解析XML文件
 * @author tarena
 *
 */
public class ParseXmlDemo {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		/*
		 * 解析过程：
		 * １：创建用于解析xml文档的SAXReader
		 * ２：使用SAXReader去解析给定的zml文档，并生成Doxument对象，
		 * 　　这一步就是耗时耗资源的步骤，因为在这里就会将xml文档全部解析完毕，并以
		 *   Document对象的形式返回，由于对象的内存中，所有相当于将整个xml文档内容嵌入了内存
		 * ３：通过Document获取根元素（根标签）
		 * ４：通过遍历根标签下的子标签，子标签下的子标签这样一层一层的最终将xml文档中所有内容全部获取到。
		 * 
		 */
		try{
			//1
			SAXReader reader = new SAXReader();
			//2
			Document document = reader.read(new FileInputStream("../conf/myemp.xml"));
			/*
			 * 3:Document提供了一个方法：
			 * Element getRootElement()
			 * 该方法用来获取根元素（根标签）
			 * 
			 * Element是用来表示xml文档中的一个元素的（标签）
			 */
			Element root = document.getRootElement();
			System.out.println("获取了根标签："+root);
			/*
			 * Element提供了方法可以获取当前标签的相关信息
			 * 例如：
			 * String getName()
			 * 获取当前标签的名字
			 */
			System.out.println(root.getName());
			/*
			 * Element提供了可以获取其子标签的相关方法
			 * 
			 * Element element(String name)
			 * 获取当前标签下给定名字的子标签，若有多个重名的获取第一个
			 * 
			 * List elements()
			 * 获取当前标签下的所有子标签，并将它们放入一个List集合中返回
			 * 
			 * List elements(String name)
			 * 获取当前标签下所有给定名字的子标签。
			 */
			//获取List标签下的所有子标签
			List<Element> elements = root.elements();
			//该集合用来保存解析后的所有员工信息
			List<Emp> empList = new ArrayList();
			/*
			 * 遍历每一个emp标签
			 */
			for(Element empEle : elements){
				Element nameEle = empEle.element("name");
				/*
				 * Element提供了另一个方法，允许获取标签中的文本信息
				 * String getText()
				 * String getTextTrim()支空白
				 */
				String name = nameEle.getText();
				System.out.println(name);
				//读取age
				Element ageEle = empEle.element("age");
				int age = Integer.parseInt(ageEle.getTextTrim());
				System.out.println(age);
				//获取性别
				/*
				 * Element还提供了一个方法，可以快速的获取当前标签下一个给定名字的子标签中间的文本：
				 * String elementText(String name)
				 */
				String gender = empEle.elementTextTrim("gender");
				System.out.println(gender);
				//获取salary
				int salary = Integer.parseInt(empEle.elementText("salary"));
				System.out.println(salary);
				
				//获取id
				/*
				 * Element提供了一个方法：
				 * Attribute attribute(String name)
				 * 获取当前标签下给定名字的属性。
				 * 
				 * Attribute attribute(int index)
				 * 获取当前标签下给定下标对应的属性，下标从0开始
				 */
				Attribute attr = empEle.attribute("id");
				int id = Integer.parseInt(attr.getValue());
				//将解析出来的员工信息以Emp对象的形式保存
				Emp emp = new Emp(id,name,age,gender,salary);
				empList.add(emp);
			}
			System.out.println(empList);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
