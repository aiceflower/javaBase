package learn.practice;

public class Init {

	static{
		/*
		 * ������ᱣ֤һ����ģ�clinit�����������ڶ��̻߳����б���ȷ�ؼ�����ͬ���������
			���߳�ͬʱȥ��ʼ��һ���࣬��ôֻ����һ���߳�ȥִ�������ģ�clinit����������������
			�̶߳���Ҫ�����ȴ���ֱ����߳�ִ�У�clinit������������ϡ�
		 */
		if(true){//�����������ж�����Ĵ����޷�ͨ������
			System.out.println(Thread.currentThread()+"init DeadLoopClass");
			while(true){
			
			}
		}
		i = 0;
		//System.out.println(i);���뱨��
		//�Ƿ���ǰ���ñ���
		/*�������ռ���˳�����������Դ�ļ��г��ֵ�˳������
		���ģ���̬������ֻ�ܷ��ʵ������ھ�̬����֮ǰ�ı�������������֮��ı�������ǰ
		��ľ�̬������Ը�ֵ�����ǲ��ܷ���
		*/
	}
	{
		b = "hello";
		//System.out.println(b);ͬ��
	}
	private String b = "a";
	public static int i = 1;
	public static void main(String[] args) {
		System.out.println(i);
		Init in = new Init();
		System.out.println(in.b);
	}
}
