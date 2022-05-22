package fastcampus.algori;
import java.util.ArrayList;
import java.util.HashMap;

public class BFSSearch {
	public ArrayList<String> bfsFunc(HashMap<String,ArrayList<String>> graph,String startNode){
		ArrayList<String> visited=new ArrayList<String>();
		ArrayList<String> needVisit=new ArrayList<String>();
		needVisit.add(startNode);
		
		
		
		while(needVisit.size()>0) {
			String node=needVisit.remove(0);
			if( ! visited.contains(node)) { //방문을 안했다면
				visited.add(node); //방문한걸로 기억하자.
				needVisit.addAll(graph.get(node));   //그 노드에서 방문해야되는 모든 곳 추가
			}
		}
			
		return visited; //방문한 순서에러
	}
}
