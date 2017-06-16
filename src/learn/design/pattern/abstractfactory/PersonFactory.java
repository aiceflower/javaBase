package learn.design.pattern.abstractfactory;

public interface PersonFactory {
	
	//男孩接口
	Boy getBoy();
	
	//女孩接口
	Girl getGirl();
}
