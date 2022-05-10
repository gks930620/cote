package datastructure;

public class DoubleLinkedList<T> {
	public Node<T> head=null;
	public Node<T> tail=null;
	
	
	public void addNode(T data) {
		if(this.head==null) {
			this.head=new Node<T>(data);
			this.tail=this.head;
		}else {
			Node<T> node=this.head;
			while(node.next!=null) {
				node=node.next;
			}
			node.next=new Node<T>(data);
			node.next.prev=node;
			this.tail=node.next; 
		}
	}
	
	public T searchFromHead(T isData) {
		if(this.head==null) {
			return null;
		}else {
			Node<T> node=this.head;
			while(node !=null) {
				if(node.data==isData) {
					return node.data;
				}else {
					node=node.next;
				}
			}
			return null;
		}
	}
	
	public T searchFromTail(T isData) {
		if(this.head==null) {
			return null;
		}else {
			Node<T> node=this.tail;
			while(node !=null) {
				if(node.data==isData) {
					return node.data;
				}else {
					node=node.prev;
				}
			}
			return null;
		}
	}
	
	public boolean insertToFront(T existedData,T addData) {
		if(this.head==null) {
			this.head=new Node<T>(addData);
			this.tail=this.head;
			return false;
		}else if(this.head.data==existedData){
			Node<T> newHead= new Node<T>(addData);
			newHead.next=head;
			this.head=newHead;
		
			return true;
		}else {
			Node<T> node=this.head;
			while(node!=null) {
				if(node.data==existedData) {
					Node<T> newNode= new Node<T>(addData);
					newNode.prev=node.prev;
					newNode.next=node;
					node.prev.next=newNode;
					return true;
				}
				node=node.next;
			}
			return false;
		}
	}
	
	public void printAll() {
		if(head!=null) {
			Node<T> node=this.head;
			System.out.println(node.data);
			while(node.next!=null) {
				node=node.next;
				System.out.println(node.data);
			}
		}
	}

}
