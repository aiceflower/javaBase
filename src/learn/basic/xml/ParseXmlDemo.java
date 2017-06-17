package learn.basic.xml;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * ʹ��DCM����XML�ļ�
 * @author tarena
 *
 */
public class ParseXmlDemo {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		/*
		 * �������̣�
		 * �����������ڽ���xml�ĵ���SAXReader
		 * ����ʹ��SAXReaderȥ����������zml�ĵ���������Doxument����
		 * ������һ�����Ǻ�ʱ����Դ�Ĳ��裬��Ϊ������ͻὫxml�ĵ�ȫ��������ϣ�����
		 *   Document�������ʽ���أ����ڶ�����ڴ��У������൱�ڽ�����xml�ĵ�����Ƕ�����ڴ�
		 * ����ͨ��Document��ȡ��Ԫ�أ�����ǩ��
		 * ����ͨ����������ǩ�µ��ӱ�ǩ���ӱ�ǩ�µ��ӱ�ǩ����һ��һ������ս�xml�ĵ�����������ȫ����ȡ����
		 * 
		 */
		try{
			//1
			SAXReader reader = new SAXReader();
			//2
			Document document = reader.read(new FileInputStream("../conf/myemp.xml"));
			/*
			 * 3:Document�ṩ��һ��������
			 * Element getRootElement()
			 * �÷���������ȡ��Ԫ�أ�����ǩ��
			 * 
			 * Element��������ʾxml�ĵ��е�һ��Ԫ�صģ���ǩ��
			 */
			Element root = document.getRootElement();
			System.out.println("��ȡ�˸���ǩ��"+root);
			/*
			 * Element�ṩ�˷������Ի�ȡ��ǰ��ǩ�������Ϣ
			 * ���磺
			 * String getName()
			 * ��ȡ��ǰ��ǩ������
			 */
			System.out.println(root.getName());
			/*
			 * Element�ṩ�˿��Ի�ȡ���ӱ�ǩ����ط���
			 * 
			 * Element element(String name)
			 * ��ȡ��ǰ��ǩ�¸������ֵ��ӱ�ǩ�����ж�������Ļ�ȡ��һ��
			 * 
			 * List elements()
			 * ��ȡ��ǰ��ǩ�µ������ӱ�ǩ���������Ƿ���һ��List�����з���
			 * 
			 * List elements(String name)
			 * ��ȡ��ǰ��ǩ�����и������ֵ��ӱ�ǩ��
			 */
			//��ȡList��ǩ�µ������ӱ�ǩ
			List<Element> elements = root.elements();
			//�ü���������������������Ա����Ϣ
			List<Emp> empList = new ArrayList();
			/*
			 * ����ÿһ��emp��ǩ
			 */
			for(Element empEle : elements){
				Element nameEle = empEle.element("name");
				/*
				 * Element�ṩ����һ�������������ȡ��ǩ�е��ı���Ϣ
				 * String getText()
				 * String getTextTrim()֧�հ�
				 */
				String name = nameEle.getText();
				System.out.println(name);
				//��ȡage
				Element ageEle = empEle.element("age");
				int age = Integer.parseInt(ageEle.getTextTrim());
				System.out.println(age);
				//��ȡ�Ա�
				/*
				 * Element���ṩ��һ�����������Կ��ٵĻ�ȡ��ǰ��ǩ��һ���������ֵ��ӱ�ǩ�м���ı���
				 * String elementText(String name)
				 */
				String gender = empEle.elementTextTrim("gender");
				System.out.println(gender);
				//��ȡsalary
				int salary = Integer.parseInt(empEle.elementText("salary"));
				System.out.println(salary);
				
				//��ȡid
				/*
				 * Element�ṩ��һ��������
				 * Attribute attribute(String name)
				 * ��ȡ��ǰ��ǩ�¸������ֵ����ԡ�
				 * 
				 * Attribute attribute(int index)
				 * ��ȡ��ǰ��ǩ�¸����±��Ӧ�����ԣ��±��0��ʼ
				 */
				Attribute attr = empEle.attribute("id");
				int id = Integer.parseInt(attr.getValue());
				//������������Ա����Ϣ��Emp�������ʽ����
				Emp emp = new Emp(id,name,age,gender,salary);
				empList.add(emp);
			}
			System.out.println(empList);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
