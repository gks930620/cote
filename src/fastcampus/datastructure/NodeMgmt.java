package fastcampus.datastructure;

//완벽하진않은데 도저히 수정할 수 없더라..   나중에 강의자료 보고 다시 수정하자.
public class NodeMgmt {
	Node head=null;
	
	
	public class Node{
		public Node left;
		public Node right;
		public int value;
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
	
	public Node search(int data) {
		//Case1 : node가 없을 때
		if(this.head==null) {
			return null;
			//CASE2 : NODE가  하나 이상 있을 때
		}else {
			Node findNode=this.head;
			while(findNode !=null) {
				if(findNode.value==data) {
					return findNode;
				}else if (data<findNode.value) {
					findNode=findNode.left;
				}else {
					findNode=findNode.right;
				}
			}
			return null;
		}
	}
	
	public boolean delete(int value) {
		boolean searched=false;
		Node currParetNode=this.head;
		Node currNode=this.head;
		if(this.head==null) {
			return false; // Node가 전혀 없을 때
		}else { 
			if(this.head.value==value && this.head.left==null && this.head.right==null) {
				//Node가 하나만 있고 해당 Node가 삭제할 NODE일 때
				this.head=null;
				return true;
			}
			
			while( currNode !=null) {
				if(currNode.value==value) {
					searched=true;
					break;
				}else if(value<currNode.value){
					currParetNode=currNode;
					currNode=currNode.left;
				}else {
					currParetNode=currNode;
					currNode=currNode.right;
				}
			}
			//찾아서  break 된경우와    leaf까지 가서 currNode==null이 된 경우
			if(searched==false) {
				return false;
			} //못찾으면 return  찾으면 else밖으로 나감
		}
		//여기까지오면 찾은거다.
		//여기까지 실행되면 currNode에는 해당데이터를 가지고 있는 Node,
		//currParentNode에는 해당 데이터를 가지고 있는 Node의 부모 
		//value==currNode.value랑 같다.
		
		if(currNode.left==null && currNode.right==null) { //leaf노드인경우
			if(value<currParetNode.value) {
				currParetNode.left=null;
				currNode=null;
			}else {
				currParetNode.right=null;
				currNode=null;
			}
			return true;
		}else if(currNode.left!=null && currNode.right==null) {
			//childeNode가 왼쪽
			if(value <currParetNode.value) {   //현재노드가 부모의 왼쪽 
				currParetNode.left=currNode.left;
				currNode=null;
			}else {//현재노드가 부모의 오른쪽
				currParetNode.right=currNode.left;
				currNode=null;
			}
			return true;
		}else if(currNode.left==null && currNode.right!=null) {
			//childeNode가 오른쪽
			if(value<currParetNode.value) {  //현재노드가 부모의 왼쪽
				currParetNode.left=currNode.right;
				currNode=null;
			}else {//현재노드가 부모의 오른쪽
				currParetNode.right=currNode.right;
				currNode=null;
			}
			return true;
		}else {//child Node가 2개
			//삭제할 노드가 패런트노드의 왼쪽에 있을 때
			if(value<currParetNode.value) {
				Node changeNode=currNode.right;
				Node changeParentNode=currNode.right;
				while(changeNode.left!=null) {
					changeParentNode=changeNode;
					changeNode=changeNode.left;
				}
				//여기까지 실행되면 changeNode에는 삭제할 Node의 오른쪽Node가
				//가장 작은 값을 가진 NOde가 들어있음(없을 수도 있음)
				
				if(changeNode.right!=null) {
					//changeNode의 childNOde(오른쪽)가 있을 떄 
					changeParentNode.left=changeNode.right;
					
				}else {
					//changeNode의 childeNode가 없을 떄
					changeParentNode.left=null; //연결끊어줘야지.
				}
				//현재 부모의 왼쪽node에 삭제할 node의 자식중 가장 작은값 연결
				currParetNode.left=changeNode;
				//chageNode의 왼쪽,오른쪽childNode를 모두 삭제할 currNode의 기존 왼쪽,오른쪽 Node로 변경
				changeNode.left=currNode.left;
				changeNode.right=currNode.right;
				
				currNode=null; //안해도되지만 삭제했다는 의미.
				return true;
			}else {//삭제할 노드가 부모의 오른쪽에 있을 때.
				
				//삭제할 노드의 오른쪽 자식중 가작 작은 값 찾는과정은 똑같음.
				Node changeNode=currNode.right;
				Node changeParentNode=currNode.right;
				while(changeNode.left!=null) {
					changeParentNode=changeNode;
					changeNode=changeNode.left;
				}
				//여기까지 실행되면 changeNode에는 삭제할 Node의 오른쪽Node가
				//가장 작은 값을 가진 NOde가 들어있음(없을 수도 있음)
				
				if(changeNode.right!=null) {
					//changeNode의 childNOde(오른쪽)가 있을 떄 
					changeParentNode.left=changeNode.right;
					
				}else {
					//changeNode의 childeNode가 없을 떄
					changeParentNode.left=null; //연결끊어줘야지.
				}
				//여기까지는 위와 동일
				//삭제과정이 다름 
				
				currParetNode.right=changeNode;
				changeNode.left=currNode.left;
				changeNode.right=currNode.right;
				
				currNode=null; //안해도되지만 삭제했다는 의미.
				return true;
			}
			
			
		}
		
		
	}
	
	
	
}
