import java.io.ObjectInputStream.GetField;

import datastructure.DoubleLinkedList;
import datastructure.MyHash;
import datastructure.SingleLinkedList;

public class Test {
	public static void main(String[] args) {
		MyHash myHash=new MyHash(20);
		myHash.saveData("DaveLee", "01080333117");
		myHash.saveData("fun-coding", "01080222217");
		System.out.println(myHash.getData("DaveLee"));
		
	}
}
