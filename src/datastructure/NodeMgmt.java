package datastructure;

public class NodeMgmt {
	Node head=null;
	
	
	public class Node{
		Node left;
		Node right;
		int value;
		public Node(int data){
			this.value=data;
			this.left=null;
			this.right=null;
		}
	}
	
	public boolean insertNode(int data) {
		// Node가 하나도 없을 때
		if(this.head==null) {
			this.head=new Node(data);
			return true;
		}else {
			//Node가 하나 이상 있을 때 
			Node findNode=this.head;
			while(true) {
				// 현재 Node의 왼쪽에 Node가 들어가야 할 때
				if(data<findNode.value) {
					if(findNode.left!=null) {
						findNode=findNode.left;
					}else {
						findNode.left=new Node(data);
						break;
					}
				}
				// 현재 Node의 오른쪽에 Node가 들어가야 할 때
				if(data>findNode.value) {
					if(findNode.right!=null) {
						findNode=findNode.right;
					}else {
						findNode.right=new Node(data);
						break;
					}
				}
				
			}//while
			return true;
		}
		
	}
}
