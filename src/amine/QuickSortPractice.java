package amine;

import java.util.Arrays;

public class QuickSortPractice {
	public static void main(String[] args) {
		int[] arr= {2,4,1,9,7,3,6,8,5};
		quickSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	static void quickSort(int[] arr, int left, int right) {
		if(left>=right) return; //나눈 배열이 길이가 1일 때   더 이상 정렬 할 필요가 없지   
		int pivotPosition= partition(arr, left, right);
		
		quickSort(arr, left, pivotPosition-1);
		quickSort(arr,pivotPosition+1 , right);
		
	}
	
	//어떤 기준값(보통은 배열의 끝값)을 가지고 기준값보다 작은건 왼쪽에, 큰건 오른쪽에 배치하고  수정된 기준값의 위치를 return 
	static int partition(int[] arr, int left, int right ) {
		int pivot=arr[right];
		int i=left-1;  // i : pivot보다 작은거 몇번째인지를 나타내는 기준값 
		for(int j=left ; j< right ; j++) {      
			if(arr[j] < pivot) {
				i++;
				swap(arr,i,j);     
			}
		}
		//마지막으로 pivot을 가운데에 위치시키기
		i++; 
		swap(arr,i,right);
		return i;
	}
	
	static void swap(int nums[], int i, int j){
	    int temp = nums[i];
	    nums[i] = nums[j];
	    nums[j] = temp;
	}
}
