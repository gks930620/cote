package fastcampus.datastructure;

public class MyHash {
	public Slot[]  hashTable;
	
	public MyHash(Integer size) {
		this.hashTable=new Slot[size];
	}
	
	public int hashFunc(String key) {
		return (int)(key.charAt(0))%this.hashTable.length;
	}
	
	public boolean saveData(String key,String value) {
		Integer address=this.hashFunc(key);
		if(this.hashTable[address] !=null) {
			Slot findSlot=this.hashTable[address];
			Slot prevSlot=this.hashTable[address];
			while(findSlot!=null) {
				if(findSlot.key==key) { 
					findSlot.value=value;
					return true;
				}else {
					prevSlot=findSlot;
					findSlot=findSlot.next;
				}
			}
			prevSlot.next=new Slot(key,value);
			
		}else {
			this.hashTable[address]=new Slot(key,value);
		}
		return true;
	}
	
	public String getData(String key) {
		Integer address=this.hashFunc(key);
		if(this.hashTable[address]!=null) {
			Slot findSlot=this.hashTable[address]; //head
			while(findSlot!=null) {
				if(findSlot.key==key) {
					return findSlot.value;
				}else {
					findSlot=findSlot.next;
				}
			}
			
			return this.hashTable[address].value;
		}else {
			return null;
		}
	}
	
	
	
	
	public class Slot{
		String value;
		String key;
		Slot next;
		Slot(String key,String value) {
			this.value=value;
			this.key=key;
			this.next=null;
		}
	}	
}
