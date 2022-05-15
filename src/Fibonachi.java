
public class Fibonachi {
	//DP·Î 
	public static void main(String[] args) {
		System.out.println(fibonachi(10));
		System.out.println(dynamicFunc(10));
	}
	
	
	public static int fibonachi(int n) {
		if(n==0) return 0;
		if(n==1) return 1;
		return fibonachi(n-1)+fibonachi(n-2);
	}
	
	public static int dynamicFunc(int data) {
		Integer[] cache= new Integer[data+1];
		cache[0]=0;
		cache[1]=1;
		for(int i=2; i<data+1 ; i++) {
			cache[i]=cache[i-1]+cache[i-2];
		}
		return cache[data];
		
		
	}
	
}
