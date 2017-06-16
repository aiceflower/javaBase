package learn.basic.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapToList {
	public static void main(String[] args) {

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
}
