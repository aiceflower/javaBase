package learn.basic.map;

import java.util.Comparator;
import java.util.Map;

public class ValueComparator implements Comparator<String> {
		  
	Map<String, Double> base;

	public ValueComparator(Map<String, Double> base) {
		this.base = base;
	}

	@Override
	public int compare(String d1, String d2) {
		
		if (base.get(d1) >= base.get(d2)) {  
            return -1;  
        } else {  
            return 1;  
        }
	}

}