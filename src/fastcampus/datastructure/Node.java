package fastcampus.datastructure;

public class Node <T>{
	// single, double �� 
	
	public T data;
	 public Node<T> next=null;
	 public Node<T> prev=null;

	public Node(T data) {
		this.data=data;
	}
	
}
