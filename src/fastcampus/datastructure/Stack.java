package fastcampus.datastructure;

import java.util.ArrayList;

public class Stack<T> {
	ArrayList<T> stack=new ArrayList<T>();

	//stack에 값 추가 
	public void push(T t) {
		stack.add(t);
	}
	//stack 값 제거
	public T pop() {
		if(stack.isEmpty()) return null;
		return stack.remove(stack.size()-1);
	}
	
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
}
