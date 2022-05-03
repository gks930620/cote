package amine;

import java.util.Arrays;

public class MergeSortPractice {
	public static void main(String[] args) {
		int[] arr= {2,4,1,9,7,3,6,8,5};
		mergeSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void mergeSort(int[] arr, int left, int right) {
		if(left>=right) return;
		int mid= (left+right)/2;
		mergeSort(arr,left,mid);
		mergeSort(arr, mid+1, right);
		
		merge(arr, left, mid, right);
	}
	
	//mid를 기준으로 배열을 2개 만들어서 정렬하는  2개의 배열을 정렬해
	public static void merge(int[] arr, int left, int mid, int right) {
		int[] L= Arrays.copyOfRange(arr, left,mid+1);
		int[] R= Arrays.copyOfRange(arr, mid+1,right+1);  //메소드 설명 잘 읽어보면 inclusive, exclusive 있음 참고.
		int i=0;   // L에 대한 index
		int j=0;   // R에 대한 index
		int k=left; //arr에 대한 index
		int ll=L.length;  int rl=R.length;  // L 길이,  R 길이
		while(i<ll  && j <rl) {    //둘중 하나의 배열이 index 초과될때까지
			if(L[i] < R[j]) {
				arr[k]=L[i++];     //이제 R첫번째 타자랑 L 2번쨰 타자랑 비교
			}else {
				arr[k]=R[j++];
			}
			k++; //arr에 첫번째거 들어갔으면 2번째에도 들어가야지
		}
		
		//이제 어느 한쪽은 끝났을 거여.. L,R중에 나머지  원소들이 그대로 arr 다음부터 들어가면 됨 
		while(i<ll) {
			arr[k++]=L[i++];
		}
		while(j<rl) {
			arr[k++]=R[j++];
		}
		
		System.out.println(Arrays.toString(arr)); //한번 merge 할 때 마다 결과 보자.
	}
	
	
	
	
	
}
