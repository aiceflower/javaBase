package learn.basic.enums;

import learn.basic.xml.Book;

public enum EnumSingleton {
	singleton;//ö��ʵ�ֵ�����ֻ����һ��ʵ��
	private Book book;
	
	EnumSingleton(){
		book = new Book();
	}
	
	public Book getBook(){
		return book;
	}
}
