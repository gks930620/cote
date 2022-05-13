package datastructure;

import java.util.zip.CRC32;

public class MyHashLinear {
	public Slot[] hashTable;

	public MyHashLinear(Integer size) {
		this.hashTable = new Slot[size];
	}

	public int hashFunc(String key) {
		int originKey=key.charAt(0);
		
		//여기서 중복된 값을 리턴 안하도록 hashFunc를 잘 만드는게 핵심
		return (int) (key.charAt(0)) % this.hashTable.length;
	}

	public boolean saveData(String key, String value) {
		Integer address = this.hashFunc(key);
		if (this.hashTable[address] != null) {
			if (this.hashTable[address].key == key) {
				this.hashTable[address].value = value;
				return true;
			} else {
				Integer currAddress = address + 1;
				while (this.hashTable[currAddress] != null) {
					if (this.hashTable[currAddress].key == key) {
						this.hashTable[currAddress].value = value;
						return true;
					} else {
						currAddress++;
						if (currAddress >= this.hashTable.length) {
							return false;
						}
					}
				} // while문이 종료가되면 배열다 돌기전에 저장할 수 있는 위치를 찾았다.
				this.hashTable[currAddress] = new Slot(key, value);
			}
		} else { // 그냥 애초에 주소에 없으면 바로생성
			this.hashTable[address] = new Slot(key, value);
		}
		return true;
	}

	public String getData(String key) {
		Integer address = this.hashFunc(key);
		if (this.hashTable[address] != null) {
			if (this.hashTable[address].key == key) {
				return this.hashTable[address].value;
			} else {
				Integer curAddress = address + 1;
				while (this.hashTable[curAddress] != null) {
					if (this.hashTable[curAddress].key == key) {
						return this.hashTable[address].value;
					} else {
						curAddress++;
						if (curAddress >= this.hashTable.length)
							return null;
					}
				}// while while문 빠져나오면 배열 다 돌기전에  null 나와도 없는거지..
				return null;
			}	 
			
		} else {
			return null;
		}
	}

	public class Slot {
		String value;
		String key;

		Slot(String key, String value) {
			this.value = value;
			this.key = key;
		}
	}
}
