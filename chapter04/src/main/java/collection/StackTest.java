package collection;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<String> s = new Stack<>();
		
		s.push("피카츄");
		s.push("라이츄");
		s.push("파이리");
		s.push("꼬부기");
		
		while(!s.isEmpty()) {
			System.out.println(s.pop());
		}
		
		// beer 있는 경우에 예외 발생
//		s.pop();
		
		s.push("피카츄");
		s.push("라이츄");
		s.push("파이리");
		s.push("꼬부기");
		
		System.out.println(s.pop());
		System.out.println(s.peek());
		System.out.println(s.pop());
	}

}
