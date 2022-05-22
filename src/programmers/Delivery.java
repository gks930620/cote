package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class Delivery {
	//함정이 있네... 방향이 없는것처럼 문제는 설명하지만 실제 코드로 구현해보면 방향을 생각해야되서...  끊겨진게 나올 수 있네..
	public static void main(String[] args) {
		int N = 5;
		int K = 3;
		int[][] road = { { 1, 2, 1 }, { 2, 3, 3 }, { 5, 2, 2 }, { 1, 4, 2 }, { 5, 3, 1 }, { 5, 4, 2 } };
		System.out.println(solution(N, road, K));

	}

	public static int solution(int N, int[][] road, int K) {
		// 보통 배열로 하는데 배열로도 해보고, Edge로도 해보자.
		HashMap<Integer, Integer> map = new HashMap<>();
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.distance - o2.distance); // 앞에거-뒤에거가 일반적으로 오름차순

		for (int i = 1; i <= N; i++) {
			map.put(i, Integer.MAX_VALUE);
		}
		map.put(1, 0);
		pq.add(new Edge(1, map.get(1))); // 1에서 1가는거는 0, 나머지는 일단 무한대.
		while (pq.size() > 0) {
			// 현재 노드 잘 쓰고
			Edge edge = pq.poll();
			int curDistance = edge.distance;
			int curNode = edge.node;

			if (map.get(curNode) < curDistance) {
				continue;
			}
			
			//현재 노드의 간선 찾기
			ArrayList<Edge> nodeList= new ArrayList<>();  //처음만 생각해보면 1 ->2,  1->4   2개 있음
			for (int i = 0; i < road.length; i++) {
				if(road[i][0]== curNode ) {
					nodeList.add(new Edge(road[i][1], road[i][2]));
				}else if(road[i][1]==curNode) {
					nodeList.add(new Edge(road[i][0], road[i][2])); 
				}//1->2 가나  2->1 가나 모두 넣어야됨       안그러면 끊김 예제값으로 주어진건 방향이 있는거지만, 우리가 구해야하는 경우는 방향이 없음.
			}
			System.out.println("현재 노드 : " + curNode);
			System.out.println("모든 간선 : " +nodeList);   
			
			for(Edge node : nodeList) {
				int adjecent=node.node;
				int distance= curDistance+ node.distance;
				if(distance< map.get(adjecent)) {
					pq.add(new Edge(adjecent, distance));
					map.put(adjecent, distance);
				}
				
			}
		}
		System.out.println(map);
		int answer = 0;
		for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
			if(entry.getValue()<=K) answer++;
		}
		
		return answer;
	}

	public static class Edge {
		int node;
		int distance;
		
		

		@Override
		public String toString() {
			return "Edge [node=" + node + ", distance=" + distance + "]";
		}



		public Edge(int node, int distance) {
			this.node = node;
			this.distance = distance;
		}

	}

}
