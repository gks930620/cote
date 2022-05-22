package fastcampus.datastructure;

import java.util.ArrayList;

//ArrayList를 활용한
public class Queue<T> {
	ArrayList<T> queue=new ArrayList<T>();
	public void enqueue(T t) {
		queue.add(t);
	}
	//arrayList는 제거하면 자동으로 한칸씩 땡긴다.
	public T dequeue() {
		if(queue.isEmpty()) return null;
		return queue.remove(0);
	}
	
	public boolean isEmpty() {
		return queue.isEmpty();
	}
}
