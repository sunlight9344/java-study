package collection;

import java.util.Vector;

public class VectorTest01 {

	public static void main(String[] args) {
		Vector<String> v = new Vector<>();
		
		v.addElement("둘리");
		v.addElement("마이콜");
		v.addElement("도우너	");
		
		for(int i=0;i<v.size();i++) {
			System.out.println(v.elementAt(i));
		}
		
		v.removeElementAt(2);
		
		
	}

}
