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
		domWriteXml();//dom��ʽ����xml
		saxWriteXml();//sax��ʽ����xml
		jdomWriteXml();//jdom��ʽ����xml
		dom4jWriteXml();//dom4j��ʽ����xml
	}
	
	/**
	 * ͨ��dom��ʽ����xml
	 */
	public static void domWriteXml(){
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			//����һ��DocumentBuilder����
			try {
				DocumentBuilder db = dbf.newDocumentBuilder();
				Document newDocument = db.newDocument();
				//����ȥ��standalone="no"��Ϊno����dtd��schema��˵���ĵ�
				newDocument.setXmlStandalone(true);
				//��������Ӹ��ڵ�
				Element root = newDocument.createElement("bookStore");
				newDocument.appendChild(root);
				
				//����book�ӽڵ㲢����ӵ�bookStore�ڵ���
				Element book1 = newDocument.createElement("book");
				root.appendChild(book1);
				
				//��book1�������
				book1.setAttribute("id", "1");
				
				//��book1���name�ӽڵ�
				Element name = newDocument.createElement("name");
				name.setTextContent("�����֮��");
				book1.appendChild(name);
				//��book1���author�ӽڵ�
				Element author = newDocument.createElement("author");
				author.setTextContent("������");
				book1.appendChild(author);
				//��book1���year�ӽڵ�
				Element year = newDocument.createElement("year");
				year.setTextContent("2014");
				book1.appendChild(year);
				//��book1���price�ӽڵ�
				Element price = newDocument.createElement("price");
				price.setTextContent("89");
				book1.appendChild(price);
				
				//����book�ӽڵ㲢����ӵ�bookStore�ڵ���
				Element book2 = newDocument.createElement("book");
				root.appendChild(book2);
				
				//��book2�������
				book2.setAttribute("id", "2");
				
				//��book2���name�ӽڵ�
				Element name1 = newDocument.createElement("name");
				name1.setTextContent("��ͽ��ͯ��");
				book2.appendChild(name1);
				//��book1���author�ӽڵ�
				Element author1 = newDocument.createElement("author");
				author1.setTextContent("��ͽ��");
				book2.appendChild(author1);
				//��book1���year�ӽڵ�
				Element year1 = newDocument.createElement("year");
				year1.setTextContent("2004");
				book2.appendChild(year1);
				//��book1���price�ӽڵ�
				Element language = newDocument.createElement("language");
				language.setTextContent("English");
				book2.appendChild(language);
				
				//����Transformer����
				TransformerFactory tf = TransformerFactory.newInstance();
				//Ĭ���޻��У�����������Ϣ����������
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
	 * sax��ʽ����xml
	 */
	public static void saxWriteXml(){
		//List<Book> sax2Xml = XMLParserTest.sax2Xml();
		//1.����һ��SAXTransformerFactory
		SAXTransformerFactory stf = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
		TransformerHandler handler;
		try {
			//2����transformerHandler����
			handler = stf.newTransformerHandler();
			//3��ȡStransformer����
			Transformer transformer = handler.getTransformer();
			//4.1���ñ���
			transformer.setOutputProperty(OutputKeys.ENCODING,"utf-8");
			//4.2�����Ƿ���
			transformer.setOutputProperty(OutputKeys.INDENT,"yes");
			//5������Ҫ���ɵ��ļ�����
			File file = new File("book2.xml");
			if(!file.exists()){
				file.createNewFile();
			}
			//6����Result����
			Result result = new StreamResult(new FileOutputStream(file));
			//6.1ʹresult��handler����,��Ҫ����һ��֮ǰ�������ԣ�����룬���еȣ�������һ��֮�󣬿���startDocument();
			handler.setResult(result);
			//7xml���ݱ�д
			//���ĵ�
			handler.startDocument();
			//����һ�����ԣ������ظ�ʹ��
			AttributesImpl attr = new AttributesImpl();
			//bookStore
			handler.startElement("", "", "bookStore", attr);
			attr.clear();
			attr.addAttribute("", "", "id", "", "1");
			handler.startElement("", "", "book", attr);
			attr.clear();
			
			handler.startElement("", "", "name", attr);
			String name = "�����֮��";
			handler.characters(name.toCharArray(), 0, name.length());
			handler.endElement("", "", "name");
			
			handler.startElement("", "", "author", attr);
			String author = "������";
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
			//�ر��ĵ�
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
	 * jdom��ʽ����xml
	 */
	public static void jdomWriteXml(){
		//����һ�����ڵ�
		org.jdom.Element element = new org.jdom.Element("bookStore");
		//����һ��document����
		org.jdom.Document document = new org.jdom.Document(element);
		//����book
		org.jdom.Element book = new org.jdom.Element("book");
		//��book��������
		book.setAttribute("id","1");
		element.addContent(book);
		//����name����Ԫ��
		org.jdom.Element name = new org.jdom.Element("name");
		name.setText("xml�ĵ�");
		book.addContent(name);
		org.jdom.Element author = new org.jdom.Element("author");
		author.setText("�½�");
		book.addContent(author);
		org.jdom.Element year = new org.jdom.Element("year");
		year.setText("2016");
		book.addContent(year);
		org.jdom.Element price = new org.jdom.Element("price");
		price.setText("100");
		book.addContent(price);
		//���ø�ʽ
		Format format = Format.getPrettyFormat();
		format.setEncoding("GBK");
		//��������
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
	 * dom4j��ʽ����xml
	 */
	public static void dom4jWriteXml(){
		//1.����document
		org.dom4j.Document document = DocumentHelper.createDocument();
		//2.�������ڵ�
		org.dom4j.Element root = document.addElement("bookStore");
		//3.����ڵ����������
		org.dom4j.Element book = root.addElement("book");
		//�������
		book.addAttribute("id", "1");
		org.dom4j.Element name = book.addElement("name");
		name.setText("�����֮��");
		org.dom4j.Element author = book.addElement("author");
		author.setText("�½�");
		org.dom4j.Element year = book.addElement("year");
		year.setText("2014");
		org.dom4j.Element price= book.addElement("price");
		price.setText("89");
		
		//��������xml�ĸ�ʽ
		OutputFormat format = OutputFormat.createPrettyPrint();
		//���ñ���
		format.setEncoding("gbk");
		//4.����xml�ļ�
		XMLWriter xmlWriter;
		try {
			FileOutputStream fos = new FileOutputStream(new File("book3.xml"));
			xmlWriter = new XMLWriter(fos,format);
			//�����Ƿ�ת�壬Ĭ��Ϊtrue������ת��
			xmlWriter.setEscapeText(false);
			xmlWriter.write(document);
			xmlWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
