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
		}*///���ϻᱨ����Ϊ�Ǿ�̬�����࣬���벻ͨ��
		//��̬����
		try {
			//��̬������
			//Class c = Class.forName(args[0]);
			//������Ķ���
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