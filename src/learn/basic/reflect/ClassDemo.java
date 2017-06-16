package learn.basic.reflect;

public class ClassDemo {
	public static void main(String args[]){
		//Foo的实例对象如何表示
		Foo foo = new Foo();//foo就表示出来了
		//对于Foo类本身也是一个对象，Class类的实例对象，如何表示呢？
		//任何一个类都是Class的实例对象，有三种表示方式
		//[1]表示一--->实际告诉我们，任何一个类，都有一个隐含的静态成员变量class
		Class c1 = Foo.class;
		//[2]表示二--->已经知道该类的对象通过getClass()方法
		Class c2 = foo.getClass();
		//官网解释 c1,c2表示了Foo类的类类型(class type)
		//[3]表示三，
		Class c3 = null;
		try {
			 c3= Class.forName("learn.basic.reflect.Foo");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(c1.getSimpleName());
		System.out.println(c2.getName());
		System.out.println(c1==c2?c2==c3?"c1等于c2等于c3":"c1等于c2不等于c3":"c1不等于c26");
		try {
			Foo f1 = (Foo)c1.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
class Foo{}
