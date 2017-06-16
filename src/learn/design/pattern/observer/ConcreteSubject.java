package learn.design.pattern.observer;

public class ConcreteSubject extends Subject {

	//Ŀ��۲��ߵ�״̬
	private String subjectState;

	public String getSubjectState() {
		return subjectState;
	}

	public void setSubjectState(String subjectState) {
		this.subjectState = subjectState;
		this.notifyObservers();
	}
	
	
}
