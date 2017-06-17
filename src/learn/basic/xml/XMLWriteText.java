package learn.basic.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

public class XMLWriteText {

	public static void main(String[] args) {
		domWriteXml();//dom方式生成xml
		saxWriteXml();//sax方式生成xml
		jdomWriteXml();//jdom方式生成xml
		dom4jWriteXml();//dom4j方式生成xml
	}
	
	/**
	 * 通过dom方式生成xml
	 */
	public static void domWriteXml(){
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			//创建一个DocumentBuilder对象
			try {
				DocumentBuilder db = dbf.newDocumentBuilder();
				Document newDocument = db.newDocument();
				//设置去掉standalone="no"，为no则有dtd跟schema的说明文档
				newDocument.setXmlStandalone(true);
				//创建并添加根节点
				Element root = newDocument.createElement("bookStore");
				newDocument.appendChild(root);
				
				//创建book子节点并添加子到bookStore节点中
				Element book1 = newDocument.createElement("book");
				root.appendChild(book1);
				
				//给book1添加属性
				book1.setAttribute("id", "1");
				
				//给book1添加name子节点
				Element name = newDocument.createElement("name");
				name.setTextContent("冰与火之歌");
				book1.appendChild(name);
				//给book1添加author子节点
				Element author = newDocument.createElement("author");
				author.setTextContent("乔治马丁");
				book1.appendChild(author);
				//给book1添加year子节点
				Element year = newDocument.createElement("year");
				year.setTextContent("2014");
				book1.appendChild(year);
				//给book1添加price子节点
				Element price = newDocument.createElement("price");
				price.setTextContent("89");
				book1.appendChild(price);
				
				//创建book子节点并添加子到bookStore节点中
				Element book2 = newDocument.createElement("book");
				root.appendChild(book2);
				
				//给book2添加属性
				book2.setAttribute("id", "2");
				
				//给book2添加name子节点
				Element name1 = newDocument.createElement("name");
				name1.setTextContent("安徒生童话");
				book2.appendChild(name1);
				//给book1添加author子节点
				Element author1 = newDocument.createElement("author");
				author1.setTextContent("安徒生");
				book2.appendChild(author1);
				//给book1添加year子节点
				Element year1 = newDocument.createElement("year");
				year1.setTextContent("2004");
				book2.appendChild(year1);
				//给book1添加price子节点
				Element language = newDocument.createElement("language");
				language.setTextContent("English");
				book2.appendChild(language);
				
				//创建Transformer对象
				TransformerFactory tf = TransformerFactory.newInstance();
				//默认无换行，设置如下信息以用来换行
				Transformer transformer = tf.newTransformer();
				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				transformer.transform(new DOMSource(newDocument), new StreamResult(new File("books1.xml")));
				
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (TransformerConfigurationException e) {
				e.printStackTrace();
			} catch (TransformerException e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * sax方式生成xml
	 */
	public static void saxWriteXml(){
		//List<Book> sax2Xml = XMLParserTest.sax2Xml();
		//1.创建一个SAXTransformerFactory
		SAXTransformerFactory stf = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
		TransformerHandler handler;
		try {
			//2创建transformerHandler对象
			handler = stf.newTransformerHandler();
			//3获取Stransformer对象
			Transformer transformer = handler.getTransformer();
			//4.1设置编码
			transformer.setOutputProperty(OutputKeys.ENCODING,"utf-8");
			//4.2设置是否换行
			transformer.setOutputProperty(OutputKeys.INDENT,"yes");
			//5创建需要生成的文件对象
			File file = new File("book2.xml");
			if(!file.exists()){
				file.createNewFile();
			}
			//6创建Result对象
			Result result = new StreamResult(new FileOutputStream(file));
			//6.1使result与handler关联,需要在这一步之前设置属性，如编码，换行等，而在这一步之后，开启startDocument();
			handler.setResult(result);
			//7xml内容编写
			//打开文档
			handler.startDocument();
			//创建一个属性，可以重复使用
			AttributesImpl attr = new AttributesImpl();
			//bookStore
			handler.startElement("", "", "bookStore", attr);
			attr.clear();
			attr.addAttribute("", "", "id", "", "1");
			handler.startElement("", "", "book", attr);
			attr.clear();
			
			handler.startElement("", "", "name", attr);
			String name = "冰与火之歌";
			handler.characters(name.toCharArray(), 0, name.length());
			handler.endElement("", "", "name");
			
			handler.startElement("", "", "author", attr);
			String author = "乔治马丁";
			handler.characters(author.toCharArray(), 0, author.length());
			handler.endElement("", "", "author");
			
			handler.startElement("", "", "year", attr);
			String year = "2014";
			handler.characters(year.toCharArray(), 0, year.length());
			handler.endElement("", "", "year");
			
			handler.startElement("", "", "price", attr);
			String price = "89";
			handler.characters(price.toCharArray(), 0, price.length());
			handler.endElement("", "", "price");
			
			handler.endElement("", "", "book");
			handler.endElement("", "", "bookStore");
			//关闭文档
			handler.endDocument();
			
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * jdom方式生成xml
	 */
	public static void jdomWriteXml(){
		//生成一个根节点
		org.jdom.Element element = new org.jdom.Element("bookStore");
		//生成一个document对象
		org.jdom.Document document = new org.jdom.Document(element);
		//生成book
		org.jdom.Element book = new org.jdom.Element("book");
		//给book设置属性
		book.setAttribute("id","1");
		element.addContent(book);
		//生成name等子元素
		org.jdom.Element name = new org.jdom.Element("name");
		name.setText("xml文档");
		book.addContent(name);
		org.jdom.Element author = new org.jdom.Element("author");
		author.setText("郝金福");
		book.addContent(author);
		org.jdom.Element year = new org.jdom.Element("year");
		year.setText("2016");
		book.addContent(year);
		org.jdom.Element price = new org.jdom.Element("price");
		price.setText("100");
		book.addContent(price);
		//设置格式
		Format format = Format.getPrettyFormat();
		format.setEncoding("GBK");
		//设置缩进
		format.setIndent("	");
		XMLOutputter outputer = new XMLOutputter(format);
		try {
			FileOutputStream fos = new FileOutputStream(new File("book4.xml"));
			outputer.output(document, fos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * dom4j方式生成xml
	 */
	public static void dom4jWriteXml(){
		//1.创建document
		org.dom4j.Document document = DocumentHelper.createDocument();
		//2.创建根节点
		org.dom4j.Element root = document.addElement("bookStore");
		//3.向根节点中添加内容
		org.dom4j.Element book = root.addElement("book");
		//添加属性
		book.addAttribute("id", "1");
		org.dom4j.Element name = book.addElement("name");
		name.setText("冰与火之歌");
		org.dom4j.Element author = book.addElement("author");
		author.setText("郝金福");
		org.dom4j.Element year = book.addElement("year");
		year.setText("2014");
		org.dom4j.Element price= book.addElement("price");
		price.setText("89");
		
		//设置生成xml的格式
		OutputFormat format = OutputFormat.createPrettyPrint();
		//设置编码
		format.setEncoding("gbk");
		//4.生成xml文件
		XMLWriter xmlWriter;
		try {
			FileOutputStream fos = new FileOutputStream(new File("book3.xml"));
			xmlWriter = new XMLWriter(fos,format);
			//设置是否转义，默认为true，代表转义
			xmlWriter.setEscapeText(false);
			xmlWriter.write(document);
			xmlWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
