import java.util.Arrays;

import sort.ARandom;

public class BinarySearch {
	public static void main(String[] args) {
		int[] arr= ARandom.randomArrayNoDup(15, 16);
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		int index= binarySearch(arr, 5);
		System.out.println("5는 어디에 있나? => " +  index);
	}
	public static int binarySearch(int[] arr, int M) {
		int left=0;
		int right=arr.length-1;
		int mid=0;
		
		while(left<=right) {
			 mid=(left+right)/2;
			if(M== arr[mid]) return mid;
			if(M< arr[mid]) {  //왼쪽에 있다
				right=mid-1;
			}else { // 오른쪽에 있다.
				left=mid+1;
			}
		}
		return -1; //없으면 -1을 리턴하자
	}
}
