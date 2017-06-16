package learn.basic.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.jdom.Attribute;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLParserTest {
	private static String rt = File.separator;
	private static SAXParserHandler handler;

	public static void main(String[] args){
		//dom2Xml();
		//sax2Xml();
		try {
//			jdom2Xml();
		} catch (Exception e) {
			e.printStackTrace();
		}
		dom4j2Xml();
	}
	
	/**
	 * DOM����XML��ȫ�����غ����
	 */
	public static void dom2Xml(){
		//����һ��DocumentBuilderFactory����
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			//����һ��DocumentBuilder����
			DocumentBuilder db = dbf.newDocumentBuilder();
			//����һ��Document����
			String path = System.getProperty("user.dir");
			Document document = db.parse(path+rt+"src"+rt+"learn"+rt+"basic"+rt+"xml"+rt+"books.xml");
			NodeList books = document.getElementsByTagName("book");
			System.out.println(books.getLength());
			//--------------------�������� start------------------------------
			//��ȡ������������ֵ����֪���ж������Ե����
			for(int i = 0;i<books.getLength();++i){
				System.out.println("----------��"+(i+1)+"����----------");
				Node item = books.item(i);
				//��ȡbook������
				NamedNodeMap attributes = item.getAttributes();
				int length = attributes.getLength();
				for(int j= 0;j<length;++j){
					Node node = attributes.item(j);
					System.out.println("������"+node.getNodeName());
					System.out.println("����ֵ"+node.getNodeValue());
				}
			}
			//֪�������ж��ٸ�����ֵ
			for(int i = 0;i<books.getLength();++i){
				System.out.println("^^^^^^^^^^^^^��"+(i+1)+"����^^^^^^^^^^^^^^^^^^");
				Element element = (Element)books.item(i);
				String attribute = element.getAttribute("id");
				System.out.println("id���Ե�����ֵΪ"+attribute);
				//--------------------�������� end------------------------------
				//--------------------�����ڵ�start------------------------------
				NodeList childNodes = element.getChildNodes();
				System.out.println("��"+(i+1)+"���鹲��"+childNodes.getLength()+"���ӽڵ�");
				for(int k = 0;k<childNodes.getLength();++k){
					Node node = childNodes.item(k);
					//���ֳ�text���͵�node��element���͵�node
					if(node.getNodeType()==Node.ELEMENT_NODE){
						//ע�����ﳣ�������Ľڵ�ֵΪ�ýڵ�ĵ�һ���ӽڵ�Ľڵ�ֵ<name>zhangsan</name>z
						//��zhangsanΪname�ڵ���ӽڵ�Ľڵ�ֵ����name�ڵ�Ľڵ�ֵ
						System.out.println("�ڵ�����"+node.getNodeName()+"..�ڵ�ֵ:"+node.getFirstChild().getNodeValue());
						//����ʹ������ķ���,��ȡ���������ӽڵ������
						System.out.println("�ڵ�����"+node.getNodeName()+"..�ڵ�ֵ:"+node.getTextContent());
						
					}
				}
				//--------------------�����ڵ� end------------------------------
			}
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * SAX����xml���߼��ر߽���
	 */
	public static List<Book> sax2Xml(){
		//��������
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			//��������ʵ��
			SAXParser parser = factory.newSAXParser();
			//����handler
			handler = new SAXParserHandler();
			String path = System.getProperty("user.dir")+rt+"src"+rt+"learn"+rt+"basic"+rt+"xml"+rt+"books.xml";
			parser.parse(path,handler);
			for(Book book:handler.getBookList()){
				System.out.println(book.getName());
				System.out.println(book.getYear());
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
		} catch (IOException e) {
			e.printStackTrace();
		}
		return handler.getBookList();
	}
	
	/**
	 * jdom��ʽ����xml
	 * @throws IOException 
	 * @throws JDOMException 
	 * @throws URISyntaxException 
	 */
	public static void jdom2Xml() throws JDOMException, IOException, URISyntaxException{
		//����һ��SAXBuilder����
		SAXBuilder saxBuilder = new SAXBuilder();
		String path = System.getProperty("user.dir")+rt+"src"+rt+"learn"+rt+"basic"+rt+"xml"+rt+"books.xml";
		//��ȡxml�ļ�
		InputStreamReader in = new InputStreamReader(new FileInputStream("src/learn/basic/xml/books.xml"),"utf-8");
		//����Document
		org.jdom.Document document = saxBuilder.build(in);
		//����
		org.jdom.Element rootElement = document.getRootElement();
		List<org.jdom.Element> childrens = rootElement.getChildren();
		for(org.jdom.Element element:childrens){
			System.out.println("---------��ʼ������"+(childrens.indexOf(element)+1)+"����------------");
			//---------------------��������start----------------------------
			//֪��������������
			String value = element.getAttributeValue("id");
			System.out.println("֪��������������:������Ϊid"+"..����ֵ��"+value);
			//��֪��������������
			List<Attribute> attributes = element.getAttributes();
			for(Attribute attribute: attributes){
				//��ȡ������
				String name = attribute.getName();
				//��ȡ����ֵ
				String value2 = attribute.getValue();
				System.out.println("��֪��������������:������Ϊ:"+name+"...����ֵΪ:"+value2);
			}
			//---------------------��������end----------------------------
			//---------------------�����ӽڵ�start----------------------------
			List<org.jdom.Element> children = element.getChildren();
			for(org.jdom.Element e:children){
				String name = e.getName();
				String value2 = e.getValue();
				System.out.println("�ڵ���:"+name+"...�ڵ�ֵΪ:"+value2);
			}
			//---------------------�����ӽڵ�end----------------------------
		}
	}
	
	/**
	 * ʹ��dom4j��ʽ����xml
	 */
	public static void dom4j2Xml(){
		SAXReader saxReader = new SAXReader();
		try {
			org.dom4j.Document document = saxReader.read(new File("src/learn/basic/xml/books.xml"));
			org.dom4j.Element rootElement = document.getRootElement();
			for(Iterator it = rootElement.elementIterator();it.hasNext();){
				org.dom4j.Element element = (org.dom4j.Element)it.next();
				//---------------------��������start----------------------------
				//��֪��������������
				List<org.dom4j.Attribute> attributes = element.attributes();
				for(org.dom4j.Attribute attribute:attributes){
					String name = attribute.getName();
					String value = attribute.getValue();
					System.out.println("��֪��������������:������Ϊ:"+name+"...����ֵΪ:"+value);
				}
				//֪��������������
				org.dom4j.Attribute attribute = element.attribute("id");
				System.out.println("֪��������������:������Ϊ:"+attribute.getName()+"...����ֵΪ:"+attribute.getValue());
				//---------------------��������end----------------------------
				//---------------------�����ӽڵ�start----------------------------
				for(Iterator iterator = element.elementIterator();iterator.hasNext();){
					org.dom4j.Element e = (org.dom4j.Element)iterator.next();
					System.out.println("�ڵ���:"+e.getName()+"...�ڵ�ֵΪ-----:"+e.getText());
					System.out.println("�ڵ���:"+e.getName()+"...�ڵ�ֵΪ:"+e.getStringValue());
				}
				
				//---------------------�����ӽڵ�end----------------------------
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
