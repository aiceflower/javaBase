package learn.basic.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ClassUtil {
	public static void main(String [] args){
		printClassMessage(String.class);
	}
	
	/**
	 * ��ӡ���������Ϣ
	 * @param c
	 */
	public static void printClassMessage(Class c){
		//��ȡ�����Ϣ���Ȼ�ȡ������
		printClass(c);
		printMethods(c);
		printDeclaredMethods(c);
		printFields(c);
		printDeclaredFields(c);
		printConstructors(c);
		printDeclaredConstructor(c);
	}

	/**
	 * ��ӡ�����Ϣ
	 * @param c
	 */
	private static void printClass(Class c) {
		System.out.println("��ӡ����Ϣ--------start----------------------");
		//��ȡ������η�
		String modifier = Modifier.toString(c.getModifiers());
		System.out.print(modifier+" ");
		//��ȡ�������
		System.out.println(c.getName());
		System.out.println();
	}

	/**
	 * ��ӡ������Ϣ���������ࣨpublicȨ�ޣ�
	 * @param c
	 */
	private static void printMethods(Class c) {
		//��ȡ����
		System.out.println("����public���εķ���--------start----------------------");
		Method[] ms = c.getMethods();//��ȡ�������е�public�ĺ�������������̳ж�����
		for (Method method : ms) {
			//�õ����������η�
			String modifier = Modifier.toString(method.getModifiers());
			System.out.print(modifier+" ");
			//�õ������ķ���ֵ���͵�������
			Class returnType = method.getReturnType();
			System.out.print(returnType.getName()+" ");
			//�õ�����������
			String methodName = method.getName();
			System.out.print(methodName+"(");
			//��ȡ��������-->�õ����ǲ����б�����͵�������
			Class[] parameterTypes = method.getParameterTypes();
			for (int i = 0;i<parameterTypes.length;++i) {
				if(i==parameterTypes.length-1){
					System.out.print(parameterTypes[i].getName());
				}else{
					System.out.print(parameterTypes[i].getName()+",");
				}
			}
			System.out.println(")");
		}
		System.out.println("����public���εķ���--------end----------------------");
		System.out.println();
	}

	/**
	 * ��ӡ������Ϣ��Ϣ�������Լ�������(����Ȩ��)
	 * @param c
	 */
	private static void printDeclaredMethods(Class c) {
		System.out.println("�Լ������ķ���--------start----------------------");
		Method[] sms = c.getDeclaredMethods();//��ȡ�������и����Լ� �����ķ��������ʷ���Ȩ��
		for (Method method : sms) {
			//�õ������ķ���ֵ���͵�������
			Class returnType = method.getReturnType();
			System.out.print(returnType.getName()+" ");
			//�õ�����������
			String methodName = method.getName();
			System.out.print(methodName+"(");
			//��ȡ��������-->�õ����ǲ����б�����͵�������
			Class[] parameterTypes = method.getParameterTypes();
			for (int i = 0;i<parameterTypes.length;++i) {
				if(i==parameterTypes.length-1){
					System.out.print(parameterTypes[i].getName());
				}else{
					System.out.print(parameterTypes[i].getName()+",");
				}
			}
			System.out.println(")");
		}
		System.out.println("�Լ������ķ���--------end----------------------");
		System.out.println();
	}

	/**
	 * ��ӡ��Ա������Ϣ���������ࣨpublicȨ�ޣ�
	 * @param c
	 */
	private static void printFields(Class c) {
		/*
		 * ��Ա����Ҳ�Ƕ���java.lang.reflect.Field
		 * Field��װ�˹��ڳ�Ա��������Ϣ
		 * getField()��ȡ�������е�public�ĳ�Ա��������Ϣ
		 * getDeclaredField()��ȡ���Ǹ����Լ�������
		 */
		System.out.println("����public���εĳ�Ա����--------start----------------------");
		Field[] fields = c.getFields();
		for (Field field : fields) {
			//�õ���Ա���������͵�������
			Class type = field.getType();
			System.out.print(type+" ");
			System.out.println(field.getName());
		}
		System.out.println("����public���εĳ�Ա����--------end----------------------");
		System.out.println();
	}

	/**
	 * ��ӡ��Ա������Ϣ�������Լ�������(����Ȩ��)
	 * @param c
	 */
	private static void printDeclaredFields(Class c) {
		System.out.println("�Լ������ĳ�Ա����--------start----------------------");
		Field[] sfields = c.getDeclaredFields();
		for (Field field : sfields) {
			//�õ���Ա���������͵�������
			String modifier = Modifier.toString(field.getModifiers());
			System.out.print(modifier+" ");
			Class type = field.getType();
			System.out.print(type+" ");
			System.out.println(field.getName());
		}
		System.out.println("�Լ������ĳ�Ա����--------end----------------------");
		System.out.println();
	}

	/**
	 * ��ӡ���췽����Ϣ����������ģ�publicȨ�ޣ�
	 * @param c
	 */
	private static void printConstructors(Class c) {
		//���캯��
		Constructor[] constructors = c.getConstructors();
		System.out.println("����public���εĹ��췽��------------------start-------------------------------");
		for (Constructor constructor : constructors) {
			//��ȡ���η�
			String modifier = Modifier.toString(constructor.getModifiers());
			System.out.print(modifier+" ");
			//��ȡ���췽����
			String constructorName = constructor.getName();
			System.out.print(constructorName+"(");
			Class[] parameters = constructor.getParameterTypes();
			for(int i = 0;i<parameters.length;++i){
				System.out.print(parameters[i].getName());
			}
			System.out.println(")");
		}
		System.out.println("����public���εĹ��췽��------------------end-------------------------------");
		System.out.println();
	}
	
	public static void printDeclaredConstructor(Class c){
		//���캯��
		Constructor[] constructors = c.getDeclaredConstructors();
		System.out.println("�Լ������Ĺ��췽��------------------start-------------------------------");
		for (Constructor constructor : constructors) {
			//��ȡ���η�
			String modifier = Modifier.toString(constructor.getModifiers());
			System.out.print(modifier+" ");
			//��ȡ���췽����
			String constructorName = constructor.getName();
			System.out.print(constructorName+"(");
			Class[] parameters = constructor.getParameterTypes();
			for(int i = 0;i<parameters.length;++i){
				System.out.print(parameters[i].getName());
			}
			System.out.println(")");
		}
		System.out.println("�Լ������Ĺ��췽��------------------end-------------------------------");
		System.out.println();
	}
}
