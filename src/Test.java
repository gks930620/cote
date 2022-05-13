
import datastructure.*;
public class Test {
	public static void main(String[] args) {
	NodeMgmt myTree=new NodeMgmt();
	myTree.insertNode(3);
	myTree.insertNode(1);
	myTree.insertNode(4);
	myTree.insertNode(9);
	myTree.insertNode(15);
	System.out.println(myTree.search(3).value);
		
	}
}
