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
	 * 遍历xml的开始标签
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		//开始解析book元素,知道具体属性名称及个数
		if(qName.equals("book")){
			book = new Book();
			index++;
			System.out.println("开始遍历第"+index+"本书");
			String id = attributes.getValue("id");
			System.out.println("book的属性值为："+id);
			book.setId(id);
		}
		//不知道个数及名称
		int length = attributes.getLength();
		for(int i = 0;i<length;++i){
			String name = attributes.getQName(i);
			System.out.println("属性名："+name+"...属性值:"+attributes.getValue(i));
		}
		if(!qName.equals("book")&&!qName.equals("bookstore")){
			System.out.print("节点名为："+qName);
		}
	}
	
	/**
	 * 遍历xml的结束标签
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		super.endElement(uri, localName, qName);
		if(qName.equals("book")){
			bookList.add(book);
			book = null;
			System.out.println("结束遍历第"+index+"本书");
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
	 * 用来标识开始
	 */
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("sax解析开始");
		bookList = new ArrayList<Book>();
	}
	
	/**
	 * 用来标识结束
	 */
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("sax解析结束");
	}
	
	/**
	 * 用于获取元素内容
	 */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		super.characters(ch, start, length);
		value = new String(ch,start,length);
		if(!value.trim().equals(""))
		System.out.println("......节点值为:"+value);
	}
	
}
