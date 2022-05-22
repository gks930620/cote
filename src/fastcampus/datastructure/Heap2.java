package fastcampus.datastructure;

import java.util.ArrayList;
import java.util.Collections;

public class Heap2 {
	public static void main(String[] args) {
		Heap2 heap = new Heap2(15);
		heap.insert(10);
		heap.insert(6);
		heap.insert(5);
		heap.insert(4);
		heap.insert(20);
		System.out.println(heap.heapArray);
		System.out.println(heap.pop());
		System.out.println(heap.heapArray);
		
	}

	public ArrayList<Integer> heapArray = null;

	public Heap2(Integer data) {
		heapArray = new ArrayList<>();
		heapArray.add(null); // ��꽱���ϱ�����0�� null
		heapArray.add(data);
	}

	public boolean insert(Integer data) {
		Integer insertedIndex, parentIndex;
		if (heapArray == null) {
			heapArray = new ArrayList<>();
			heapArray.add(null);
			heapArray.add(data);
			return true;
		}
		this.heapArray.add(data);
		insertedIndex = this.heapArray.size() - 1;
		while (this.moveUp(insertedIndex)) {
			parentIndex = insertedIndex / 2;
			Collections.swap(this.heapArray, insertedIndex, parentIndex);
			insertedIndex = parentIndex;
		}
		// ���οö󰡸鼭 ���������� �� �ٲ�.
		return true;
	}
	
	public Integer pop() {
		Integer returnedData,poppedIndex, leftChildPoppedIndex,rightChildPoppedIndex;
		if(this.heapArray==null) {
			return null;
		}else {
			returnedData=this.heapArray.get(1);
			this.heapArray.set(1, this.heapArray.size()-1);
			this.heapArray.remove(this.heapArray.size()-1);
			poppedIndex=1;
			
			while(move_down(poppedIndex)) {
				leftChildPoppedIndex=poppedIndex*2;
				rightChildPoppedIndex=poppedIndex*2+1;
				 
				//CASE2: ���ʸ� ���� ��
				if(rightChildPoppedIndex>=this.heapArray.size()) {
					if(this.heapArray.get(poppedIndex)<this.heapArray.get(leftChildPoppedIndex)) {
						Collections.swap(heapArray, poppedIndex, leftChildPoppedIndex );
						poppedIndex=leftChildPoppedIndex;
					}
				}else {
					//CASE3: �Ѵ� ���� ��
					if(this.heapArray.get(leftChildPoppedIndex)>this.heapArray.get(rightChildPoppedIndex)) {
						if(this.heapArray.get(poppedIndex)< this.heapArray.get(leftChildPoppedIndex)) {
							Collections.swap(heapArray, poppedIndex, leftChildPoppedIndex);
							poppedIndex=leftChildPoppedIndex;
						}
					}else {
						if(this.heapArray.get(poppedIndex)< this.heapArray.get(rightChildPoppedIndex)) {
							Collections.swap(heapArray, poppedIndex, rightChildPoppedIndex);
							poppedIndex=rightChildPoppedIndex;
						}
					}
					
					
				}
				
			}
			return returnedData;
		}
	}

	public boolean moveUp(Integer insertedIndex) {
		if (insertedIndex <= 1) {
			return false; // �θ����� ���
		}
		Integer parentIndex = insertedIndex / 2;
		if (this.heapArray.get(insertedIndex) > this.heapArray.get(parentIndex)) {
			return true;
		} else {
			return false;
		}

	}
	
	
	 
	public boolean move_down(Integer poppedIndex) {
		Integer leftChildPoppedIndex, rightChildePoppedIndex;
		leftChildPoppedIndex=poppedIndex*2;
		rightChildePoppedIndex=poppedIndex*2+1;
		//CASE1: �ڽĳ�尡 ���� �� ( ������ ������ �ڽĳ�尡���°���)
		if(leftChildPoppedIndex>=this.heapArray.size()) {
			return false;    //
		}else if(rightChildePoppedIndex>=this.heapArray.size()) {
			//CASE2 : ������ �ڽ� ��常 ���� �� 
			if(this.heapArray.get(poppedIndex) < this.heapArray.get(leftChildPoppedIndex)) {
				return true;
			}else {
				return false;
			}
		}else {
			//CASE3: ���� ������ �ڽ� ��� ��� ���� �� 
			if(this.heapArray.get(leftChildPoppedIndex)>this.heapArray.get(rightChildePoppedIndex)) {
				if(this.heapArray.get(poppedIndex)< this.heapArray.get(leftChildPoppedIndex)) {
					return true;
				}else {
					return false;
				}
			}else {
				if(this.heapArray.get(poppedIndex)< this.heapArray.get(rightChildePoppedIndex)) {
					return true;
				}else {
					return false;
				}
			}
			
		}
	}

}
