package programmers;

import java.util.Arrays;

public class FullSearchFindPrime {
	public static void main(String[] args) {
		String numbers = "0313";
		solution(numbers);
	}
	
	
	public static int solution(String numbers) {
		String[] arr= new String[numbers.length()];
		for(int i=0; i <arr.length ; i++) {
			arr[i]= numbers.substring(i,i+1);
		} // 배열만들기,   아직 문자. 
		System.out.println(Arrays.toString(arr));
		int[] nums=new int[factorial(numbers.length())];
		int digit=1;
		//for(int i=0;  )
		
		return 0;
	}
	
	public static int factorial(int num) {
		int factorial=1;
		for(int i=2; i<=num ; i++) {
			factorial*=i;
		}
		return factorial;
	}
	
	public static boolean isPrime(int num) {
		int checkNum= (int)Math.sqrt(num);    //root
		boolean isPrime=true;
		for(int i=2; i<checkNum ; i++) {
			if(num %i==0) isPrime=false;
		}
		return isPrime;
	}
	

}
