package learn.basic.enums;

import learn.basic.xml.Book;

public enum EnumSingleton {
	singleton;//枚举实现单例，只能有一个实例
	private Book book;
	
	EnumSingleton(){
		book = new Book();
	}
	
	public Book getBook(){
		return book;
	}
}
