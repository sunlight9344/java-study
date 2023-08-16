package collection;

import java.util.HashSet;
import java.util.Set;

public class HashSet0Test02 {

	public static void main(String[] args) {
		Set<Gugudan> set = new HashSet<>();
		
		set.add(new Gugudan(4,2));
		set.add(new Gugudan(2,4));
		set.add(new Gugudan(9,9));
		
		for(Gugudan g:set) {
			System.out.println(g);
		}
	}

}
