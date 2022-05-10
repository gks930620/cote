import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main2108 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr= new int[n];
		int sansul=0;  //산술평균  sigma(n)/n
		int middle=0;  //정렬 후 가운데 값
		int choibin=0; // 가장 많이 나타나는 값
		int maxMin=0;   // 최대 -최소
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}
		Arrays.sort(arr);
		sansul=sansul(arr);
		middle= arr[n/2];
		choibin=choibin(arr);
		maxMin= arr[arr.length-1]-arr[0];
		System.out.println(sansul);
		System.out.println(middle);
		System.out.println(choibin);
		System.out.println(maxMin);
	}
	
	
	public static int sansul(int[] arr) {
		int sum=0;
		for(int i=0; i<arr.length; i++) {
			sum+=arr[i];
		}
		int sansulAvg=(int)Math.round( sum/(double)arr.length);
		return sansulAvg;
	}
	
	public static int choibin(int[] arr) {
		Map<Integer,Integer> map= new HashMap<Integer, Integer>();
		//배열의 특정값,  그 값의 개수
		for(int i=0; i<arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i],0)+1  );
		}

		int maxCount=0; //가장 개수가 많은 거 찾자  
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() >maxCount) {
				maxCount=entry.getValue();
			}
		}
		
		//개수같은 거 조사.. 그중에서 2번째로 작은거 처리
		ArrayList<Integer> list=new ArrayList<Integer>();
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(maxCount==entry.getValue()) {  //무조건 1번은 통과하지.
				list.add(entry.getKey());
			}
		}
		Collections.sort(list);
		return list.size()>=2 ? list.get(1) :list.get(0);
	}
	
	
}
