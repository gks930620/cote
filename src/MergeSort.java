import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int[] arr= {2,4,1,9,7,3,6,8,5};
		mergeSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	//재귀부분 따로,       merge부분 따로 생각하는게 핵심.
	//각각 정렬된 2개의 배열을 한개의 배열로만들면서 정열하는 메소드
	
	public static void mergeSort(int[] array, int left, int right) {
	    if (left < right) {
	        int mid = (left + right) / 2;
	 
	        mergeSort(array, left, mid);
	        mergeSort(array, mid + 1, right);
	        merge(array, left, mid, right); 
	    }
	}
	 
	public static void merge(int[] array, int left, int mid, int right) {
	    int[] L = Arrays.copyOfRange(array, left, mid + 1);
	    int[] R = Arrays.copyOfRange(array, mid + 1, right + 1);
	 
	    int i = 0, j = 0, k = left;
	    int ll = L.length, rl = R.length;
	 
	    while (i < ll && j < rl) {
	        if (L[i] <= R[j]) {
	            array[k] = L[i++];
	        } else {
	            array[k] = R[j++];
	        }
	        k++;
	    }
	    
	    
	    //일괄복사는 둘중에 하나만 실행되겠군 
	    //왼쪽의 남아있는거 일괄 복사
	    while (i < ll) {
	        array[k++] = L[i++];
	    }
	    //오른쪽에 남아있는 값 일괄 복사 
	    while (j < rl) {
	        array[k++] = R[j++];
	    }
	    
	    //System.out.println(Arrays.toString(array)); 한번 merge 할 때 마다 결과 보자.
	}
}
