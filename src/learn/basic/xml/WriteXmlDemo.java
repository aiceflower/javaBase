package learn.basic.xml;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

/**
 * ʹ��DOM����һ��XML�ĵ�
 * 
 * @author tarena
 *
 */
public class WriteXmlDemo {
	public static void main(String[] args) {
		List<Emp> empList = new ArrayList<Emp>();
		empList.add(new Emp(1,"����",22,"��",5000));
		empList.add(new Emp(2,"����",33,"��",5600));
		empList.add(new Emp(3,"����",44,"��",7800));
		empList.add(new Emp(4,"����",55,"��",9800));
		empList.add(new Emp(5,"Ǯ��",66,"��",25000));
		
		/*
		 * д��Xml�Ĳ��裺
		 * ��������һ��Document���󣬱�ʾ�ĵ�����
		 * ������Document�����һ��Ԫ�أ���Ԫ�أ�
		 * �������Ԫ���а��ղ㼶�ṹ�齨����xml����
		 * ����ͨ��XMLWriter��Documentд����ɹ���
		 */
		try{
			//1 ��������
			Document document = DocumentHelper.createDocument();
			
			//2��Ӹ���ǩ
			/*
			 * �÷�������ǰ�ĵ�����Ӹ���ǩ���÷������ܵ������Σ�
			 */
			Element root = document.addElement("list");
			
			//3
			for(Emp emp : empList){
				/*
				 * Element�ṩ�˷���
				 * Element addElement(String name)
				 * ��ǰ��ǩ����Ӹ������ֵ��ӱ�ǩ�������ñ�ǩ��Elementʵ������ʽ�����Ա��ڼ���������
				 */
				Element empEle = root.addElement("emp");
				
				//��emp��ǩ�����name��ǩ
				Element nameEle = empEle.addElement("name");
				nameEle.addText(emp.getName());
				
				//��emp��ǩ�����age��ǩ
				empEle.addElement("age").addText(emp.getAge()+"");
//				String.valueOf(emp.getAge());
				
				//���gender
				empEle.addElement("gender").addText(emp.getGender());
				
				//���salary
				empEle.addElement("salary").addText(String.valueOf(emp.getSalary()));
				
				/*
				 * ��Ԫ�����������
				 * Element addAttribute(String name,String value)
				 * 
				 * ��ǰԪ������Ӹ��������Լ���Ӧֵ�����ԣ�����ֵ��Ȼ�ǵ�ǰԪ��
				 * �������ĺô����ڿ�������׷�Ӷ������
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
