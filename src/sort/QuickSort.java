package sort;
import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] arr= {2,4,1,9,7,3,6,8,5};
		quickSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	//재귀 따로,    partion부분 따로 생각 
	// partion은 한 배열에서  pivot을 기준으로 왼쪽에 작은거, 오른쪽에 큰거  배치시키는 함수 
	static void quickSort(int[] arr, int left, int right) {
		if(left>=right) return;
		
		//한번 진행
		int pivotPosition= partition(arr, left, right); 
		quickSort(arr, left, pivotPosition-1);//가운데값(pivot) 기준 왼쪽거 또 quickSort
		quickSort(arr, pivotPosition+1, right);// pivot 기준 오른쪽 quickSort
	} 
	
	static int partition(int[] arr,int left,int right) {
		int pivot= arr[right] ;  //오른쪽이 pivot  
		int i=left-1;            // i : pivot보다 작은거 몇번째인지를 나타내는 기준값
		for(int j=left; j<right ; j++) {  //작은 값들은 왼쪽으로... (arr[i]값이랑 자리 변경
			if(arr[j] <pivot) {
				i++;
				if(i!=j)swap(arr,i,j);
			}	
		}
		i++;
		swap(arr,i, right );
		return i; //pivot 위치 return
	}
	
	
	static void swap(int[] arr, int i, int j) {
		int temp=arr[j];
		arr[j]=arr[i];
		arr[i]=temp;
	}
	
	
}
