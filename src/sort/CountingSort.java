package sort;
import java.util.Arrays;

public class CountingSort {
	public static void main(String[] args) {
		int[] arr= {15,11,10,2,6,7,1,5,3,6,8,1,10,11,15,3,6,8,9,10,0,2,5,14,  13,11,11};
		countingSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	
	
	public static void countingSort(int[] arr ) {
		int max=max(arr);
		int[] counting=new int[max+1];
		int[] result=new int[arr.length];
		
		//counting 배열 만들기.   각 원소가 몇개있는지
		for(int i=0; i<arr.length; i++) {
			counting[arr[i]]++;
		}
		
		//couting 배열 누적합 만들기 
		for(int i=1; i<counting.length ; i++) {
			counting[i]+=counting[i-1];
		}
		
		
		//result 만들기
		for(int i=arr.length-1; i>=0 ; i--) {
			counting[arr[i]]--;
			result[counting[arr[i]]]= arr[i];
		}
		
		//메소드 이름이 countingSort니까  result가 arr이 되면 되겠지.
		for(int i=0; i<arr.length; i++) {
			arr[i]=result[i];
		}
		
	}
	
	public static int max(int[] arr) {
		int max=arr[0];
		for(int i=1; i<arr.length ; i++) {
			max= max<arr[i] ? arr[i]  : max;
		}
		return max;
	}
	
	
}
