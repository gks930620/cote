package sort;
import java.util.Arrays;

import fastcampus.datastructure.Heap;

public class HeapSort {
	public static void main(String[] args) {
		int[] array = { 230, 10, 60, 550, 40, 220, 20 };
		 
	    heapSort(array);
	 
	    System.out.println(Arrays.toString(array));
			
	}
	
	public static void heapSort(int[] array) {
	    int n = array.length;
	 
	    // 현재 배열을 일단 첫번째 최대힙으로 만들어
	    for (int i = n / 2 - 1; i >= 0; i--) { //   n/2-1개의 서브트리를 조사하는거군
	        heapify(array, n, i);
	    }
	    
	    System.out.println(Arrays.toString(array));
			
	    // 언제나 그렇지만 재귀자체는 쉽다
	    for (int i = n - 1; i > 0; i--) {
	        swap(array, 0, i);  // 가장큰 값은 뒤로보냄(뒤에 있던 값은 자식노드중의 제일 오른쪽 
	        heapify(array, i, 0);  //가장 큰 값은 뒤로 보내고 0번째부터 n-1까지 다시 힙을 만듬
	        System.out.println(Arrays.toString(array));     
	    }
	}
	
	
	public static void heapify(int array[], int n, int i) {
	    int p = i;
	    int l = i*2 + 1;
	    int r = i*2 + 2;
	    
	    //하나의 서브트리 조사하는거군
	    //왼쪽 자식노드
	    if (l < n && array[p] < array[l]) {  //l<n은 마지막 요소는 제외하겠다..
	        p = l; 
	    }
	    //오른쪽 자식노드
	    if (r < n && array[p] < array[r]) {
	        p = r;
	    }
	    
	    //부모노드 < 자식노드   여기까지왔을때  오른쪽 자식이나 왼쪽자식 중 큰게 부모노드가 됨  위에 if문 2개 잘 보삼 
	    if(i != p) {
	        swap(array, p, i);
	        heapify(array, n, p);  //현재 최상위 서브트리만 조사했는데 교환이 일어나면  교환이 일어난곳의 서브트리의 서브트리들까지 또 확인해야지. 
	    }
	}
	
	
	 
	public static void swap(int[] array, int a, int b) {
	    int temp = array[a];
	    array[a] = array[b];
	    array[b] = temp;
	}
}

