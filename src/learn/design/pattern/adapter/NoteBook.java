package learn.design.pattern.adapter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NoteBook {
	private PlugInterFace plug;
	
	public NoteBook(){
		
	}
	
	//二相三相转换构造
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
	 * 二相转三相
	 */
	public static void twoToThree(){
		GBTwoPlug two = new GBTwoPlug();
		PlugInterFace three = new PlugAdapter(two);
		NoteBook nb = new NoteBook(three);
		nb.chargeThree();
	}
	
	/**
	 * 三相转二相
	 */
	public static void threeToTwo(){
		GBThreePlug three = new GBThreePlug();
		PlugInterFace two = new PlugAdapter(three);
		NoteBook nb = new NoteBook(two);
		nb.chargeTwo();
	}
	
	/**
	 *笔记本三相电流供电 
	 */
	public void chargeThree(){
		plug.powerWithThree();
	}
	
	/**
	 * 笔记本二相电流供电
	 */
	public void chargeTwo(){
		plug.powerWithTwo();
	}
}
