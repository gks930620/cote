import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] arr= {2,4,1,9,7,3,6,8,5};
		partition(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	static void quickSort(int[] arr, int left, int right) {
		
	} 
	
	static void partition(int[] arr,int left,int right) {
		int pivot= arr[right] ;  //오른쪽이 pivot  
		int i=left-1; 
		for(int j=left; j<right ; j++) {  //작은 값들은 왼쪽으로... (arr[i]값이랑 자리 변경
			if(arr[j] <pivot) {
				i++;
				if(i!=j)swap(arr,i,j);
			}	
		}
		i++;
		swap(arr,right, i );
	}
	static void swap(int[] arr, int i, int j) {
		int temp=arr[j];
		arr[j]=arr[i];
		arr[i]=temp;
	}
	
	
}
