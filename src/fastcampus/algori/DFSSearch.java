package fastcampus.algori;
import java.util.ArrayList;
import java.util.HashMap;

public class DFSSearch {
	public ArrayList<String> dfsFunc(HashMap<String,ArrayList<String>> graph,String startNode){
		ArrayList<String> visited=new ArrayList<String>();
		ArrayList<String> needVisit=new ArrayList<String>();
		needVisit.add(startNode);
		
		while(needVisit.size()>0) {
			String node=needVisit.remove(needVisit.size()-1);
			if( !visited.contains(node)) { //방문한적이있나, 즉visited에 없으면
				visited.add(node);
				needVisit.addAll(graph.get(node));
			}
		}
		
		return visited; //방문한 순서에러
	}
}
