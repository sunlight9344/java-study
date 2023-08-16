package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		Map<String,Integer> m = new HashMap<>();
		m.put("one", 1); // auto boxing
		m.put("tow", 2);
		m.put("thr", 3);
		
		int i = m.get("one");
		int j = m.get(new String("one"));
		System.out.println(i + ":" + j);
		
		m.put("one", 99);
		System.out.println(m.get("one"));
		
		Set<String> s= m.keySet();
		for(String k:s) {
			System.out.println(k);
		}
	}

}
