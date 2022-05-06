package sort;

import java.util.Random;

public class ARandom {

	public static int[] randomArray(int arrSize, int max) {
		Random random= new Random();
		int[] arr= new int[arrSize];
		for(int i=0; i<arrSize; i++) {
			arr[i]= random.nextInt(max);
		}
		return arr;
	}
	
	//max가 arrSize보다는 커야지
	public static int[] randomArrayNoDup(int arrSize, int max) {
		Random random= new Random();
		int[] arr= new int[arrSize];
		for(int i=0; i<arrSize; i++) {
			boolean noDup=true;
			 int ri=random.nextInt(max);
			for(int j=0; j<arr.length; j++) {
				if(ri==arr[j]) {
					noDup=false;
				}
			}
			if(noDup) {
				arr[i]=ri;
			}else {
				i--;
			}
		}
		return arr;
	}
	
}
