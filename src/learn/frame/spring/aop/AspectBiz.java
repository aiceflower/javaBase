package learn.frame.spring.aop;

public class AspectBiz {

	/**
	 * ���ԡ�����
	 */
	public void biz(){
		System.out.println("			...here do some biz...");
		//ģ���쳣
		throw new RuntimeException();
	}
	
	/**
	 * ���Դ������Ļ���
	 * @param str
	 * @param it
	 */
	public void bizParam(String str,int it){
		System.out.println("			...here do some biz "+str+" "+it);
	}
}
