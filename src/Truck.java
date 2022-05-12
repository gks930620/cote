import java.util.LinkedList;
import java.util.Queue;

public class Truck {
	
	public static void main(String[] args) {
		int[] arr= {7,4,5,6};
		System.out.println(solution(2, 10, arr));
	}
	//문제가 이상하다.  트럭올라가는 순서는 배열 순서대로
	// bridge length는 다리길이. 트럭이 1초에 1만큼 이동.  문제 설명에서는 다리길이 2
	//bridge_length 1초에 bridge_length 만큼 
	///weight은 버틸 수 있는 무게
	//truck무게 배열 
	//트럭이 올라가는 순서는 정해져있다. 최소시간을 구하는 방법을 찾는게 아니다. 이 순서대로 올라갔을 때 걸리는 시간을 구하는거
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		//queue다 
		Queue<Integer> que=new LinkedList<Integer>();
		
		int sum=0;
		int time=0;
		for(int i=0; i<truck_weights.length ; i++) { // 트럭이 다 지나가야하니까 for문인데
			while(true) { 
				if(que.isEmpty()) { //비어있는 경우
					que.add(truck_weights[i]);
					sum+=truck_weights[i];
					time++; // 집어넣으면서 1초 증가
					break;
				}else if(que.size()==bridge_length) {  //트럭이 다리길이만큼 꽉 찬 경우
					sum-=que.poll(); //빼자마자 늘거니까 time++하면 안되지
				}else { //다리길이만큼 큐가 없음
					if(sum+truck_weights[i] <=weight){
						que.add(truck_weights[i]);
						sum+=truck_weights[i];
						time++;
						break;
					}else {
						que.add(0);
						time++;
					}
				}
			}
		}
		
		
		return time+bridge_length;
	}
	
	
}


















