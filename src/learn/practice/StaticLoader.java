package learn.practice;

public class StaticLoader {

	/*
	 * ����ʹ�����ֶ�
	 */
	public static void main(String[] args) {
		//1.ͨ���������ø���ľ�̬�ֶΣ����ᵼ�������ʼ��
		System.out.println(SubClass.value);
		//���ھ�̬�ֶΣ�ֻ��ֱ�Ӷ�������ֶε���Żᱻ��ʼ�������ͨ�������������ø����ж���ľ�
		//̬�ֶΣ�ֻ�ᴥ������ĳ�ʼ�������ᴥ������ĳ�ʼ����
		//2.ͨ�����鶨���������࣬���ᴥ������ĳ�ʼ��
		SuperClass [] scs = new SuperClass[5];
		System.out.println(scs);
		//��δ������津��������һ����ĳ�ʼ������һ����������Զ����ɵġ�ֱ
		//�Ӽ̳���java.lang.Object�����࣬�����������ֽ���ָ��newarray������
		//3�����ڱ���׶λ���������ĳ������У������ϲ�û��ֱ�����õ����峣�����࣬��˲��ᴥ�����峣������ĳ�ʼ����
		System.out.println(ConstClass.HELLOWORLD);//������ǳ���(��final)����ʼ����
		//�ڱ���׶�ͨ�����������Ż����Ѿ����˳���
		//��ֵ��hello  world���洢����NotInitialization��ĳ������У�
	}
}
class SuperClass{
	static{
		System.out.println("SuperClass init");
	}
	
	public static int value = 3;
}
class SubClass extends SuperClass{
	static{
		System.out.println("SubClass init");
	}
}
class ConstClass{
	static{
		System.out.println("ConstClass init��");
	}
	public static final String HELLOWORLD="hello world";
}
