package fastcampus.algori;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class FractionalBag {
	public static void main(String[] args) {
		Integer[][] list = { { 10, 10 }, { 15, 12 }, { 20, 10 }, { 25, 8 }, { 30, 5 } };
		FractionalBag f = new FractionalBag();
		Edge edge1 = f.new Edge(15, "A");
		Edge edge2 = f.new Edge(10, "A");
		Edge edge3 = f.new Edge(13, "A");
		Edge[] edges = new Edge[] { edge1, edge2, edge3 };
		Arrays.sort(edges);
		for (Edge ed : edges) {
			System.out.println(ed.disance);
		}
		//comparable보다는 Comparator가 많이 쓰인다.
//		Arrays.sort(edges, new Comparator<Edge>() {
//			@Override
//			public int compare(Edge o1, Edge o2) {
//				return o2.disance - o1.disance;
//			}
//		});
//		Arrays.sort(edges, (o1, o2) -> 
//			 o2.disance - o1.disance
//		);
		
	}

	public class Edge implements Comparable<Edge> {
		public Integer disance;
		public String vertex;

		public Edge(Integer distance, String vertex) {
			this.disance = distance;
			this.vertex = vertex;
		}

		// 본은 오름차순
		@Override
		public int compareTo(Edge o) {
			return this.disance - o.disance;
		}

	}

}
