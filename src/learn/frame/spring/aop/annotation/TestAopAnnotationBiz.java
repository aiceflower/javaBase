package learn.frame.spring.aop.annotation;


public class TestAopAnnotationBiz {
	/**
	 * ���ԡ�����
	 */
	public void biz(){
		System.out.println("			...annotation here do some biz...");
		//ģ���쳣
		//throw new RuntimeException();
	}
	
	/**
	 * ���Դ������Ļ���
	 * @param str
	 * @param it
	 */
	public void bizParam(String str,int it){
		System.out.println("			...annotation here do some biz "+str+" "+it);
	}
}
