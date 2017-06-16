package learn.basic.tarena;

/**
 * 死锁，两个线程都在等待对方释放锁所处于的“僵持”状态
 * @author tarena
 *
 */
public class DeathLockDemo {
	private Object k1 = new Object();
	private Object k2 = new Object();
	public void a(){
		/*
		 * t1先调用的a方法，所以会将k1加锁
		 * 然而t2线程再调用b方法的最后要调用a方法
		 * 所以t2线程会在这里进入阻塞，等待t1将k1的锁释放。
		 * 但是由于t2线程先执行了b方法，所以会将
		 * k2加锁，直以这里将a方法执行完毕才会释放k2锁。
		 */
		synchronized(k1){
			Thread t = Thread.currentThread();
			System.out.println(t+"正在调用a方法");
			try{
				Thread.sleep(5000);
			}catch(InterruptedException e){
			}
			b();  //t1线程只有执行完b方法后才会释放k1
		}
	}
	
	public void b(){
		synchronized(k2){
			Thread t = Thread.currentThread();
			System.out.println(t+"正在调用b方法");
			try{
				Thread.sleep(5000);
			}catch(InterruptedException e){
			}
			a();  //t2线程只有执行完a方法后才会释放k2
		}
	}
	
	public static void main(String[] args) {
		final DeathLockDemo did = new DeathLockDemo();
		Thread t1 = new Thread(){
			public void run(){
				did.a();
				System.out.println(getName()+"执行完毕！");
			}
		};
		
		Thread t2 = new Thread(){
			public void run(){
				did.b();
				System.out.println(getName()+"执行完毕！");
			}
		};
		t1.start();
		t2.start();
	}
}
