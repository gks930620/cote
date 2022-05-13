package sort;
import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args) {
		int[] arr = { 1,3,4,9,6,7,8 };
		selection(arr);
		System.out.println(Arrays.toString(arr));
	}

	//ascending
	static void selection(int[] arr) {
		for(int i=1; i<arr.length ; i++) {
			int min=arr[i-1];
			int minIndex=i-1;
			for(int j=i; j<arr.length ; j++) {
				if(min>arr[j]) {
					min=arr[j];
					minIndex=j;
				}
			}
			arr[minIndex]=arr[i-1]; // 가장작은 값이 있던 곳에  맨 앞에 데이터 넣기   
			arr[i-1]=min;  // 맨앞데이터에 가장작은 값      넣기 
		}
		
	}
}
