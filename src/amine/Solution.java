package amine;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		String a = "1 2 3 4";
		System.out.println(Arrays.toString(solution(4, 11)));
	}

	static ArrayList<Integer> list= new ArrayList<>();
	static int[] arr;
	public static int[] solution(int n, long k) {
		arr=new int[n];
		for(int i=1; i<=n ;i++) {
			list.add(i);
		}
		
		selectNum(n,k,0);
		
		
		return arr;
	}

	public static void selectNum(int n,long k, int deep) {
		if(deep==arr.length) {
			return;
		}
		long fact= factorial(n-1);
		for(int i=1; i<=n ; i++) {
			if(i*fact >= k) {
				System.out.println(i);
				arr[deep]=list.get(i-1);
				list.remove(i-1);
				selectNum(n-1, k-(i-1)*factorial(n-1), deep+1);
				break;
			}
		}
		
		
	}
	
	
	public static long factorial(int n) {
		int fact=1;
		for (int i = 1; i <= n; i++) {
			fact*=i;
		}
		return fact;
	}

}
