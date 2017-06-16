package learn.basic.xml;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserHandler extends DefaultHandler {
	private List<Book> bookList = null;
	private int index = 0;
	private String value= null;
	private Book book = null;
	
	public List<Book> getBookList(){
		return bookList;
	}
	/**
	 * ����xml�Ŀ�ʼ��ǩ
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		//��ʼ����bookԪ��,֪�������������Ƽ�����
		if(qName.equals("book")){
			book = new Book();
			index++;
			System.out.println("��ʼ������"+index+"����");
			String id = attributes.getValue("id");
			System.out.println("book������ֵΪ��"+id);
			book.setId(id);
		}
		//��֪������������
		int length = attributes.getLength();
		for(int i = 0;i<length;++i){
			String name = attributes.getQName(i);
			System.out.println("��������"+name+"...����ֵ:"+attributes.getValue(i));
		}
		if(!qName.equals("book")&&!qName.equals("bookstore")){
			System.out.print("�ڵ���Ϊ��"+qName);
		}
	}
	
	/**
	 * ����xml�Ľ�����ǩ
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		super.endElement(uri, localName, qName);
		if(qName.equals("book")){
			bookList.add(book);
			book = null;
			System.out.println("����������"+index+"����");
		}
		if(qName.equals("name")){
			book.setName(value);
		}else if(qName.equals("author")){
			book.setAuthor(value);
		}else if(qName.equals("year")){
			book.setYear(value);
		}else if(qName.equals("price")){
			book.setPrice(Integer.parseInt(value));
		}else if(qName.equals("language")){
			book.setLanguage(value);
		}
	}
	/**
	 * ������ʶ��ʼ
	 */
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("sax������ʼ");
		bookList = new ArrayList<Book>();
	}
	
	/**
	 * ������ʶ����
	 */
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("sax��������");
	}
	
	/**
	 * ���ڻ�ȡԪ������
	 */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		super.characters(ch, start, length);
		value = new String(ch,start,length);
		if(!value.trim().equals(""))
		System.out.println("......�ڵ�ֵΪ:"+value);
	}
	
}
