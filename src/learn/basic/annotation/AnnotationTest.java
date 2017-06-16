package learn.basic.annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 列举注解可以使用的属性类型
 * 
 * @author pillow
 *
 */
@MyAnno1(
		a=100,
		b="b",
		c=MyEnum.A,
		d=String.class,
 e = @MyAnno2(value = 100),// 如果注解只有一个属性需要赋值且为value可以省略，@MyAnn2(100)
 f = {
		100, 200 })
// 数组类型赋值如果只有一个可以活力大括号，f = 100
public class AnnotationTest {
	
}

@interface MyAnno1 {
	/*
	 * 注解可以使用的属性类型 8种基本类型，String，Enum，class， 注解类型 以上类型的一维数组类型
	 */
	int a();

	String b();

	MyEnum c();

	Class d();

	MyAnno2 e();

	int[] f();
}

enum MyEnum {
	A,B,C
}

@interface MyAnno2 {
	int value();

	String bb() default "";
}

/**
 * 注解的作用目标
 * 
 * @author pillow
 *
 */
@Target(ElementType.METHOD)
// 只有runtime类型的可以用反射得到
// 这里写这样为什么为报错，1，值为value可以省略，数组元素只有一个，可以省略大括号
@interface MyAnno3 {

}
