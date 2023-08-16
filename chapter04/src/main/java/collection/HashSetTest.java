package collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		Set<String> s = new HashSet<>();
		
		String s1 = new String("둘리밥");
		String s2 = new String("둘리밥");
		
		s.add("둘리밥");
		s.add("이콜이형");
		s.add("우너도우너");
		s.add(s1);
		//s.add(s2);
		
		System.out.println(s.size());
		System.out.println(s.contains(s2));
		
		// ** set 은 값 기반이다 값 기반 값이야 값 갑 갑 갚 갚 갑 갚
		
		// 수내
		for(String str:s) {
			System.out.println(str);
		}
	}

}
