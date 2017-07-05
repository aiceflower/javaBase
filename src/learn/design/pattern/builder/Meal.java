package learn.design.pattern.builder;

import java.util.ArrayList;
import java.util.List;

public class Meal {

	private List<Item> items = new ArrayList<Item>();
	
	/**
	 * ���
	 * @param item
	 */
	public void addItem(Item item){
		items.add(item);
	}
	
	/**
	 * ��ȡ���ѽ��
	 * @return
	 */
	public float getCost(){
		float cost = 0.0f;
		for (Item item : items) {
			cost += item.price();
		}
		return cost;
	}
	
	/**
	 * չʾ��Ʒ
	 */
	public void showItems(){
		for (Item item : items) {
			StringBuilder sb = new StringBuilder();
			sb.append("Items:"+item.name());
			sb.append(",Packing:"+item.packing().pack());
			sb.append(",Price:"+item.price());
			System.out.println(sb.toString());
		}
	}
}
