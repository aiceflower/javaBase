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

public class MapUtil {
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
		//
		sortByValue = sortByValue(s);
		//比较器
		sortByValue = sortByComValue(s);
		System.out.println(sortByValue);
	}

	/**
	 * 获取map的key
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
	 * 获取map的value
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
	 * 根据key给map排序
	 * @param map,待排序的map
	 * @return，排序后的map
	 */
	public static <K extends Comparable<? super K>, V > Map<K, V>  sortBykey(Map<K,V> map){
		//如果使用这种方式根据value给map排序需要传入一个自定义比较器,如 ValueComparator
		TreeMap<K, V> tree = new TreeMap<K, V>();//默认根据key排序
		tree.putAll(map);
		return tree;
	}
	
	/**
	 * 根据value给map排序
	 * @param map,待排序的map
	 * @return，排序后的map
	 */
	public static <K extends Comparable<? super K>, V extends Comparable<? super V>> Map<K, V> sortByValue(
			Map<K, V> map) {
		List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				if((o1.getValue()).compareTo(o2.getValue())==0){
					return o1.getKey().compareTo(o2.getKey());
				}
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		Map<K, V> result = new LinkedHashMap<K, V>();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}

	/**
	 * 获取不可修改的Map
	 */
	public static <K,V> Map<K,V> getUnModifiableMap(Map<? extends K,? extends V> map){
		return Collections.unmodifiableMap(map);
	}
	
	/**
	 * 根据比较器排序
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <K extends Comparable<K>,V extends Comparable<V>> Map<K,V> sortByComValue(Map<? extends K, ? extends V> map){
		Comparator<K> mc = new MyComparator(map);
		Map<K, V> tree = new TreeMap<K, V>(mc);
		tree.putAll(map);
		return tree;
	}
	
	/**
	 * 比较器
	 * @author pillow
	 *
	 * @param <K>
	 * @param <V>
	 */
	private static class MyComparator<K extends Comparable<K>,V extends Comparable<V>> implements Comparator<K>{

		private Map<K, V> map;
		
		public MyComparator(Map<K, V> map) {
			this.map = map;
		}
		
		@Override
		public int compare(K k1, K k2) {
			if(map.get(k1).compareTo(map.get(k2))==0){
				return k1.compareTo(k2);
			}else{
				return map.get(k1).compareTo(map.get(k2));
			}
		}
		
	}
}


