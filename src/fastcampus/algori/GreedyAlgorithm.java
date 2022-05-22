package fastcampus.algori;
import java.util.Arrays;

public class GreedyAlgorithm {
	public static void main(String[] args) {
		Integer[][] list = { { 10, 10 }, { 15, 12 }, { 20, 10 }, { 25, 8 }, { 30, 5 } };
		knapsackFunc(list, 30);
	}
	
	public static void knapsackFunc(Integer[][] list,double capacity) {
		double totalValue=0.0;
		double fraction=0.0;
		Arrays.sort(list, (o1,o2) -> {return o2[1]/o2[0]-o1[1]/o1[0];}    );
		//무게당 가치순으로 정렬,  
		for(int i=0; i<list.length ; i++) {
			if((capacity - (double)list[i][0] > 0)) {
				//수용량이 무게보다 크면 
				capacity-=(double)list[i][0];
				totalValue+=(double)list[i][1];
				System.out.println("무게" +list[i][0] +"가치"+list[i][1]);
			}else {
				fraction=capacity/(double)list[i][0];  //어차피 한번에 다 넣음
				totalValue+=(double)list[i][1]*fraction;
				System.out.println("무게" +list[i][0] +"가치"+list[i][1]);
				break;  //꽉차는거니까 빼
			}
		}
		System.out.println("총 가치" + totalValue);
	}
}
