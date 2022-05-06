package sort;
import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		int[] arr = { 1,3,4,9,6,7,8,0 };
		insertion(arr);
		System.out.println(Arrays.toString(arr));
	} 

	//ascending
	static void insertion(int[] arr) {
		for(int i=1 ;i<arr.length ; i++) {
			int temp=arr[i];
			int prev=i-1;
			while(prev>=0&&temp < arr[prev]) {
				arr[prev+1]=arr[prev--];
			}
			arr[prev+1]=temp;
		}
	}
	
}
