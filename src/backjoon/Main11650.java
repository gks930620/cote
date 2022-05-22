package backjoon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main11650 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[][] arr= new int[n][2];  //{ {0.2},{2.3}  }  

		for(int i=0; i<arr.length ; i++) {
			arr[i][0]=sc.nextInt();
			arr[i][1]=sc.nextInt();
		}
		Arrays.sort(arr, (o1,o2) -> {
				if(o1[0]==o2[0]) { return o1[1]-o2[1];}
				else {
					return o1[0]-o2[0];
				}
		});
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i][0] + " ");
			System.out.println(arr[i][1]);
		}
		
	}
}
