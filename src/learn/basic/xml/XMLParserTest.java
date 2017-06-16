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
	 * DOM解析XML，全部加载后解析
	 */
	public static void dom2Xml(){
		//创建一个DocumentBuilderFactory对象
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			//创建一个DocumentBuilder对象
			DocumentBuilder db = dbf.newDocumentBuilder();
			//创建一个Document对象
			String path = System.getProperty("user.dir");
			Document document = db.parse(path+rt+"src"+rt+"learn"+rt+"basic"+rt+"xml"+rt+"books.xml");
			NodeList books = document.getElementsByTagName("book");
			System.out.println(books.getLength());
			//--------------------解析属性 start------------------------------
			//获取属性名及属性值，不知道有多少属性的情况
			for(int i = 0;i<books.getLength();++i){
				System.out.println("----------第"+(i+1)+"本书----------");
				Node item = books.item(i);
				//获取book的属性
				NamedNodeMap attributes = item.getAttributes();
				int length = attributes.getLength();
				for(int j= 0;j<length;++j){
					Node node = attributes.item(j);
					System.out.println("属性名"+node.getNodeName());
					System.out.println("属性值"+node.getNodeValue());
				}
			}
			//知道具体有多少个属性值
			for(int i = 0;i<books.getLength();++i){
				System.out.println("^^^^^^^^^^^^^第"+(i+1)+"本书^^^^^^^^^^^^^^^^^^");
				Element element = (Element)books.item(i);
				String attribute = element.getAttribute("id");
				System.out.println("id属性的属性值为"+attribute);
				//--------------------解析属性 end------------------------------
				//--------------------解析节点start------------------------------
				NodeList childNodes = element.getChildNodes();
				System.out.println("第"+(i+1)+"本书共有"+childNodes.getLength()+"个子节点");
				for(int k = 0;k<childNodes.getLength();++k){
					Node node = childNodes.item(k);
					//区分出text类型的node跟element类型的node
					if(node.getNodeType()==Node.ELEMENT_NODE){
						//注意这里常规所理解的节点值为该节点的第一个子节点的节点值<name>zhangsan</name>z
						//即zhangsan为name节点的子节点的节点值而非name节点的节点值
						System.out.println("节点名："+node.getNodeName()+"..节点值:"+node.getFirstChild().getNodeValue());
						//或者使用下面的方法,获取的是所有子节点的内容
						System.out.println("节点名："+node.getNodeName()+"..节点值:"+node.getTextContent());
						
					}
				}
				//--------------------解析节点 end------------------------------
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
	 * SAX解析xml，边加载边解析
	 */
	public static List<Book> sax2Xml(){
		//创建工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			//创建解析实例
			SAXParser parser = factory.newSAXParser();
			//创建handler
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
	 * jdom方式解析xml
	 * @throws IOException 
	 * @throws JDOMException 
	 * @throws URISyntaxException 
	 */
	public static void jdom2Xml() throws JDOMException, IOException, URISyntaxException{
		//创建一个SAXBuilder对象
		SAXBuilder saxBuilder = new SAXBuilder();
		String path = System.getProperty("user.dir")+rt+"src"+rt+"learn"+rt+"basic"+rt+"xml"+rt+"books.xml";
		//获取xml文件
		InputStreamReader in = new InputStreamReader(new FileInputStream("src/learn/basic/xml/books.xml"),"utf-8");
		//创建Document
		org.jdom.Document document = saxBuilder.build(in);
		//解析
		org.jdom.Element rootElement = document.getRootElement();
		List<org.jdom.Element> childrens = rootElement.getChildren();
		for(org.jdom.Element element:childrens){
			System.out.println("---------开始解析第"+(childrens.indexOf(element)+1)+"本书------------");
			//---------------------解析属性start----------------------------
			//知道属性名及个数
			String value = element.getAttributeValue("id");
			System.out.println("知道属性名及个数:属性名为id"+"..属性值不"+value);
			//不知道属性名及个数
			List<Attribute> attributes = element.getAttributes();
			for(Attribute attribute: attributes){
				//获取属性名
				String name = attribute.getName();
				//获取属性值
				String value2 = attribute.getValue();
				System.out.println("不知道属性名及个数:属性名为:"+name+"...属性值为:"+value2);
			}
			//---------------------解析属性end----------------------------
			//---------------------解析子节点start----------------------------
			List<org.jdom.Element> children = element.getChildren();
			for(org.jdom.Element e:children){
				String name = e.getName();
				String value2 = e.getValue();
				System.out.println("节点名:"+name+"...节点值为:"+value2);
			}
			//---------------------解析子节点end----------------------------
		}
	}
	
	/**
	 * 使用dom4j方式解析xml
	 */
	public static void dom4j2Xml(){
		SAXReader saxReader = new SAXReader();
		try {
			org.dom4j.Document document = saxReader.read(new File("src/learn/basic/xml/books.xml"));
			org.dom4j.Element rootElement = document.getRootElement();
			for(Iterator it = rootElement.elementIterator();it.hasNext();){
				org.dom4j.Element element = (org.dom4j.Element)it.next();
				//---------------------解析属性start----------------------------
				//不知道属性名及个数
				List<org.dom4j.Attribute> attributes = element.attributes();
				for(org.dom4j.Attribute attribute:attributes){
					String name = attribute.getName();
					String value = attribute.getValue();
					System.out.println("不知道属性名及个数:属性名为:"+name+"...属性值为:"+value);
				}
				//知道属性名及个数
				org.dom4j.Attribute attribute = element.attribute("id");
				System.out.println("知道属性名及个数:属性名为:"+attribute.getName()+"...属性值为:"+attribute.getValue());
				//---------------------解析属性end----------------------------
				//---------------------解析子节点start----------------------------
				for(Iterator iterator = element.elementIterator();iterator.hasNext();){
					org.dom4j.Element e = (org.dom4j.Element)iterator.next();
					System.out.println("节点名:"+e.getName()+"...节点值为-----:"+e.getText());
					System.out.println("节点名:"+e.getName()+"...节点值为:"+e.getStringValue());
				}
				
				//---------------------解析子节点end----------------------------
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
