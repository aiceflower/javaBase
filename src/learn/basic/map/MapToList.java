package learn.basic.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapToList {
	public static void main(String[] args) {
		Map<Double, Double> s = new HashMap<Double, Double>();
		s.put(1.1, 2.3);
		s.put(1.5, 1.2);
		s.put(1.7, 2.5);
		s.put(1.0, 2.7);
		s.put(2.3, 2.4);
		s.put(2.5, 2.9);
		System.out.println(s);
		Map<Double, Double> sortByValue = sortBykey(s);
		System.out.println(sortByValue);
		sortByValue = sortByValue(s);
		System.out.println(sortByValue);
	}

	/**
	 * ��ȡmap��key
	 * 
	 * @param map
	 * @return List<String>
	 */
	public static List<String> parsMapKeyToList(Map<String, Object> map) {
		if (map == null || map.isEmpty()) {
			return null;
		}
		List<String> list = new ArrayList<String>();
		for (String key : map.keySet()) {
			// list.add(map.get(key).toString());
			list.add(key);
		}
		return list;
	}

	/**
	 * ��ȡmap��value
	 * 
	 * @param map
	 * @return List<String>
	 */
	public static List<String> parsMapValueToList(Map<String, Object> map) {
		if (map == null || map.isEmpty()) {
			return null;
		}
		List<String> list = new ArrayList<String>();
		for (String key : map.keySet()) {
			list.add(map.get(key).toString());
		}
		return list;
	}

	
	/**
	 * ����key��map����
	 * @param map,�������map
	 * @return��������map
	 */
	public static <K extends Comparable<? super K>, V > Map<K, V>  sortBykey(Map<K,V> map){
		//���ʹ�����ַ�ʽ����value��map������Ҫ����һ���Զ���Ƚ���,�� ValueComparator
		TreeMap<K, V> tree = new TreeMap<K, V>();//Ĭ�ϸ���key����
		tree.putAll(map);
		return tree;
	}
	
	/**
	 * ����value��map����
	 * @param map,�������map
	 * @return��������map
	 */
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(
			Map<K, V> map) {
		List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		Map<K, V> result = new LinkedHashMap<K, V>();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}

}
