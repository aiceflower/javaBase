package learn.practice;

public class OverrideTest {

	public void info(Object obj,int i){
		System.out.println("obj����:"+obj);
		System.out.println("int����:"+i);
	}
	
	public void info(Object obj[],double i){
		System.out.println("obj����:"+obj);
		System.out.println("int����:"+i);
	}
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		OverrideTest ot = new OverrideTest(); 
		//ot.info(null, 3);��仰�������޷�ȷ�����õ�����һ������
		//�����private�ķ�������븸���private����һģһ����������д	
	}
}
