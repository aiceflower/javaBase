package learn.basic.xml;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

/**
 * 使用DOM生成一个XML文档
 * 
 * @author tarena
 *
 */
public class WriteXmlDemo {
	public static void main(String[] args) {
		List<Emp> empList = new ArrayList<Emp>();
		empList.add(new Emp(1,"张三",22,"男",5000));
		empList.add(new Emp(2,"李四",33,"男",5600));
		empList.add(new Emp(3,"王五",44,"男",7800));
		empList.add(new Emp(4,"赵六",55,"男",9800));
		empList.add(new Emp(5,"钱七",66,"男",25000));
		
		/*
		 * 写出Xml的步骤：
		 * １：创建一个Document对象，表示文档内容
		 * ２：向Document中添加一个元素（根元素）
		 * ３：向根元素中按照层级结构组建整个xml内容
		 * ４：通过XMLWriter将Document写出完成工作
		 */
		try{
			//1 工厂方法
			Document document = DocumentHelper.createDocument();
			
			//2添加根标签
			/*
			 * 该方法是向当前文档中添加根标签，该方法不能调用两次！
			 */
			Element root = document.addElement("list");
			
			//3
			for(Emp emp : empList){
				/*
				 * Element提供了方法
				 * Element addElement(String name)
				 * 向当前标签下添加给定名字的子标签，并将该标签以Element实例的形式返回以便于继续操作。
				 */
				Element empEle = root.addElement("emp");
				
				//向emp标签中添加name标签
				Element nameEle = empEle.addElement("name");
				nameEle.addText(emp.getName());
				
				//向emp标签中添加age标签
				empEle.addElement("age").addText(emp.getAge()+"");
//				String.valueOf(emp.getAge());
				
				//添加gender
				empEle.addElement("gender").addText(emp.getGender());
				
				//添加salary
				empEle.addElement("salary").addText(String.valueOf(emp.getSalary()));
				
				/*
				 * 向元素中添加属性
				 * Element addAttribute(String name,String value)
				 * 
				 * 向当前元素中添加给定名字以及对应值的属性，返回值仍然是当前元素
				 * 这样做的好处在于可以连续追加多个属性
				 */
				empEle.addAttribute("id",emp.getId()+"");
			}
			//4
			XMLWriter writer = new XMLWriter();
			FileOutputStream fos = new FileOutputStream("myemp.xml");
			writer.setOutputStream(fos);
			
			writer.write(document);
			
			writer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
