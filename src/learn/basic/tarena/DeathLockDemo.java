package learn.basic.tarena;

/**
 * �����������̶߳��ڵȴ��Է��ͷ��������ڵġ����֡�״̬
 * @author tarena
 *
 */
public class DeathLockDemo {
	private Object k1 = new Object();
	private Object k2 = new Object();
	public void a(){
		/*
		 * t1�ȵ��õ�a���������ԻὫk1����
		 * Ȼ��t2�߳��ٵ���b���������Ҫ����a����
		 * ����t2�̻߳�����������������ȴ�t1��k1�����ͷš�
		 * ��������t2�߳���ִ����b���������ԻὫ
		 * k2������ֱ�����ｫa����ִ����ϲŻ��ͷ�k2����
		 */
		synchronized(k1){
			Thread t = Thread.currentThread();
			System.out.println(t+"���ڵ���a����");
			try{
				Thread.sleep(5000);
			}catch(InterruptedException e){
			}
			b();  //t1�߳�ֻ��ִ����b������Ż��ͷ�k1
		}
	}
	
	public void b(){
		synchronized(k2){
			Thread t = Thread.currentThread();
			System.out.println(t+"���ڵ���b����");
			try{
				Thread.sleep(5000);
			}catch(InterruptedException e){
			}
			a();  //t2�߳�ֻ��ִ����a������Ż��ͷ�k2
		}
	}
	
	public static void main(String[] args) {
		final DeathLockDemo did = new DeathLockDemo();
		Thread t1 = new Thread(){
			public void run(){
				did.a();
				System.out.println(getName()+"ִ����ϣ�");
			}
		};
		
		Thread t2 = new Thread(){
			public void run(){
				did.b();
				System.out.println(getName()+"ִ����ϣ�");
			}
		};
		t1.start();
		t2.start();
	}
}
