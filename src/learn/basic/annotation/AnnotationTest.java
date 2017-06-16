package learn.basic.annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * �о�ע�����ʹ�õ���������
 * 
 * @author pillow
 *
 */
@MyAnno1(
		a=100,
		b="b",
		c=MyEnum.A,
		d=String.class,
 e = @MyAnno2(value = 100),// ���ע��ֻ��һ��������Ҫ��ֵ��Ϊvalue����ʡ�ԣ�@MyAnn2(100)
 f = {
		100, 200 })
// �������͸�ֵ���ֻ��һ�����Ի��������ţ�f = 100
public class AnnotationTest {
	
}

@interface MyAnno1 {
	/*
	 * ע�����ʹ�õ��������� 8�ֻ������ͣ�String��Enum��class�� ע������ �������͵�һά��������
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
 * ע�������Ŀ��
 * 
 * @author pillow
 *
 */
@Target(ElementType.METHOD)
// ֻ��runtime���͵Ŀ����÷���õ�
// ����д����ΪʲôΪ����1��ֵΪvalue����ʡ�ԣ�����Ԫ��ֻ��һ��������ʡ�Դ�����
@interface MyAnno3 {

}
