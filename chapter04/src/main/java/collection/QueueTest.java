package collection;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<>();
		
		queue.offer("둘리");
		queue.offer("마이콜");
		queue.offer("또치");
		queue.offer("도우너");
		
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
		
		queue.offer("둘리");
		queue.offer("마이콜");
		queue.offer("또치");
		System.out.println(queue.poll());
		System.out.println(queue.peek());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		
		System.out.println(queue.poll());
		
	}

}
