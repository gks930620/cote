package fastcampus.algori;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Dikjstra {
	public static void main(String[] args) {
		HashMap<String, ArrayList<Edge>> graph = new HashMap<String, ArrayList<Edge>>();
		graph.put("A", new ArrayList<Edge>(Arrays.asList(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D"))));
		graph.put("B", new ArrayList<Edge>());
		graph.put("C", new ArrayList<Edge>(Arrays.asList(new Edge(5, "B"), new Edge(2, "D"))));
		graph.put("D", new ArrayList<Edge>(Arrays.asList(new Edge(3, "E"), new Edge(5, "F"))));
		graph.put("E", new ArrayList<Edge>(Arrays.asList(new Edge(1, "F"))));
		graph.put("F", new ArrayList<Edge>(Arrays.asList(new Edge(5, "A"))));

		HashMap<String, Integer> mindistance = dijkstraFunc(graph, "A");
		System.out.println(mindistance);

	}

	// A에서 모든 경로의 최소값 구하는거다. 여기는 다시 써보자. Map을 잘 쓰자.
	public static HashMap<String, Integer> dijkstraFunc(HashMap<String,ArrayList<Edge>> graph,String start){
		HashMap<String, Integer> distances= new HashMap<>();
		for(String key  : graph.keySet()) {
			distances.put(key, Integer.MAX_VALUE);   //현재 가장 큰 값들이 들어가있음
		} 
		//start 초기화   0으로
		distances.put(start, 0);
		PriorityQueue<Edge> priorityQueue=new PriorityQueue<>();
		priorityQueue.add(new Edge(distances.get(start), start));  //사실 그냥 0 넣었어도 되는데, 의미 명확히..
		
		while(priorityQueue.size()>0) {
			Edge edge=priorityQueue.poll();
			int curDistance=edge.distance;
			String curNode= edge.vertex;
			
			//사실 else로 처리해도 되는데..    아무것도 안하고 poll 하는 거 명확히 하려고
			if(curDistance> distances.get(curNode)) {
				continue;
			}
			
			//모든 노드를 검사해야지   poll 한게  C라면..
			ArrayList<Edge> nodeList=graph.get(curNode);   // 현재 C 이면 C의 노드들...
			// C에서 B,D의 노드가 있다면  저  distance는   현재  A에서 C까지 가는거 + C에서 B까지 가는거.           이걸 그냥 A에서 B로 가는거랑 비교해야된다.  작으면
			for(Edge node  : nodeList) {  
				String adjacent=node.vertex;
				int weight=node.distance;
				int distance = curDistance + weight;
				if( distance < distances.get(adjacent)) {
					distances.put(adjacent, distance);
					priorityQueue.add(new Edge(distance, adjacent));
					
				}
					
			}
		}
		return distances;
	}



	public static class Edge implements Comparable<Edge> {
		public int distance;
		public String vertex;

		public Edge(int distance, String vertex) {
			super();
			this.distance = distance;
			this.vertex = vertex;
		}

		@Override
		public String toString() {
			return "Edge [distance=" + distance + ", vertex=" + vertex + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return this.distance - o.distance; // 현재 거리보다 짧은것만 가져오겠다.
			// 큰게 뒤로간다 => 작은게 우선순위가 높아질거다.
		}

	}

}
