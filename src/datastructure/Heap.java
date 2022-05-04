package datastructure;

import java.util.Arrays;

public class Heap {
	//heap에서의 삭제는 루트노드를 삭제하는거.  이건 지금 최소힙임. 최대힙은 부호만 바꾸면 됨
	public static void main(String[] args) {
		Heap h = new Heap();
		h.insertHeap(13);
		h.insertHeap(8);
		h.insertHeap(10);
		h.insertHeap(15);
		h.insertHeap(20);
		h.insertHeap(19);
		System.out.println(Arrays.toString(h.itemHeap));
		h.deleteHeap();
		System.out.println(Arrays.toString(h.itemHeap));
	}

	private int heapSize;
	private int itemHeap[];

	public Heap() {
		heapSize = 0;
		itemHeap = new int[50];
	}

	public void insertHeap(int item) {
		int i = ++heapSize;
		itemHeap[i] = item; // 일단 다음노드에
		int pi = i / 2;
		while (i != 1 && itemHeap[pi] > itemHeap[i]) { // 처음넣을땐 제외, 그 다음엔 부모랑 비교
			swap(itemHeap, pi, i);
			i /= 2;
		}

	}

	private void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

	public int getHeapSize() {
		return this.heapSize;
	}

	public int deleteHeap() { // 현재 루트노드를 return 한다.
		int temp = itemHeap[1];
		itemHeap[1] = itemHeap[heapSize]; // 마지막 노드를 맨 위로 올려.
		itemHeap[heapSize--] = 0; // heapSize 줄이고, 마지막 노드는 0으로

		int lc=0; int rc=0;
		int pi=1;
		while (lc<heapSize && rc<heapSize) {
			lc = pi * 2;
			rc = lc + 1;
			if(itemHeap[pi] < itemHeap[lc] && itemHeap[pi]<itemHeap[rc] ) break;
			if (itemHeap[pi] > itemHeap[lc]) {
				swap(itemHeap, pi, lc);
				System.out.println("a"+Arrays.toString(itemHeap));
				pi=lc;
			}else if (itemHeap[pi] > itemHeap[rc]) {
				swap(itemHeap, pi, rc);
				pi=rc;	
			}
		}

		return temp;
	}

}
