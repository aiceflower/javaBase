package learn.design.pattern.strategy;

public class DuckTest {
	public static void main(String[] args) {
		System.out.println("����Ѽ�ӳ���ʼ...");
		Duck duck = null;
		System.out.println("------------------------------");
		//duck = new MallardDuck();
		//duck = new RedHeadDuck();
		//duck = new RubberDuck();
		duck = new BigYellowDuck();
		duck = new SpaceDuck();
		duck.display();
		duck.quack();
		duck.fly();
		System.out.println("����Ѽ�ӳ������...");
	}
}	
