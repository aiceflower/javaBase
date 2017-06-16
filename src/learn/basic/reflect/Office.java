package learn.basic.reflect;
public class Office{
	public static void main(String[] args){
		/*if("Word".equals(args[0])){
			Word w = new Word();
			w.start();
		}
		if("Excel".equals(args[0])){
			Excel e = new Excel();
			e.start();
		}*///以上会报错，因为是静态加载类，编译不通过
		//动态加载
		try {
			//动态加载类
			//Class c = Class.forName(args[0]);
			//创建类的对象
			//OfficeAble oa = (OfficeAble) c.newInstance();
			
			Class v = void.class;
			System.out.println(v.getSimpleName());
			System.out.println(v.getName());
			System.out.println(v.getClassLoader());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}