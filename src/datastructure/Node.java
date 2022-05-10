package datastructure;

public class Node <T>{
	// single, double ´Ù 
	
	public T data;
	 public Node<T> next=null;
	 public Node<T> prev=null;

	public Node(T data) {
		this.data=data;
	}
	
}
