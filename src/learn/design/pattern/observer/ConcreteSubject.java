package learn.design.pattern.observer;

public class ConcreteSubject extends Subject {

	//目标观察者的状态
	private String subjectState;

	public String getSubjectState() {
		return subjectState;
	}

	public void setSubjectState(String subjectState) {
		this.subjectState = subjectState;
		this.notifyObservers();
	}
	
	
}
