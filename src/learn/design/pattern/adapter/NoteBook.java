package learn.design.pattern.adapter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NoteBook {
	private PlugInterFace plug;
	
	public NoteBook(){
		
	}
	
	//��������ת������
	public NoteBook(PlugInterFace plug){
		this.plug = plug;
	}
	
	public static void main(String[] args) {
		//NoteBook.twoToThree();
		//System.out.println("\n------------------");
		//NoteBook.threeToTwo();
		PlugInterFace three = new PlugAdapterExtends();
		NoteBook nb = new NoteBook(three);
		nb.chargeThree();
	}
	
	
	
	/**
	 * ����ת����
	 */
	public static void twoToThree(){
		GBTwoPlug two = new GBTwoPlug();
		PlugInterFace three = new PlugAdapter(two);
		NoteBook nb = new NoteBook(three);
		nb.chargeThree();
	}
	
	/**
	 * ����ת����
	 */
	public static void threeToTwo(){
		GBThreePlug three = new GBThreePlug();
		PlugInterFace two = new PlugAdapter(three);
		NoteBook nb = new NoteBook(two);
		nb.chargeTwo();
	}
	
	/**
	 *�ʼǱ������������ 
	 */
	public void chargeThree(){
		plug.powerWithThree();
	}
	
	/**
	 * �ʼǱ������������
	 */
	public void chargeTwo(){
		plug.powerWithTwo();
	}
}
