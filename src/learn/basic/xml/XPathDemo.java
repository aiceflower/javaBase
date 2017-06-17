package learn.basic.xml;

import java.io.FileInputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * ʹ��xpath��������
 * @author tarena
 *
 */
public class XPathDemo {
	public static void main(String[] args) {
		try{
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new FileInputStream("myemp.xml"));
			/*
			 * ֧��xpath�������ݵķ���
			 * List selectNodes(String path)
			 * �÷�����ʹ�ø�����·���������ݣ������������������ݴ���List���Ϻ󷵻أ�
			 * ����ļ��ϲ�Ҫʹ�÷��ͣ���Ϊ�������������ݲ�һ�����Ǳ�ǩ(Element),Ҳ�п���
			 * ������(Attribute),�ⶼҪ��xpath����������ȷ��
			 */
			@SuppressWarnings("unchecked")
			List<Element> list = doc.selectNodes("/list/emp[age>30]/salary");
			
			for(Element ele : list){
				System.out.println(ele.getText());
			}
			
			@SuppressWarnings("unchecked")
			List<Element> list1 = doc.selectNodes("/list/emp[gender='��' and age>18]/name");
			for(Element ele : list1){
				System.out.println(ele.getText());
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
