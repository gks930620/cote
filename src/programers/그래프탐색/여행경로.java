package programers.그래프탐색;

import java.util.*;

public class 여행경로 { //실패  다시해보자.
    public static void main(String[] args) {
        String[][] tickets= {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        String[][] tickets2= {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};

        String[][] tickets3= {{"ICN", "SFO"},{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        List<String> solution = new 여행경로().solution(tickets2);
        System.out.println(solution);
    }

    //중복이 허용, + 알파벳순서로 갔을 때 모든 경로 가는 걸 보장하지 않음 => 도시가 남아있을 때는  다른 경로를 탐색하도록 구성해야지..
    //문제 자체가 dfs로 풀도록 되어있는 문제인데..
    Map<String, List<String>> map = new HashMap<>();
    List<String> answer = new ArrayList<>();
    public List<String> solution(String[][] tickets) {
        for (String[] ticket : tickets) {
            String start = ticket[0];
            String end = ticket[1];
            map.put(start,map.getOrDefault(start,new LinkedList<>())     );
            map.get(start).add(end);
        }
        for(Map.Entry<String ,List<String >> entry : map.entrySet()){
            entry.getValue().sort(null);
        }

        dfs("ICN");  //다 썻는지 확인을 어케하냐..  //모르겠다..
        if(answer.size() < tickets.length+1  ){ //항공권 다 못 쓴건데..

        }



        return  answer;
    }

    public void dfs(String x ){
        //x에 온걸로 간주
        answer.add(x);

        //for   x에서 갈 수 있는 모든 점   정렬되어있음..
        List<String> list = map.get(x);
        if(list==null)  return; //최종목적지
        for(int i=0 ; i<list.size() ; i++){
            String y= list.get(i);  //다음 목저지
            list.remove(i--);  //다음 목적지로 간다면   항공권 쓴거
            dfs(y);  //다음 목적지로 간다.
        }
    }


}















